/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package faculdade.cefsa.edu.br.exercicio1_banco;

/**
 *
 * @author 081240030
 */
public class Conta {
    
    private String Titular;
    private int ID;
    private double Saldo;

    public Conta(String Titular, int ID) {
        this.Titular = Titular;
        this.ID = ID;
        Saldo = 0.0;
    }

    public String getTitular() {
        return Titular;
    }

    public void setTitular(String Titular) {
        this.Titular = Titular;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getSaldo() {
        return Saldo;
    }

    public void setSaldo(double Saldo) {
        this.Saldo = Saldo;
    }
    
    public void Deposito(double value)
    {   
        Saldo += value;
        System.out.println("Valor depositado com sucesso + " + value);
    }
    
    public void Saque(double value){
        if(Saldo < value){
            System.out.println("Não foi possível realizar o deposito" );
        }
        else{
            Saldo -= value;
                System.out.println("Saque realizado com sucesso - " + value);
        }
    }
    
    public void Verificar(){
        System.out.println("Titular: " + Titular);
        System.out.println("ID: " + ID);
        System.out.println("SALDO DA CONTA: R$ " + Saldo);
    }
    
    
}
