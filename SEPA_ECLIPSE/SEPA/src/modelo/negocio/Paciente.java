/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.negocio;

import java.util.GregorianCalendar;

/**
 *
 * @author casa
 */
public class Paciente {

    private int id;
    private String nome;
    private char sexo;
    private String endereco;
    private String telefone;
    private String rg;
    private GregorianCalendar dataNascimento;
    private String cpf;

    //o id é gerado pelo banco de dados
    //construtor utilizado para retornar dados do banco
    public Paciente(int id, String nome, char sexo, String endereco, String telefone, String rg,
            GregorianCalendar dataNascimento,String cpf) {
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
        this.endereco = endereco;
        this.telefone = telefone;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
    }

    //construtor utilizado para inserção
    public Paciente(String nome, char sexo, String endereco, String telefone, String rg,
            GregorianCalendar dataNascimento,String cpf) {
        this.nome = nome;
        this.sexo = sexo;
        this.endereco = endereco;
        this.telefone = telefone;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public GregorianCalendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(GregorianCalendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String toString() {
        return this.nome;
    }
}
