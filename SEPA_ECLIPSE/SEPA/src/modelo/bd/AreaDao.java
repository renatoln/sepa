/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.bd;

import modelo.negocio.Area;
import java.sql.ResultSet;
import java.util.Vector;

/**
 *
 * @author Jessica
 */
public class AreaDao {
    
    BDMySql bdMySql = BDMySql.getInstance();
    public String[][] listaAreas(){
		ResultSet rs = bdMySql.executarBuscaSQL("Select idArea,  nome, descricao from area");
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
    
    
    public Area getArea(int id){
		ResultSet rs = bdMySql.executarBuscaSQL("Select nome, descricao from area where idArea = "+ id);
		Area a = null;
		try{
			if (rs.next()){
				a = new Area(id, rs.getString(1), rs.getString(2));
			}
		}catch(Exception e){
			
		}
		return a;
	}
    
    public void cadastraArea(Area a){
		String sql = "insert into area(nome, descricao) values ('"+ a.getNome()+"','"+a.getDescricao()+"')";
		bdMySql.executarSQL(sql);
	}
        
	public void atualizaArea(Area a){
		String sql = "update area set nome = '"+a.getNome()+"',"+
		                              " descricao = '"+a.getDescricao()+"'"+
		                              " where idArea = "+ a.getId();
		                              
		bdMySql.executarSQL(sql);
	}
	
        
        public  Vector<Area> getAreas(){
		ResultSet rs = bdMySql.executarBuscaSQL("Select id,nome, descricao  from area ");
		Area a = null;
                Vector<Area> areas = new Vector<Area>();
		try{
			while (rs.next()){
				a = new Area(rs.getInt(1), rs.getString(2),  rs.getString(3));
                                areas.add(a);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return areas;
	}
        
	public void deletaArea(int id){
		String sql = "delete from area where idArea = "+ id;
		                              
		bdMySql.executarSQL(sql);
	}
    
	
	

}