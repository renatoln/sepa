/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.bd;

import modelo.negocio.Paciente;
import java.sql.ResultSet;
import java.util.Vector;

/**
 *
 * @author Lay and Lary
 */
public class PacienteDao {
    
    BDMySql bdMySql = BDMySql.getInstance();
    public String[][] listaPacientes(){
		ResultSet rs = bdMySql.executarBuscaSQL("Select idPaciente,nome, endereco, telefone, rg, dtNasc, cpf  from paciente");
		String lista[][] = new String[bdMySql.getRowCount(rs)][];
		try{
			int i = 0;
			while (rs.next()){
				String l[] = {rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4)};
				lista[i++] = l;
			}
		}catch(Exception e){
			
		}
		return lista;
	}
	 public  Vector<Paciente> getPacientes(){
		ResultSet rs = bdMySql.executarBuscaSQL("Select idPaciente,nomePaciente, endereco, telefone, rg, dtNasc, cpf  from paciente ");
		Paciente p = null;
                Vector<Paciente> pacientes = new Vector<Paciente>();
		try{
			while (rs.next()){
				char sexo = rs.getString(2).toCharArray()[0];
				p = new Paciente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
                                pacientes.add(p);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return pacientes;
	}
	public Paciente getPaciente(int id){
		ResultSet rs = bdMySql.executarBuscaSQL("Select nomePaciente, endereco, telefone, rg, dtNasc, cpf  from paciente where idPaciente = "+ id);
		Paciente p = null;
		try{
			if (rs.next()){
				
				p = new Paciente(id, rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6));
			}
		}catch(Exception e){
			
		}
		return p;
	}
	
	public void cadastraPaciente(Paciente p){
		String sql = "insert into paciente(nome, endereco, telefone, rg, dtNasc, cpf) values ('"+p.getNome()+"','"+p.getEndereco()+"','"+p.getTelefone()+"','"+p.getRg()+"','"+p.getDataNasc()+"','"+p.getCpf()+"')";
		bdMySql.executarSQL(sql);
	}
        
	public void atualizaPaciente(Paciente p){
		String sql = "update paciente set nome = '"+p.getNome()+"',"+
		                              " endereco = '"+p.getEndereco()+"',"+
		                              " telefone = '"+p.getTelefone()+"',"+
		                              " cpf = "+p.getCpf()+","+
                                             " rg = "+p.getRg()+","+
		                              " dtNasc = '"+p.getDataNasc()+"' "+
		                              " where idPaciente = "+ p.getId();
		                              
		bdMySql.executarSQL(sql);
	}
	
        
        public  Vector<Paciente> getPaciente(){
		ResultSet rs = bdMySql.executarBuscaSQL("Select nome, endereco, telefone, rg, dtNasc, cpf  from paciente ");
		Paciente  p = null;
                Vector<Paciente> pacientes = new Vector<Paciente>();
		try{
			while (rs.next()){
				
                         p = new Paciente(rs.getInt(1), rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6));                             
                         pacientes.add(p);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return pacientes;
	}
        
	public void deletaPaciente(int id){
		String sql = "delete from paciente where idPaciente = "+ id;
		                              
		bdMySql.executarSQL(sql);
	}
    
}
