/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.bd;

import modelo.negocio.Atendimento;
import controle.Controle;
import modelo.negocio.Atendimento;
import modelo.negocio.Prontuario;
import modelo.negocio.util.Valida;
import java.sql.ResultSet;
import java.util.Vector;

/**
 *
 * @author Lay and Lary
 */
public class AtendimentoDao {
     Valida data = new Valida();
     private String formato = "dd/MM/yyyy";
     ProntuarioDao prontuarioDao = new ProntuarioDao();
     BDMySql bdMySql = BDMySql.getInstance();
  
    public String[][] listaAtendimentos(){
		ResultSet rs = bdMySql.executarBuscaSQL("Select idAtendimento,  data, hora, descricao,Prontuario_idProntuario from atendimento");
		String lista[][] = new String[bdMySql.getRowCount(rs)][];
		try{
			int i = 0;
			while (rs.next()){
                            
                            String datadobanco =data.getFormatarDataDoBanco(rs.getString("data"));
                              
				String l[] = {rs.getString("idAtendimento"),datadobanco, rs.getString("hora"), rs.getString("descricao"),rs.getString("Prontuario_idProntuario")};
                                
				lista[i++] = l;
			}
		}catch(Exception e){
			
		}
		return lista;
	}
	
	public Atendimento getAtendimento(int id){
		ResultSet rs = bdMySql.executarBuscaSQL("Select idAtendimento, data, hora, descricao,Prontuario_idProntuario from atendimento where idAtendimento = "+ id);
		Atendimento at = null;
		try{
			if (rs.next()){
                            
                               
				
				at = new Atendimento(id, rs.getString(2), rs.getString("hora"), rs.getString("descricao"),prontuarioDao.getProntuario(rs.getInt("Prontuario_idProntuario")));
			}
		}catch(Exception e){
			
		}
		return at;
	}
	
	public void cadastraAtendimento(Atendimento at){
		String sql = "insert into atendimento(data, hora, descricao,Prontuario_idProntuario) values ('"+
					 at.getData()+"','"+at.getHorario()+"','"+at.getDescricao()+"','"+at.getProntuario()+"')";
		bdMySql.executarSQL(sql);
	}
        
	public void atualizaAtendimento(Atendimento at){
		String sql = "update atendimento set data = '"+at.getData()+"',"+
		                              " hora = '"+at.getHorario()+"',"+
		                              " descricao= '"+at.getDescricao()+"',"+
		                              "Prontuario_idProntuario= '"+at.getProntuario()+"'"+
                        
		                              " where idAtendimento = "+ at.getIdAtendimento();
		                              
		bdMySql.executarSQL(sql);
	}
	
        
        public  Vector<Atendimento> getAtendimentos(){
		ResultSet rs = bdMySql.executarBuscaSQL("Select idAtendimento,  data, hora, descricao, Prontuario_idProntuario from atendimento");
		Atendimento at = null;
                Vector<Atendimento> atendimentos = new Vector<Atendimento>();
		try{
			while (rs.next()){
				 String datadobanco =data.getFormatarDataDaInterface(rs.getString(2));
				at = new Atendimento(rs.getInt(1), datadobanco, rs.getString(3),rs.getString(4),prontuarioDao.getProntuario(rs.getInt(5)));
                              atendimentos.add(at);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return atendimentos;
	}
        
	public void deletaPessoa(int id){
		String sql = "delete from atendimento where idAtendimento = "+ id;
		                              
		bdMySql.executarSQL(sql);
	}
     
}
