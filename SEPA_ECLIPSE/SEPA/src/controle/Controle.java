/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Vector;
import modelo.negocio.util.Valida;
import modelo.negocio.Hospital;
import modelo.negocio.Profissao;
import modelo.negocio.Profissional;
import modelo.negocio.util.UtilidadesData;
import modelo.bd.HospitalDao;
import modelo.bd.ProfissaoDao;
import modelo.bd.ProfissionalDao;

/**
 *
 * @author WELLITON
 */
public class Controle {
    
    ProfissionalDao profissionalDao = new ProfissionalDao();
    HospitalDao hospitalDao = new HospitalDao();
    ProfissaoDao profissaoDao = new ProfissaoDao();
    Valida valida = new Valida();
    UtilidadesData utildata = new UtilidadesData();
    
    public void cadastraProfissional(Profissional p) throws ParseException {
        profissionalDao.cadastraProfissional(p);
    }
    
    public Vector<Hospital> getHospital() {
        
        return hospitalDao.getHospital();
    }
    
    public Vector<Profissao> getProfissao() {
        
        return profissaoDao.getProfissao();
    }
    
    public boolean validaData(String datas, String formato) {
        
        return utildata.ehDataValida(datas, formato);
        
        
    }
    
    public String[][] listaProfissional() {
        
        
        return profissionalDao.listaProfissional();
    }
    
    public String visualizaAMD(String datas) throws ParseException {
        
        return valida.visualizaAMD(datas);
        
        
    }
    
    public String visualizaDMA(String datas) throws ParseException {
        
        return valida.visualizaDMA(datas);
        
        
    }
     public String dataBanco(String datas) throws ParseException {

        return valida.getFormatarDataDaInterface(datas);


    }

    /*
     public  GregorianCalendar dataBanco(String datas) throws ParseException {

     return utildata.transformaData_YYYYMMDD_to_GregorianCalendar(datas);


     }*/
    public boolean validaCpf(String formato) {
        
        return valida.calculaCPF(formato);
        
        
    }
    
    public boolean BuscaCpf(String cpf) throws SQLException {
        
        return profissionalDao.getCpfProfissional(cpf);
        
        
    }
    
    public boolean ComparaData(String data) throws SQLException {
        
        return utildata.comparaData(data);
        
        
    }
    
    public static String transformaData_GregorianCalendar_to_YYYYMMDD(GregorianCalendar data) {
        
        return UtilidadesData.transformaData_GregorianCalendar_to_YYYYMMDD(data);
    }
    
    public void atualizaProfissional(Profissional p) {
        profissionalDao.atualizaProfissional(p);
    }
    
    public Profissional getProfissionalId(int id) {
        return profissionalDao.getProfissional(id);
    }
    
    public String dataDDMMYYYY(String novaData) {
        // data ÃƒÂ© o atributo que jÃƒÂ¡ foi validado
        return utildata.dataDDMMYYYYCampo(novaData);
    }
    
    public boolean getLoginProfissional(String usuario, String senha) throws SQLException {
        
        return profissionalDao.getLoginCpfProfissional(usuario, senha);
        
        
    }
    	public void deletaProficional(int id){
		profissionalDao.deletaProficional(id);
		
	}
}
