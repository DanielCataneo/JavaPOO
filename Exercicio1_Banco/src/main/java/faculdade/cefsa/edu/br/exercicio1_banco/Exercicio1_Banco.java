/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package faculdade.cefsa.edu.br.exercicio1_banco;

import java.util.Scanner;

/**
 *
 * @author 081240030
 */
public class Exercicio1_Banco {

    public static void main(String[] args) {
            
        Scanner leitor = new Scanner(System.in);
       
        Conta conta = new Conta("Daniel Cataneo",130);
        
        
        int opcao;
        
        System.out.println("O que deseja realizar: ");
        System.out.println("1 - Deposito ");
        System.out.println("2 - Saque");
        System.out.println("3 - Consulta Conta");
        opcao = leitor.nextInt();

        switch(opcao){
            
            case 1:
                System.out.print("Valor do depósito: ");
                double deposito = leitor.nextDouble();
                conta.Deposito(deposito);
            break;
            
            case 2:
                System.out.print("Valor do saque: ");
                double saque = leitor.nextDouble();
                conta.Saque(saque);
            break;
            
            case 3:
              conta.Verificar();
            break;
           
            default:
                break;
        }
    
    }
}
