package br.ifsp.gerenciarproduto;

import br.ifsp.Produto.Produto;
import java.util.ArrayList;
import java.util.Scanner;

public class GerenciarProduto {

    private final ArrayList<Produto> listaProdutos = new ArrayList<>();
    Scanner teclado = new Scanner(System.in);

    public void adicionar(Produto p) {
        listaProdutos.add(p);
    }

    public Produto pesquisar(Produto p, int cod) {
        //listaProdutos.equals(cod);
        boolean produtoEncontrado = false;
        Produto Encontrado = new Produto();
        
        for(Produto produto : listaProdutos){
            if(produto.getCodigo() == cod){
                produtoEncontrado = true;
                Encontrado = produto;
                break;
            }
        }
        if(!produtoEncontrado){
            System.out.println("Produto nao encontrado!");
            Encontrado = null;
        }
        return Encontrado;
    }
    
    public void remove(Produto p, int cod) {
        listaProdutos.remove(p);
        System.out.println("Produto removido!");
    }
    
    public void comprar(Produto p, int qtd) {
        p.getComprar(qtd);
//        int tot = 0;
//        boolean Encontrar = false;
//        System.out.println("Digite o codigo do Produto...:");
//        int num = teclado.nextInt();
//
//        for (Produto produto : listaProdutos) {
//            if (produto.getCodigo() == num) {
//                //tot = produto.getComprar(qtd);
//                produto.setQuant(tot);
//                break;
//            }
//        }
//        if (!Encontrar) {
//            System.out.println("Produto nao encontrado!");
//        }
    }
    
    public void vender(Produto p, int qtd) {
        p.getVenda(qtd);
//        double valor;
//
//        if (p == null) {
//            System.out.println("Produto nao encontrado!");
//            
//        } else if (qtd > p.getQuant()) {
//            System.out.println("Quantidade em estoque insuficiente!!");
//            
//        } else {
//            valor = p.getPreco() * qtd;
//            p.setQuant(p.getQuant() - qtd);
//            
//            int novaQuant = p.getQuant() - qtd;
//            p.setQuant(novaQuant);
//
//            System.out.println("Valor da Venda: R$" + valor);
//        }
    }
    
    public void apresentar(Produto p) {
        System.out.println("Codigo: " + p.getCodigo());
        System.out.println("Descricao: " + p.getDesc());
        System.out.println("Marca: " + p.getMarca());
        System.out.println("Quantidade estoque: " + p.getQuant());
        System.out.println("Preco: " + p.getPreco());
    }
    public void apresentarTodos(){
        for (Produto p : listaProdutos) {
            System.out.println("Codigo: " + p.getCodigo());
            System.out.println("Descricao: " + p.getDesc());
            System.out.println("Marca: " + p.getMarca());
            System.out.println("Quantidade estoque: " + p.getQuant());
            System.out.println("Preco: " + p.getPreco());
            System.out.println("====================================");
        }
    }
    public void apresentarCod(){
        System.out.println("\tNome\t|   codigo");
        for (Produto p : listaProdutos){
            System.out.println("\t" + p.getDesc() + "\t|\t" + p.getCodigo());
        }
    }
    public void apresentarQuant(){
        System.out.println("\tNome\t|   codigo\t|    Quantidade");
        for (Produto p : listaProdutos){
            System.out.println("Produto: " + p.getDesc() + "\t|\t" + p.getCodigo() + "\t|\t" + p.getQuant());
        }
    }
    public void apresentarVal(){
        System.out.println("\tNome\t|   codigo\t|    tpreco");
        for (Produto p : listaProdutos){
            System.out.println("Produto: " + p.getDesc() + "\t|\t" + p.getCodigo() + "\t|\t" + p.getPreco());
        }
    }
    
    public void balanco() {
        double total = 0;
        System.out.print("Nome");
        System.out.print("\tPreco uni");
        System.out.print("\tQtd");
        System.out.println("\tTotal");
        for (Produto p : listaProdutos) {
            if (p.getValorEstoque() <= 0) {
                System.out.println("ERRO: Estoque vazio!");
                break;
            }
            System.out.println(p.getDesc() + "\t" + p.getPreco() + "\t\t" + p.getQuant() + "\t" + p.getValorEstoque());
            total += p.getValorEstoque();
        }
        if (total > 0) {
            System.out.println("Total: \tR$" + total);
            System.out.println("");
        }
    }
    
    public void reajustar(Produto produto, int percent){
        produto.getReajustar(percent);
    }
    
    public ArrayList<Produto> getListaProdutos() {
        return listaProdutos;
    }

}
