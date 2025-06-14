/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package faculdade.cefsa.edu.br.exercicio4_produto;

import java.util.Scanner;
/**
 *
 * @author 081240030
 */
public class Exercicio4_Produto {

    public static void main(String[] args) {
        
        Scanner leitor = new Scanner(System.in);
        Produto produto = new Produto("Camiseta" , 10.00 , 15);
        
        int opcao;
        
        System.out.println("O que deseja Realizar: ");
        System.out.println("1 - Adicionar ao estoque ");
        System.out.println("2 - Vender ");
        System.out.println("3- Ver valor total em estoque");
        opcao = leitor.nextInt();

      
        switch(opcao){
        
            case 1:
              System.out.print("Digite a quantidade: ");
              int qtd = leitor.nextInt();
              produto.Repor(qtd);
            break;
            
            case 2:
                System.out.println("Digite a quantidade: ");
                int qtdvenda = leitor.nextInt();
                produto.Vende(qtdvenda);
            break;
            
            case 3:
                produto.ValorTotal();
            break;
            
            
            
       }
    }
}

