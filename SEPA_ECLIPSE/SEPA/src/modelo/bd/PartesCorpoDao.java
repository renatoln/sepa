/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.bd;


import java.sql.ResultSet;
import java.util.Vector;
import modelo.negocio.PartesCorpo;


/**
 *
 * @author labinfo
 */
public class PartesCorpoDao {
    BDMySql bdMySql= BDMySql.getInstance();
    public String[][] listaPartesCorpo(){
		ResultSet rs = bdMySql.executarBuscaSQL("Select idParte_do_corpo, nome from parte_do_corpo");
		String lista[][] = new String[bdMySql.getRowCount(rs)][];
		try{
			int i = 0;
			while (rs.next()){
				String l[] = {rs.getString(1), rs.getString(2)};
				lista[i++] = l;
			}
		}catch(Exception e){

		}
		return lista;
	}

	public PartesCorpo getPartesCorpo(int id){
		ResultSet rs = bdMySql.executarBuscaSQL("Select nome from parte_do_corpo where idParte_do_corpo = "+ id);
		PartesCorpo p = null;
		try{
			if (rs.next()){
			p = new PartesCorpo (id, rs.getString(1));
			}
		}catch(Exception e){

		}
		return p;
	}

	public void cadastraPartesCorpo(PartesCorpo p){
		String sql = "insert into parte_do_corpo(nome) values ('"+
					 p.getNome()+"')";

                bdMySql.executarSQL(sql);
	}
	public void atualizaPartesCorpo(PartesCorpo p){
		String sql =   "update parte_do_corpo set nome = '"+ p.getNome()+"' "+ " where idParte_do_corpo = "+ p.getId();

		bdMySql.executarSQL(sql);
	}

        public  Vector<PartesCorpo> getPartesCorpo(){
		ResultSet rs = bdMySql.executarBuscaSQL("Select idPartte_do_corpo ,nome  from parte_do_corpo ");
		PartesCorpo p = null;
                Vector<PartesCorpo> partescorpo = new Vector<PartesCorpo>();
		try{
			while (rs.next()){				
				p = new PartesCorpo(rs.getInt(1), rs.getString(2));
                                partescorpo.add(p);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return partescorpo;
	}


	public void deletaPartesCorpo(int id){
		String sql = "delete from parte_do_corpo where idParte_do_corpo = "+ id;

		bdMySql.executarSQL(sql);
	}

   
}
