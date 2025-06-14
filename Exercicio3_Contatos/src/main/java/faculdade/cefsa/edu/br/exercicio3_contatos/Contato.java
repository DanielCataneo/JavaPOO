/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package faculdade.cefsa.edu.br.exercicio3_contatos;

/**
 *
 * @author 081240030
 */
public class Contato {
    
    private String Nome;
    private String Telefone;
    private String Email;

    public Contato(String Nome, String Telefone, String Email) {
        this.Nome = Nome;
        this.Telefone = Telefone;
        this.Email = Email;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
        
    public void exibirContato() {
        System.out.println();
        System.out.println("Nome: " + Nome);
        System.out.println("Telefone: " + Telefone);
        System.out.println("Email: " + Email);
        System.out.println("-----------------------");
    }
}
