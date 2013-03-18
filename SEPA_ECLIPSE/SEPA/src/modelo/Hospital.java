/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author WELLITON
 */
public class Hospital {
    private int id_hospital;
    private String nome;
    private String endereco;
    private String responsavel;
    private String marca;
    private String telefone;

    public Hospital(int id_hospital, String nome, String endereco, String responsavel, String marca, String telefone) {
        this.id_hospital = id_hospital;
        this.nome = nome;
        this.endereco = endereco;
        this.responsavel = responsavel;
        this.marca = marca;
        this.telefone = telefone;
    }
    
    

    public int getId_hospital() {
        return id_hospital;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public String getMarca() {
        return marca;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setId_hospital(int id_hospital) {
        this.id_hospital = id_hospital;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return  nome ;
    }
    
}
