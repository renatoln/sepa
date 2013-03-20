/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.negocio;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Lay and Lary
 */
public class Paciente {
    private int Id;
    private String nome;
    private String endereco;
    private String telefone;
    private String rg;
    private String dataNasc;
    private String cpf;

    /**
     * @return the nome
     */
    
    public Paciente(int Id,String nome,String endereco,String telefone,String rg,String dataNasc,String cpf){
        
        this.Id = Id;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
        this.endereco = endereco;
        this.nome = nome;
        this.rg =rg;
        this.telefone =telefone;
        
    
    }
    
     public Paciente(String nome,String endereco,String telefone,String rg,String dataNasc,String cpf){
        
        
        this.cpf = cpf;
        this.dataNasc = dataNasc;
        this.endereco = endereco;
        this.nome = nome;
        this.rg =rg;
        this.telefone =telefone;
        
    
    }
     
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the rg
     */
    public String getRg() {
        return rg;
    }

    /**
     * @param rg the rg to set
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    /**
     * @return the dataNasc
     */
    public String getDataNasc() {
        return dataNasc;
    }

    /**
     * @param dataNasc the dataNasc to set
     */
    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the Id
     */
    public int getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(int Id) {
        this.Id = Id;
    }

    @Override
    public String toString(){
        return this.Id+" - "+this.nome;

    }
    
}
