/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.negocio;

/**
 *
 * @author WELLITON
 */
public class Profissao {
     private int id_profissao;
      private String nome;

    public Profissao(int id_profissao, String nome) {
        this.id_profissao = id_profissao;
        this.nome = nome;
    }
      
      

    public int getId_profissao() {
        return id_profissao;
    }

    public String getNome() {
        return nome;
    }

    public void setId_profissao(int id_profissao) {
        this.id_profissao = id_profissao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return  nome ;
    }
      
    
}
