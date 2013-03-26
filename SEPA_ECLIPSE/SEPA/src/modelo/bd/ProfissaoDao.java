/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.bd;

import java.sql.ResultSet;
import java.util.Vector;
import modelo.negocio.Hospital;
import modelo.negocio.Profissao;

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



    public String[][] listaProfissoes() {
        ResultSet rs = bdMySql.executarBuscaSQL("Select idProfissao,  nome_profissao from profissao");
        String lista[][] = new String[bdMySql.getRowCount(rs)][];
        try {
            int i = 0;
            while (rs.next()) {
                String l[] = {rs.getString(1), rs.getString(2)};
                lista[i++] = l;
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public Profissao getProfissao(int id) {
        ResultSet rs = bdMySql.executarBuscaSQL("Select nome_profissao from profissao where idProfissao = " + id);
        Profissao p = null;
        try {
            if (rs.next()) {
                p = new Profissao(id, rs.getString(1));
            }
        } catch (Exception e) {
        }
        return p;
    }

    public void cadastraProfissao(Profissao p) {
        String sql = "insert into profissao(nome_profissao) values ('" + p.getNome() + "')";
        bdMySql.executarSQL(sql);
    }

    public void atualizaProfissao(Profissao p) {
        String sql = "update profissao set nome_profissao = '" + p.getNome() + "'"
                + " where idProfissao = " + p.getId_profissao();

        bdMySql.executarSQL(sql);
    }

    public Vector<Profissao> getProfissoes() {
        ResultSet rs = bdMySql.executarBuscaSQL("Select idProfissao,nome_profissao from profissoa ");
        Profissao p = null;
        Vector<Profissao> profissoes = new Vector<Profissao>();
        try {
            while (rs.next()) {
                p = new Profissao(rs.getInt(1), rs.getString(2));
                profissoes.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return profissoes;
    }

    public void deletaProfissao(int id) {
        String sql = "delete from profissao where idProfissao = " + id;

        bdMySql.executarSQL(sql);
    }
    
}
