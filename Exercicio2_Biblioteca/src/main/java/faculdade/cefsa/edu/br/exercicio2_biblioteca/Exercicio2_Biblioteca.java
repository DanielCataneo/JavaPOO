/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package faculdade.cefsa.edu.br.exercicio2_biblioteca;

import java.util.Scanner;

public class Exercicio2_Biblioteca {

    public static void main(String[] args) {
        
        Livro livro = new Livro("Harry Potter", "J.K Rowling" , 150);
        
        Scanner leitor = new Scanner(System.in);
        
        
        int opcao;
        
        System.out.println("Deseja realizar o emprestimo: ");
        System.out.println("1 - Sim ");
        System.out.println("2 - Nao ");
        opcao = leitor.nextInt();

        switch(opcao){
            
            case 1:
                livro.Emprestimo();
            break;
            
            case 2:
                System.out.println("Programa encerrado");
            break;
            
        }
    }
}
