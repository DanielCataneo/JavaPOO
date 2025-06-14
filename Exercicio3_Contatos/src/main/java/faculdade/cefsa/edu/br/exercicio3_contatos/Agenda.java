/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package faculdade.cefsa.edu.br.exercicio3_contatos;

import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author 081240030
 */
public class Agenda {
    
    public List<Contato> cont = new ArrayList<>();
    
    public void AddContato(String nome , String telefone , String email){
        Contato contato = new Contato(nome , telefone, email);
        cont.add(contato);
    }
    
    public void ExibirContatos(){
        for(Contato contato : cont){
            contato.exibirContato();
        }
    }
    
    
}
