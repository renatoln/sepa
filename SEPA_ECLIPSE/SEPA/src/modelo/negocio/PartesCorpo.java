/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.negocio;

/**
 *
 * @author usuario
 */
public class PartesCorpo {
    private int id;
    private String nome;


    public PartesCorpo(int id,String nome){
		this.id = id;
		this.nome = nome;
    }

     public PartesCorpo(String nome){
		this.nome = nome;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String toString(){
		return "Nome: "+this.nome;
    }
}
