/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controle;

import modelo.bd.AreaDao;
import modelo.bd.FichaDao;
import modelo.negocio.FichaAvaliacao;
import modelo.negocio.Area;

/**
 *
 * @author Silvelane
 */
public class ControleAvaliacao {
    FichaDao fichaDao = new FichaDao();
    AreaDao areaDao = new AreaDao();
    FichaAvaliacao f;
    Area a;



   public void cadastraFicha(FichaAvaliacao f){
       fichaDao.cadastraFicha(f);
   }
   public void atualizaFicha(FichaAvaliacao f){
       fichaDao.atualizaFicha(f);
   }
   public void deletarFicha (int id){
       fichaDao.deletaFicha(id);
   }
   public void listaFicha (int id){
       fichaDao.listaFicha();
   }
   public FichaAvaliacao getFicha(int id){
       FichaAvaliacao f = fichaDao.getFicha(id);
       return f;
   }
   public void cadastraArea(Area a){
       areaDao.cadastraArea(a);
   }
   public void atualizaArea(Area a){
       areaDao.atualizaArea(a);
   }
   public void deletarArea (int id){
       areaDao.deletaArea(id);
   }
   public void listaAreas (int id){
       areaDao.listaAreas();
   }
   public Area getArea(int id){
       Area a = areaDao.getArea(id);
       return a;
   }



}
