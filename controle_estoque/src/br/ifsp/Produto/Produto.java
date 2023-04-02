package br.ifsp.Produto;
public class Produto {

    private int cod;
    private String desc;
    private String marca;
    private int qtd = 0;
    private double preco;
    private double valor;
    
    public Produto (){}
    
    public Produto(int c, String d, String m, int quant, double p){
        setCodigo(c);
        setDesc(d);
        setMarca(m);
        setPreco(p);
        setQuant(quant);
    }
    
    public int getCodigo() {
        return this.cod;
    }
    public void setCodigo(int c) {
        this.cod = c;
    }
    
    public String getDesc(){
        return this.desc;
    }
    public void setDesc(String d){
        this.desc = d;
    }
    
    public String getMarca(){
        return this.marca;
    }
    public void setMarca(String m){
        this.marca = m;
    }
    
    public int getQuant(){
        return this.qtd;
    }      
    public void setQuant(int quant){
        this.qtd = quant;
    }
    
    public double getPreco(){
        return this.preco;
    }
    public void setPreco(double p){
        this.preco = p;
    }
    
    public double getReajustar(double percent){
        return this.preco += percent/100;
    }
    
    public double getReajuste(){
        return this.preco;
    }
    
    public int getComprar(int qtd_compra){
        return this.qtd += qtd_compra;
    }
    
    public int getVenda(int qtd_venda){
        if(qtd_venda > this.qtd){
            System.out.println("ERRO: Quantidade maior que o estoque!");
        }
        return this.qtd-= qtd_venda;
    }
    
    public double getValorEstoque(){
        return valor = this.qtd * (double)this.preco;
    }   
    
    public void tostring(){
        System.out.println("Codigo: " + this.getCodigo());
        System.out.println("Descricao: " + this.getDesc());
    }

}
