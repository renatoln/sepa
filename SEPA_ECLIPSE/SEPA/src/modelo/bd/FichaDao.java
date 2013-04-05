/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.bd;

import modelo.negocio.FichaAvaliacao;
import java.sql.ResultSet;
import java.util.Vector;

/**
 *
 * @author labinfo
 */
public class FichaDao {

    BDMySql bdMySql = BDMySql.getInstance();
    AreaDao areaDao = new AreaDao();

    public String[][] listaFicha() {
        ResultSet rs = bdMySql.executarBuscaSQL("Select idFicha_avaliacao, fa.nome as nome_ficha, a.nome as nomearea, fa.descricao from ficha_avaliacao as fa "+
                " inner join area as a on Area_idArea = idArea");
        String lista[][] = new String[bdMySql.getRowCount(rs)][];
        try {
            int i = 0;
            while (rs.next()) {
                String idFicha = rs.getString(1);
                String nome_ficha = rs.getString(2);
                String nomearea = rs.getString(3);
                String descricao = rs.getString(4);
                String l[] = {idFicha, nome_ficha, nomearea, descricao};
                lista[i++] = l;
            }
        } catch (Exception e) {
            System.out.println("erro ao recuperar lista ficha");
        }
        return lista;
    }

    public FichaAvaliacao getFicha(int id) {
        ResultSet rs = bdMySql.executarBuscaSQL("Select idFicha_avaliacao,nome,descricao, area_idArea from ficha_avaliacao where idFicha_avaliacao = " + id);
        FichaAvaliacao f = null;
        try {
            if (rs.next()) {

                f = new FichaAvaliacao(id, rs.getString("nome"), rs.getString("descricao"), areaDao.getArea(rs.getInt("Area_idArea")));
            }
        } catch (Exception e) {
            System.out.println("Erro no FichaDao.getFicha()");
        }
        return f;
    }

    public void cadastraFicha(FichaAvaliacao f) {
        String sql = "insert into ficha_avaliacao(nome, descricao, Area_idArea) values ('"
                + f.getNome() + "','" + f.getDescricao() + "','" + f.getArea().getId() + "')";


        bdMySql.executarSQL(sql);
    }

    public void atualizaFicha(FichaAvaliacao f) {
        String sql = "update ficha_avaliacao set nome = '" + f.getNome() + "',"
                + " descricao = '" + f.getDescricao() + "',"
                + " Area_idArea = '" + f.getArea().getId() + "' "
                + " where idFicha_avaliacao = " + f.getId();

        bdMySql.executarSQL(sql);
    }

    
    public Vector<FichaAvaliacao> getFichasAvaliacao() {
        ResultSet rs = bdMySql.executarBuscaSQL("Select idFicha_avaliacao,ficha_avaliacao.nome,descricao, nome_area from ficha_avaliacao"
                + " inner join area on Area_idArea = idArea");
        FichaAvaliacao f = null;
        Vector<FichaAvaliacao> fichaAvaliacao = new Vector<FichaAvaliacao>();
        try {
            while (rs.next()) {
                f = new FichaAvaliacao(rs.getInt(1), rs.getString(2), rs.getString(3), areaDao.getArea(rs.getInt(4)));
                fichaAvaliacao.add(f);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fichaAvaliacao;
    }



    public void deletaFicha(int id) {
        String sql = "delete from ficha_avaliacao where idFicha_avaliacao = " + id;

        bdMySql.executarSQL(sql);
    }
}
