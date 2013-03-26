/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.negocio;

import java.util.GregorianCalendar;

/**
 *
 * @author WELLITON
 */
public class Profissional {

    private int id_profissional;
     private String nome;
    private String usuario;
    private String senha;
    private String dtNascimento;
    private GregorianCalendar dataNascimento;
    private String cpf;
    private String endereco;
    private String email;
    private String noConcelho;
    private int tipo;
    private Hospital hospital;
    private Profissao profissao;
    private String telefone;
   

    public Profissional(int id_profissional, String nome, String usuario, String senha, String dtNascimento, String cpf, String endereco, String telefone, String noConcelho,String email,  int tipo, Hospital hospital, Profissao profissao) {
        this.id_profissional = id_profissional;
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        this.dtNascimento = dtNascimento;
        this.cpf = cpf;
        this.endereco = endereco;
        this.email = email;
        this.noConcelho = noConcelho;
        this.tipo = tipo;
        this.hospital = hospital;
        this.profissao = profissao;
        this.telefone = telefone;
    }

   public Profissional(String nome, String usuario, String senha, String dtNascimento, String cpf, String endereco,String telefone,  String noConcelho,String email,int tipo, Hospital hospital, Profissao profissao) {
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        this.dtNascimento = dtNascimento;
        this.cpf = cpf;
        this.endereco = endereco;
        this.email = email;
        this.noConcelho = noConcelho;
        this.tipo = tipo;
        this.hospital = hospital;
        this.profissao = profissao;
        this.telefone = telefone;
    }

  /*  public Profissional(int id_profissional, String nome, String usuario, String senha, GregorianCalendar dataNascimento, String cpf, String endereco, String email, String noConcelho, int tipo, Hospital hospital, Profissao profissao, String telefone) {
        this.id_profissional = id_profissional;
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.endereco = endereco;
        this.email = email;
        this.noConcelho = noConcelho;
        this.tipo = tipo;
        this.hospital = hospital;
        this.profissao = profissao;
        this.telefone = telefone;
    }
*/
  /*  public Profissional(String nome, String usuario, String senha, GregorianCalendar dataNascimento, String cpf, String endereco, String email, String noConcelho, int tipo, Hospital hospital, Profissao profissao, String telefone) {
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.endereco = endereco;
        this.email = email;
        this.noConcelho = noConcelho;
        this.tipo = tipo;
        this.hospital = hospital;
        this.profissao = profissao;
        this.telefone = telefone;
    }

    
    */
    
    public int getId_profissional() {
        return id_profissional;
    }

    public void setId_profissional(int id_profissional) {
        this.id_profissional = id_profissional;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setDtNascimento(String dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNoConcelho(String noConcelho) {
        this.noConcelho = noConcelho;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public void setProfissao(Profissao profissao) {
        this.profissao = profissao;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    public String getDtNascimento() {
        return dtNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getEmail() {
        return email;
    }

    public String getNoConcelho() {
        return noConcelho;
    }

    public int getTipo() {
        return tipo;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public GregorianCalendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(GregorianCalendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    

    @Override
    public String toString() {
        return nome;
    }

    public Profissao getProfissao() {
        return profissao;
    }

    public String getTelefone() {
        return telefone;
    }
   
    
    
    
}
