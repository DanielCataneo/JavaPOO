/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package faculdade.cefsa.edu.br.exercicio3_contatos;

import java.util.Scanner;



public class Exercicio3_Contatos {

    public static void main(String[] args) {
        
        Scanner leitor = new Scanner(System.in);
        Agenda agenda = new Agenda();
        
        System.out.println("Quantos contatos serao criados: ");
        int N = leitor.nextInt();
        
        for(int i = 0; i < N ; i++){
             System.out.print("Nome: ");
             String nome = leitor.next();
             System.out.print("Telefone: ");
             String telefone = leitor.next();
             System.out.print("Email: ");
             String email = leitor.next();
             
             agenda.AddContato(nome, telefone, email);
        }
        
        agenda.ExibirContatos();
        
        
    }
}
