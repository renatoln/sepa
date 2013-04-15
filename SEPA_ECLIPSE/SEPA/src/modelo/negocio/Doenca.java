/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.negocio;



/**
 *
 * @author usuario
 */
public class Doenca {
    private String nome;
    private Area area;
    private int id;


    public Doenca (int id, String nome, Area area){
        this.id= id;
        this.nome= nome;
        this.area= area;
    }

  public Doenca( Area area, String nome){
                this.area= area;
		this.nome = nome;	

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

    /**
     * @return the area
     */
    public Area getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(Area area) {
        this.area = area;
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


    public String toString(){
		return this.nome;
    }
}

  

