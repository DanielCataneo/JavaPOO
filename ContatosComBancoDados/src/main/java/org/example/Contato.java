package org.example;

public class Contato {

    private int ID;
    private String Nome;
    private String Telefone;

    public Contato(int ID, String nome, String telefone) {
        this.ID = ID;
        Nome = nome;
        Telefone = telefone;
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String telefone) {
        Telefone = telefone;
    }

    @Override
    public String toString() {
        return "Contato: "
                + "id=" + ID
                + ", nome='" + Nome + '\''
                + ", Telefone=" + Telefone;
    }

}
