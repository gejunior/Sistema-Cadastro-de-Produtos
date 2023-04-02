package br.ifsp.produtoview;

import br.ifsp.Produto.Produto;
import br.ifsp.gerenciarproduto.GerenciarProduto;
import java.util.Scanner;

public class ProdutoView {
    private final Scanner teclado = new Scanner (System.in);
    private final GerenciarProduto gerenciarProduto = new GerenciarProduto();
    
    public void apresentarMenu() {
        int op;
        Produto p = new Produto();
        
        do{
            System.out.println("============= Menu ============");
            System.out.println("[1] Cadastrar produto");
            System.out.println("[2] Remover produto");
            System.out.println("[3] Pesquisar produto");
            System.out.println("[4] Reajustar valor do produto");
            System.out.println("[5] Comprar produto");
            System.out.println("[6] Vender produto");
            System.out.println("[7] Apresentar dados dos produtos");
            System.out.println("[8] Apresentar balanco");
            System.out.println("[0] Sair!");
            System.out.println("===============================");
            op = teclado.nextInt();
            
            switch (op) {
                case 1: //cadastrar
                    add();
                    
                    break;                    
                case 2: //remover
                    remove(p);

                    break;
                case 3: //pesquisar
                    pesquisar(p);

                    break;
                case 4: //reajustar
                    reajustar(p);

                    break;
                case 5: //comprar
                    comprar(p);
                    
                    break;
                case 6: //vender
                    vender(p);

                    break;
                case 7: //apresentar todos os produtos
                    System.out.println("\tProdutos cadastrados");
                    System.out.println("___________________________________________");
                    gerenciarProduto.apresentarTodos();

                    break;
                case 8: //apresentar balanço dos produtos
                    System.out.println("\tValor de estoque:");
                    System.out.println("___________________________________________");
                    gerenciarProduto.balanco();

                    break;
                case 0:
                    System.out.println("Saindo!");
                    break;
                default:
            }
        }while(op != 0);
    }
    
    private void add() {
        System.out.println("\tCadastrar");

        System.out.println("Digite o codigo do produto: ");
        int cod = teclado.nextInt();
        
        if(cod > 0){
            System.out.println("Digite a descricao do produto: ");
            String desc = teclado.next();
            teclado.nextLine();

            System.out.println("Digite a marca do produto: ");
            String marca = teclado.next();

            System.out.println("Digite a quantidade do produto: ");
            int qtd = teclado.nextInt();

            System.out.println("Digite o preco do produto: ");
            double preco = teclado.nextDouble();
            
            Produto produto = new Produto(cod, desc, marca, qtd, preco);
            gerenciarProduto.adicionar(produto);
        }
    }
        
    private void remove(Produto p) {
        System.out.println("\tRemover");
        System.out.println("Digite o codigo do produto: ");
        int cod = teclado.nextInt();
        
        p = gerenciarProduto.pesquisar(p, cod);
        gerenciarProduto.apresentar(p);
        gerenciarProduto.remove(p, cod);
    }

    private void pesquisar(Produto p) {
        System.out.println("\tPesquisa");
        
        gerenciarProduto.apresentarCod();
        
        System.out.println("Digite o codigo do produto");
        int cod = teclado.nextInt();
        
        p = gerenciarProduto.pesquisar(p, cod);
        if(p != null){
            gerenciarProduto.apresentar(p);
        }
    }

    private void reajustar(Produto p) {
            System.out.println("\tReajustar");
            
            gerenciarProduto.apresentarVal();
            
            System.out.println("Digite o codigo do produto: ");
            int cod = teclado.nextInt();
            
            p = gerenciarProduto.pesquisar(p, cod);
            
            if(p != null){
                System.out.println("Qual eh a porcentagem de almento (1 ou 100): ");
                int percent = teclado.nextInt();

                gerenciarProduto.reajustar(p, percent);
            }
        }
    
    private void comprar(Produto p){
        System.out.println("\tComprar");
        
        gerenciarProduto.apresentarQuant();
        
        System.out.println("Digite o codigo do produto: ");
        int cod = teclado.nextInt();
        
        p = gerenciarProduto.pesquisar(p, cod);
        
        if (p != null){
            System.out.println("Digite uma quantidade maior que ZERO: ");
            int quant = teclado.nextInt();
            
            if(quant != 0){
                gerenciarProduto.comprar(p, quant);
            }else {
                System.out.println("ERRO: Valor inválido!");
            }
        }
        gerenciarProduto.apresentarQuant();
    }
    
    private void vender (Produto p){
        System.out.println("\tVender");
        
        gerenciarProduto.apresentarVal();
        
        System.out.println("Digite o codigo do produto: ");
        int cod = teclado.nextInt();
        
        p = gerenciarProduto.pesquisar(p, cod);
        
        System.out.println("Digite a quantidade: ");
        int quant = teclado.nextInt();
            
        gerenciarProduto.vender(p, quant);
        gerenciarProduto.apresentarQuant();
        gerenciarProduto.apresentarVal();
    }
}
