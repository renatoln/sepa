/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.negocio;

/**
 *
 * @author Lay and Lary
 */
public class Prontuario {

    private int idProntuario;
    private Profissional profissional;
    private Paciente paciente;

    public Prontuario(int idProntuario, Profissional profissional, Paciente paciente) {

        this.idProntuario = idProntuario;
        this.paciente = paciente;
        this.profissional = profissional;

    }

    public Prontuario(Profissional profissional, Paciente paciente) {

        this.paciente = paciente;
        this.profissional = profissional;

    }

    /**
     * @return the profissional
     */
    public Profissional getProfissional() {
        return profissional;
    }

    /**
     * @param profissional the profissional to set
     */
    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
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
     * @return the idProntuario
     */
    public int getIdProntuario() {
        return idProntuario;
    }

    /**
     * @param idProntuario the idProntuario to set
     */
    public void setIdProntuario(int idProntuario) {
        this.idProntuario = idProntuario;
    }

    @Override
    public String toString() {
        return " " + this.idProntuario;
    }
}
