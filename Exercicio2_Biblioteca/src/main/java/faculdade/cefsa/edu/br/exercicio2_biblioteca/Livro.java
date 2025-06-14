/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package faculdade.cefsa.edu.br.exercicio2_biblioteca;

/**
 *
 * @author 081240030
 */
public class Livro {
    
    private String Titulo;
    private String Autor;
    private int Npag;
    private boolean SE;

    public Livro(String Titulo, String Autor, int Npag) {
        this.Titulo = Titulo;
        this.Autor = Autor;
        this.Npag = Npag;
        SE = false;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String Autor) {
        this.Autor = Autor;
    }

    public int getNpag() {
        return Npag;
    }

    public void setNpag(int Npag) {
        this.Npag = Npag;
    }

    public boolean isSE() {
        return SE;
    }

    public void setSE(boolean SE) {
        this.SE = SE;
    }
    
    public void Emprestimo(){
        if(SE == true){
            System.out.println("O livro não pode sem emprestado");
        }
        else 
        {
            System.out.println("O livro foi emprestado com sucesso");
        }
    }
    
    
    
    
}
