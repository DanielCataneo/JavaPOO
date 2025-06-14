/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package faculdade.cefsa.edu.br.exercicio4_produto;

/**
 *
 * @author 081240030
 */
public class Produto {
    
    public String Nome;
    public double Preco;
    public int QTD;

    public Produto(String Nome, double Preco, int QTD) {
        this.Nome = Nome;
        this.Preco = Preco;
        this.QTD = QTD;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public double getPreco() {
        return Preco;
    }

    public void setPreco(double Preco) {
        this.Preco = Preco;
    }

    public int getQTD() {
        return QTD;
    }

    public void setQTD(int QTD) {
        this.QTD = QTD;
    }
    
    public void Vende(int qtd){
        QTD -= qtd;
        System.out.println("Quantidade vendida com sucesso: - " + qtd);
        System.out.println("Nova Quantidade em estoque: " + QTD);
    }
    
    public void Repor(int qtd){
        QTD += qtd;
        System.out.println("Quantidade adicionada com sucesso: + " + qtd);
        System.out.println("Nova Quantidade em estoque: " + QTD);
    }
    
    public void ValorTotal(){
        double soma = 0.0;
        soma += QTD * Preco;
        System.out.println("Valor total R$: " + soma);
    }
}
