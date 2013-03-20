/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.bd;

import modelo.negocio.Prontuario;
import java.sql.ResultSet;
import modelo.bd.ProfissionalDao;
import java.util.Vector;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
public class ProntuarioDao {

    PacienteDao pacienteDao = new PacienteDao();
    ProfissionalDao profissionalDao = new ProfissionalDao();
    BDMySql bdMySql = BDMySql.getInstance();

    public String[][] listaProntuario() {
        ResultSet rs = bdMySql.executarBuscaSQL("SELECT  Profissional_idProfissional, Paciente_idPaciente FROM prontuario where idProntuario ");
        String lista[][] = new String[bdMySql.getRowCount(rs)][];
        try {
            int i = 0;
            while (rs.next()) {
                String l[] = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)};
                lista[i++] = l;

            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return lista;

    }

    public Prontuario getProntuario(int id) {
        String sql = "SELECT  Profissional_idProfissional, Paciente_idPaciente FROM prontuario where idProntuario = " + id;
        ResultSet rs = bdMySql.executarBuscaSQL(sql);

        Prontuario p = null;

        try {
            if (rs.next()) {

                p = new Prontuario(id, profissionalDao.getProfissional(rs.getInt(1)), pacienteDao.getPaciente(rs.getInt(2)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }

    public void cadastraProntuario(Prontuario p) {
        String sql = "insert into prontuario(Paciente_idPaciente, Profissional_idProfissional) values ('"
                + p.getPaciente().getId() + "','" + p.getProfissional().getId_profissional() + "')";
        bdMySql.executarSQL(sql);
    }

    public void atualizaSetor(Prontuario p) {

        String sql = "update prontuario set Paciente_idPaciente = '" + p.getPaciente() + "',"
                + " Profissional_idProfissional= '" + p.getProfissional() + "'"
                + " where idProntuario = " + p.getIdProntuario();

        bdMySql.executarSQL(sql);
    }

    public void deletaSetor(int id) {
        String sql = "delete from prontuario where idProntuario = " + id;

        bdMySql.executarSQL(sql);
    }

    public Vector<Prontuario> getProntuarios() {
        ResultSet rs = bdMySql.executarBuscaSQL("SELECT idProntuario, Profissional_idProfissional ,Paciente_idPaciente FROM prontuario ");
        Prontuario p = null;
        Vector<Prontuario> prontuarios = new Vector<Prontuario>();
        try {
            while (rs.next()) {
                
                p = new Prontuario(rs.getInt(1),profissionalDao.getProfissional(rs.getInt(2)), pacienteDao.getPaciente(rs.getInt(3)));
                prontuarios.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prontuarios;
    }
}
