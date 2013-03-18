/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.sql.ResultSet;
import java.util.Vector;
import modelo.Hospital;
import modelo.Profissao;

/**
 *
 * @author WELLITON
 */
public class ProfissaoDao {
          BDMySql bdMySql = BDMySql.getInstance();
       public  Vector<Profissao> getProfissao(){
		ResultSet rs = bdMySql.executarBuscaSQL("Select idProfissao,nome_profissao from profissao ");
		Profissao p = null;
                Vector<Profissao> profissao = new Vector<Profissao>();
		try{
			while (rs.next()){
				//char sexo = rs.getString(2).toCharArray()[0];
				 p = new Profissao(rs.getInt(1), rs.getString(2));
                               profissao.add(p);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return profissao;
	}
       	public Profissao getProfissaoId(int id){
		ResultSet rs = bdMySql.executarBuscaSQL("Select nome_profissao from profissao where idProfissao = "+ id);
		Profissao p = null;
		try{
			if (rs.next()){
				
				p = new Profissao(id, rs.getString(1));
			}
		}catch(Exception e){

		}
		return p;
	}
    
}
