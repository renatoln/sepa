/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import modelo.Hospital;
import modelo.Profissional;

/**
 *
 * @author WELLITON
 */
public class ProfissionalDao {

    BDMySql bdMySql = BDMySql.getInstance();
    HospitalDao hospitalDao = new HospitalDao();
    ProfissaoDao profissaoDao =new ProfissaoDao();
    public String[][] listaProfissional() {
        ResultSet rs = bdMySql.executarBuscaSQL("Select idProfissional,nome,data_nascimento,cpf,endereco,telefone,numero_conselho,email,tipo_profissional, nome_profissao,nome_hospital from profissional"
                + " inner join profissao on Profissao_idProfissao =idProfissao"
                + " inner join hospital on Hospital_idHospital =idHospital");
        String lista[][] = new String[bdMySql.getRowCount(rs)][];
        try {/*
             String tipo= null;
             if(rs.getString(9).equals("0")){

             tipo="Administrador ";
             }
             if(rs.getString(9).equals("1")){

             tipo="Usuario ";
             }
             if(rs.getString(9).equals("2")){

             tipo="Saude ";
             }*/
            int i = 0;
            while (rs.next()) {
                String l[] = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11)};
                lista[i++] = l;
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public void cadastraProfissional(Profissional p) {
        String sql = "insert into profissional( nome,usuario,  senha,  data_nascimento, cpf, endereco,telefone,numero_conselho,email, tipo_profissional,Profissao_idProfissao,Hospital_idHospital )"
                + "values('" + p.getNome() + "','" + p.getUsuario() + "','" + p.getSenha() + "','" + p.getDtNascimento() + "','" + p.getCpf() + "','" + p.getEndereco() + "','" + p.getTelefone() + "','" + p.getNoConcelho() + "','" + p.getEmail() + "'," + p.getTipo() + "," + p.getProfissao().getId_profissao() + "," + p.getHospital().getId_hospital() + ")";
        bdMySql.executarSQL(sql);
    }

    public boolean getLoginCpfProfissional(String usuario,String senha) throws SQLException {
        ResultSet rs = bdMySql.executarBuscaSQL("select usuario, senha from profissional"+" where usuario = " +usuario+ "and senha ="+senha+"" );
        if (rs.next()) {
            return false;
        }
        return true;


    }
        public boolean getCpfProfissional(String cpf) throws SQLException {
        ResultSet rs = bdMySql.executarBuscaSQL("select *from profissional where cpf = " + cpf);
        if (rs.next()) {
            return false;
        }
        return true;


    }
        
    public Profissional getProfissional(int id) {
        ResultSet rs = bdMySql.executarBuscaSQL("Select idProfissional,nome,usuario,senha,data_nascimento,cpf,endereco,telefone,numero_conselho,email,tipo_profissional, Profissao_idProfissao,Hospital_idHospital from profissional where idProfissional=" + id);
             //   + " inner join hospital on Hospital_idHospital = idHospital"
             //   + " inner join profissao on Profissao_idProfissao =idProfissao where idProfissional=" + id);

        Profissional p = null;

        try {
            if (rs.next()) {

                p = new Profissional(id, rs.getString("nome"),rs.getString("usuario"), rs.getString("senha"),  rs.getString("data_nascimento"), rs.getString("cpf"), rs.getString("endereco"), rs.getString("telefone"), rs.getString("numero_conselho"), rs.getString("email"),
                        rs.getInt("tipo_profissional"),hospitalDao.getHospitalId(rs.getInt("Hospital_idHospital")) ,profissaoDao.getProfissaoId(rs.getInt("Profissao_idProfissao")));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }


    
    public void atualizaProfissional(Profissional p) {
        String sql = "update profissional set nome = '" + p.getNome() + "',"
                + "usuario = '" + p.getUsuario() + "',"
                + " senha = '" + p.getSenha() + "',"
                + " data_nascimento = " + p.getDtNascimento() + ","
                + " cpf = '" + p.getCpf() + "' "
                + " endereco = '" + p.getEndereco() + "' "
                + " telefone = '" + p.getTelefone() + "' "
                + " numero_conselho = '" + p.getNoConcelho() + "' "
                + " email = '" + p.getEmail() + "' "
                + " tipo_profissional = '" + p.getTipo() + "' "
                + " Profissao_idProfissao = '" + p.getProfissao().getId_profissao() + "' "
                + " Hospital_idHospital = '" + p.getHospital().getId_hospital() + "' "
                + " where id = " + p.getId_profissional();

        bdMySql.executarSQL(sql);
    }
    
    public void deletaProficional(int id) {
        String sql = "delete from profissional where idProfissional = " + id;

        bdMySql.executarSQL(sql);
    }
}
