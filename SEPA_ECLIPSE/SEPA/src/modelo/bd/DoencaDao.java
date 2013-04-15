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

AreaDao areaDao= new AreaDao();

    BDMySql bdMySql= BDMySql.getInstance();
    public String[][] listaDoenca(){
		ResultSet rs = bdMySql.executarBuscaSQL("Select idDoenca, a.nome as nome_area, do.nome from Doenca as do "+
                        " inner join area as a on Area_idArea = idArea " );
		String lista[][] = new String[bdMySql.getRowCount(rs)][];
		try{
			int i = 0;
			while (rs.next()){
                String idDoenca= rs.getString(1);
                String nome_area = rs.getString(2);
                String nome = rs.getString(3);
                String l[] = {idDoenca , nome_area, nome};
                lista[i++] = l;
            }
		}catch(Exception e){

		}
		return lista;
	}

	public Doenca getDoenca(int id){
		ResultSet rs = bdMySql.executarBuscaSQL("Select  idDoenca, nome, Area_idArea  from doenca where idDoenca = "+ id);
		Doenca d = null;
		try{
			if (rs.next()){
			  d = new Doenca (id, rs.getString("nome"), areaDao.getArea(rs.getInt("Area_idArea")));

			}
		}catch(Exception e){

		}
		return d;
	}

	public void cadastraDoenca(Doenca d){
             String sql = "insert into Doenca (nome, Area_idArea) values ('"
                + d.getNome() + "','" + d.getArea().getId() + "')";

		
                bdMySql.executarSQL(sql);
	}
	public void atualizaDoenca(Doenca d){
		 String sql = "update Doenca set nome = '" + d.getNome()+ "',"
                 + " Area_idArea = '" + d.getArea().getId() + "' "
                 + " where idDoenca = " + d.getId();


		bdMySql.executarSQL(sql);
	}

        public  Vector<Doenca> getDoenca(){
		 ResultSet rs = bdMySql.executarBuscaSQL("Select idDoencaao.nome, nome_area from Doenca"
                + " inner join area on Area_idArea = idArea");

        	Doenca d = null;

                Vector<Doenca> doenca = new Vector<Doenca>();
		try{
                    while (rs.next()){
				
				 d = new Doenca(rs.getInt(1), rs.getString(2), areaDao.getArea(rs.getInt(3)));
                                doenca.add(d);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return doenca;
	}


	public void deletaDoenca(int id){
		String sql = "delete from doenca where idDoenca = "+ id;

		bdMySql.executarSQL(sql);
	}



}
