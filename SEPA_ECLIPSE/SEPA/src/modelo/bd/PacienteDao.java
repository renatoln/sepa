/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.bd;

import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JOptionPane;
import modelo.negocio.Paciente;
//import modelo.negocio.UtilidadesData;
import modelo.negocio.util.UtilidadesData;

/**
 *
 * @author casa
 */
public class PacienteDao {

    BDMySql bdMySql = BDMySql.getInstance();

    public Object[][] listaPacientes() {
        ResultSet rs = bdMySql.executarBuscaSQL("Select id,  nome, sexo,cpf from paciente order by nome");
        String lista[][] = new String[bdMySql.getRowCount(rs)][];
        try {
            int i = 0;
            while (rs.next()) {
                String l[] = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)};
                lista[i++] = l;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Consulta mal sucedida", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }

    public Paciente getPaciente(int id){
		ResultSet rs = bdMySql.executarBuscaSQL("Select nome, sexo, endereco, telefone, rg, dataNascimento, cpf  from paciente where id = "+ id);
		Paciente p = null;
		try{
			if (rs.next()){
				char sexo = rs.getString(2).toCharArray()[0];
				p = new Paciente(id, rs.getString(1), sexo, rs.getString(3),rs.getString(4), rs.getString(5),
                                        UtilidadesData.transformaData_YYYYMMDD_to_GregorianCalendar(rs.getString(6)), rs.getString(7));
			}

		}catch(Exception e){
                      JOptionPane.showMessageDialog(null, "Consulta mal sucedida", "Erro", JOptionPane.ERROR_MESSAGE);
		}
		return p;
	}

	public void cadastraPaciente(Paciente p){
		String sql = "insert into paciente (nome, sexo, endereco, telefone, rg, dataNascimento, cpf)values ('"+
					 p.getNome()+"','"+p.getSexo()+"','"+p.getEndereco()+"','"+p.getTelefone()+"','"+p.getRg()+
                                         "','"+UtilidadesData.transformaData_GregorianCalendar_to_YYYYMMDD(p.getDataNascimento())+"','"+p.getCpf()+"')";
		bdMySql.executarSQL(sql);
	}

	public void atualizaPaciente(Paciente p){
		String sql = "update paciente set nome = '"+p.getNome()+"',"+
		                              " sexo = '"+p.getSexo()+"',"+
		                              " endereco = '"+p.getEndereco()+"',"+
		                              " telefone = '"+p.getTelefone()+"',"+
                                              " rg = '"+p.getRg()+"',"+
                                              " dataNascimento = '"+UtilidadesData.transformaData_GregorianCalendar_to_YYYYMMDD(p.getDataNascimento())+"',"+
		                              " cpf ='"+p.getCpf()+"'"+
		                              " where id = "+ p.getId();

		bdMySql.executarSQL(sql);
	}

        public  Vector<Paciente> getPacientes(){
		ResultSet rs = bdMySql.executarBuscaSQL("Select id, nome, sexo, endereco, telefone, rg, dataNascimento, cpf  from paciente");
		Paciente p = null;
                Vector<Paciente> pacientes = new Vector<Paciente>();
		try{
			while (rs.next()){
				char sexo = rs.getString(2).toCharArray()[0];
				p = new Paciente(rs.getInt(1), rs.getString(2), sexo, rs.getString(4), rs.getString(5), 
                                        rs.getString(6), UtilidadesData.transformaData_YYYYMMDD_to_GregorianCalendar(rs.getString(7)), rs.getString(8));
                                pacientes.add(p);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return pacientes;
	}

	public void deletaPaciente(int id){
		String sql = "delete from paciente where id = "+ id;

		bdMySql.executarSQL(sql);
	}

        public boolean encontrouPaciente(String cpf) {
        String sql = ("select cpf from paciente where cpf = '" + cpf + "'");
        ResultSet rs = bdMySql.executarBuscaSQL(sql);
        boolean existe = false;

        try {

            if (rs.next()) {

                existe = true;

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " A consulta não foi realizada com sucesso ", "Erro", JOptionPane.ERROR_MESSAGE);

        }

        return existe;


    }
}
