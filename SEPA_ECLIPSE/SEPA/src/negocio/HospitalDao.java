/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.sql.ResultSet;
import java.util.Vector;
import modelo.Hospital;

/**
 *
 * @author WELLITON
 */
public class HospitalDao {
      BDMySql bdMySql = BDMySql.getInstance();
       public  Vector<Hospital> getHospital(){
		ResultSet rs = bdMySql.executarBuscaSQL("Select idHospital,nome_hospital,endereco_hospital,responsavel,marca,telefone_hospital   from hospital ");
		Hospital h = null;
                Vector<Hospital> hospital = new Vector<Hospital>();
		try{
			while (rs.next()){
				//char sexo = rs.getString(2).toCharArray()[0];
				h = new Hospital(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                                hospital.add(h);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return hospital;
	}
       
       	public Hospital getHospitalId(int id){
		ResultSet rs = bdMySql.executarBuscaSQL("Select nome_hospital,endereco_hospital,marca,telefone_hospital   from hospital where idHospital = "+ id);
		Hospital h = null;
		try{
			if (rs.next()){
				
				h = new Hospital(id, rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			}
		}catch(Exception e){

		}
		return h;
	}
}
