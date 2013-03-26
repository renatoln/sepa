/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.bd;

import java.sql.ResultSet;
import java.util.Vector;
import modelo.negocio.Doenca;

/**
 *
 * @author usuario
 */
public class DoencaDao {


    BDMySql bdMySql= BDMySql.getInstance();
    public String[][] listaDoenca(){
		ResultSet rs = bdMySql.executarBuscaSQL("Select id, nome, area from Doenca");
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

	public Doenca getDoenca(int id){
		ResultSet rs = bdMySql.executarBuscaSQL("Select nome, area  from doenca where id = "+ id);
		Doenca d = null;
		try{
			if (rs.next()){
			d = new Doenca (id, rs.getString(1), rs.getString(2));
			}
		}catch(Exception e){

		}
		return d;
	}

	public void cadastraDoenca(Doenca d){
		String sql = "insert into doenca (nome, area) values ('"+
					 d.getNome()+"','"+d.getArea()+"')";

                bdMySql.executarSQL(sql);
	}
	public void atualizaDoenca(Doenca d){
		String sql = "update doenca set nome = '"+d.getNome()+"',"+
		                              " Area = '"+d.getArea()+"' "+
		                              " where id = "+ d.getId();

		bdMySql.executarSQL(sql);
	}

        public  Vector<Doenca> getDoenca(){
		ResultSet rs = bdMySql.executarBuscaSQL("Select id,nome, area  from doenca ");
		Doenca d = null;
                Vector<Doenca> doenca = new Vector<Doenca>();
		try{
                    while (rs.next()){
				
				d = new Doenca(rs.getInt(1), rs.getString(2),  rs.getString(3));
                                doenca.add(d);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return doenca;
	}


	public void deletaDoenca(int id){
		String sql = "delete from doenca where id = "+ id;

		bdMySql.executarSQL(sql);
	}



}
