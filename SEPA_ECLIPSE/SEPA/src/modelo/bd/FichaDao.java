/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.bd;

import modelo.negocio.FichaAvaliacao;
import java.sql.ResultSet;


/**
 *
 * @author labinfo
 */
public class FichaDao {
    BDMySql bdMySql= BDMySql.getInstance();
    
    public String[][] lista(){
		ResultSet rs = bdMySql.executarBuscaSQL("Select id,  nome, descricao from ficha_avaliacao");
		String lista[][] = new String[bdMySql.getRowCount(rs)][];
		try{
			int i = 0;
			while (rs.next()){
				String l[] = {rs.getString(1),rs.getString(2), rs.getString(3)};
				lista[i++] = l;
			}
		}catch(Exception e){

		}
		return lista;
	}

	public FichaAvaliacao getFicha(int id){
		ResultSet rs = bdMySql.executarBuscaSQL("Select nome,descricao from ficha_avaliacao where id = "+ id);
		FichaAvaliacao f = null;
		try{
			if (rs.next()){
			
				f = new FichaAvaliacao (id, rs.getString("nome"), rs.getString("descricao"));
			}
		}catch(Exception e){
                    System.out.println("Erro no FichaDao.getFicha()");
		}
		return f;
	}
        
	public void cadastraFicha(FichaAvaliacao f){
		String sql = "insert into ficha_avaliacao(nome, descricao) values ('"+
					 f.getNome()+"','"+f.getDescricao()+"')";
                                        
                                        
                bdMySql.executarSQL(sql);
	}
	public void atualizaFicha(FichaAvaliacao f){
		String sql = "update ficha_avaliacao set nome = '"+f.getNome()+"',"+
		                              " descricao = '"+f.getDescricao()+
                                              "' where id = "+ f.getId();

		bdMySql.executarSQL(sql);
	}

       


	public void deletaFicha(int id){
		String sql = "delete from ficha_avaliacao where id = "+ id;

		bdMySql.executarSQL(sql);
	}

   
}
