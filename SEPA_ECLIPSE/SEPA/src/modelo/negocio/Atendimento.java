/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.negocio;

/**
 *
 * @author Lay and Lary
 */
public class Atendimento {
   private int idAtendimento;
   private String data;
   private String horario;
   private String descricao;
   private Paciente paciente;
   private Prontuario prontuario;
   
   public Atendimento(int id, String data,String horario,String descricao,Prontuario prontuario){
   
       this.idAtendimento = id;
       this.data = data;
       this.horario = horario;
       this.descricao = descricao;
       this.prontuario = prontuario;
       
   }
   
   public Atendimento( String data,String horario,String descricao,Prontuario prontuario){
   
    
       this.data = data;
       this.horario = horario;
       this.descricao = descricao;
       this.prontuario = prontuario;
       
   }

    /**
     * @return the idAtendimento
     */
    public int getIdAtendimento() {
        return idAtendimento;
    }

    /**
     * @param idAtendimento the idAtendimento to set
     */
    public void setIdAtendimento(int idAtendimento) {
        this.idAtendimento = idAtendimento;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the horario
     */
    public String getHorario() {
        return horario;
    }

    /**
     * @param horario the horario to set
     */
    public void setHorario(String horario) {
        this.horario = horario;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the paciente
     */
    public Paciente getPaciente() {
        return paciente;
    }

    /**
     * @param paciente the paciente to set
     */
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    /**
     * @return the prontuario
     */
    public Prontuario getProntuario() {
        return prontuario;
    }

    /**
     * @param prontuario the prontuario to set
     */
    public void setProntuario(Prontuario prontuario) {
        this.prontuario = prontuario;
    }
   
    
}
