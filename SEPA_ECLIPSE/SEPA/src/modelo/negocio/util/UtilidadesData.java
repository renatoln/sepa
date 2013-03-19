/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.negocio.util;

/**
 *
 * @author WELLITON
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author 20080701013
 */
public class UtilidadesData {

    public static final String DATA_DD_MM_YYYY = "dd/mm/yyyy";
    public static final String DATA_MM_DD_YYYY = "mm/dd/yyyy";
    public static final String DATA_YYYY_MM_DD = "yyyy/mm/dd";
    private Date data = null;
    private GregorianCalendar gcData = null;

    /** valida a data strData nos seguintes
     * formatos 'dd/mm/yyyy', 'mm/dd/yyyy', 'yyyy/mm/dd',
     */
    public boolean ehDataValida(String strData, String formato) {
        try {
            if (strData.length() < 8 || strData.length() > 10) {
                return false;
            }
            String ano = "", mes = "", dia = "";

            String palavras[] = strData.split("/");

            if (palavras.length != 3) {
                return false;
            }

            if (formato.equalsIgnoreCase(DATA_DD_MM_YYYY)) {
                dia = palavras[0];
                mes = palavras[1];
                ano = palavras[2];
            } else if (formato.equalsIgnoreCase(DATA_MM_DD_YYYY)) {
                mes = palavras[0];
                dia = palavras[1];
                ano = palavras[2];
            } else if (formato.equalsIgnoreCase(DATA_YYYY_MM_DD)) {
                ano = palavras[0];
                mes = palavras[1];
                dia = palavras[2];
            }

            if (ano.length() != 4 && ano.length() != 2) {
                return false;
            }

            int iAno;
            int iMes;
            int iDia;

            try {
                iAno = Integer.parseInt(ano);
            } catch (Exception e) {
                return false;
            }

            SimpleDateFormat sdf = new SimpleDateFormat(formato);
            sdf.setLenient(false);
            data = sdf.parse(strData);

            //validaÃƒÂ§ÃƒÂ£o ok, vamos construir o objeto GregorianCalendar
            iMes = Integer.parseInt(mes);
            iDia = Integer.parseInt(dia);
            gcData = new GregorianCalendar(iAno, iMes - 1, iDia);

        } catch (ParseException e) {
            data = null;
            return false;
        } catch (IllegalArgumentException e) {
            data = null;
            return false;
        }
        return true;
    }

    public boolean ehDataValidaExtenso(String dataExtenso) {
        //"06 de junho de 2009"
        String palavras[] = dataExtenso.split(" ++");
        if (palavras.length == 5) {
            String mes = descobreMes(palavras[2]);
            String data = palavras[0] + "/" + mes + "/" + palavras[4];
            if (!palavras[1].equalsIgnoreCase("de") || !palavras[3].toUpperCase().equals("DE")) {
                if (mes.equals("-1")) {
                    return false;
                }
            }
            return ehDataValida(data, "dd/MM/yyyy");
        }
        return false;
    }

    private String descobreMes(String mesExtenso) {
        String mes = mesExtenso.toLowerCase();
        if (mes.equals("janeiro")) {
            return "01";
        } else if (mes.equals("fevereiro")) {
            return "02";
        } else if (mes.equals("marÃƒÂ§o")) {
            return "03";
        } else if (mes.equals("abril")) {
            return "04";
        } else if (mes.equals("maio")) {
            return "05";
        } else if (mes.equals("junho")) {
            return "06";
        } else if (mes.equals("julho")) {
            return "07";
        } else if (mes.equals("agosto")) {
            return "08";
        } else if (mes.equals("setembro")) {
            return "09";
        } else if (mes.equals("outubro")) {
            return "10";
        } else if (mes.equals("novembro")) {
            return "11";
        } else if (mes.equals("dezembro")) {
            return "12";
        }

        return "-1";

    }

    public GregorianCalendar getDataGregorianCalendar() {
        return gcData;
    }

    public Date getData() {
        if (gcData == null) {
            return null;
        }
        return gcData.getTime();
    }

    public Date getData(String data) {
        if (gcData == null) {
            return null;
        }
        return gcData.getTime();
    }

    public Date getDataAtual() {
        GregorianCalendar gcAtual = new GregorianCalendar();
            System.out.println(gcData);
        return gcAtual.getGregorianChange();
            
    }

    public String dataDDMMYYYY() {
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        String novaData = formatador.format(data); // data ÃƒÂ© o atributo que jÃƒÂ¡ foi validado
        return novaData;
    }
        public String dataDDMMYYYYCampo(String novaData) {
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        novaData = formatador.format(data); // data ÃƒÂ© o atributo que jÃƒÂ¡ foi validado
        return novaData;
    }

    public String dataYYYYMMDD() {
        SimpleDateFormat formatador = new SimpleDateFormat("yyyy/MM/dd");
        String novaData = formatador.format(data); // data ÃƒÂ© o atributo que jÃƒÂ¡ foi validado
        return novaData;
    }

    public String dataMMDDYYYY() {
        SimpleDateFormat formatador = new SimpleDateFormat("MM/dd/yyyy");
        String novaData = formatador.format(data); // data ÃƒÂ© o atributo que jÃƒÂ¡ foi validado
        return novaData;
    }

    public String dataPorExtenso() {
        return getDia() + " de " + getMes() + " de " + getAno();
    }

    public int getDia() {
        return gcData.get(Calendar.DAY_OF_MONTH);
    }

    public String getMes() {
        String mes = "";
        switch (gcData.get(Calendar.MONTH)) {
            case 0: {
                mes = "Janeiro";
                break;
            }
            case 1: {
                mes = "Fevereiro";
                break;
            }
            case 2: {
                mes = "MarÃƒÂ§o";
                break;
            }
            case 3: {
                mes = "Abril";
                break;
            }
            case 4: {
                mes = "Maio";
                break;
            }
            case 5: {
                mes = "Junho";
                break;
            }
            case 6: {
                mes = "Julho";
                break;
            }
            case 7: {
                mes = "Agosto";
                break;
            }
            case 8: {
                mes = "Setembro";
                break;
            }
            case 9: {
                mes = "Outubro";
                break;
            }
            case 10: {
                mes = "Novembro";
                break;
            }
            case 11: {
                mes = "Dezembro";
                break;
            }
        }
        return mes;
    }

    public int getAno() {
        return gcData.get(Calendar.YEAR);
    }

    public static int getAno(GregorianCalendar gcDate) {
        return gcDate.get(Calendar.YEAR);
    }

    public static int getMes(GregorianCalendar gcDate) {

        return gcDate.get(Calendar.MONTH) + 1;

    }

     public static int getDia(GregorianCalendar gcDate) {

        return gcDate.get(Calendar.DAY_OF_MONTH);

    }

    public String getDiaDaSemana() {

        String diaDaSemana = " ";
        switch (gcData.get(Calendar.DAY_OF_WEEK)) {
            case 1: {
                diaDaSemana = "Domingo";
                break;
            }
            case 2: {
                diaDaSemana = "Segunda";
                break;
            }
            case 3: {
                diaDaSemana = "TerÃƒÂ§a";
                break;
            }
            case 4: {
                diaDaSemana = "Quarta";
                break;
            }
            case 5: {
                diaDaSemana = "Quinta";
                break;
            }
            case 6: {
                diaDaSemana = "Sexta";
                break;
            }
            case 7: {
                diaDaSemana = "SÃƒÂ¡bado";
                break;
            }

        }
        return diaDaSemana;
    }

    public Date getAcrescentarDias(int dias) {
        gcData.add(Calendar.DAY_OF_MONTH, dias);
        return gcData.getTime();
    }

    public Date getAcrescentarMeses(int meses) {
        gcData.add(Calendar.MONTH, meses);
        return gcData.getTime();
    }

    public Date getAcrescentarAnos(int anos) {
        gcData.add(Calendar.YEAR, anos);
        return gcData.getTime();
    }

    public static GregorianCalendar transformaData_YYYYMMDD_to_GregorianCalendar(String data) {
        String[] values = data.split("/");
        int iAno = Integer.parseInt(values[0]);
        int iMes = Integer.parseInt(values[1]);
        int iDia = Integer.parseInt(values[2]);
        GregorianCalendar gcData = new GregorianCalendar(iAno, iMes - 1, iDia);
        return gcData;
    }
        public static GregorianCalendar transformaData_YYYYMMDD_Insere_no_banco(String data) {
        String[] values = data.split("/");
        int iDia = Integer.parseInt(values[0]);
        int iMes = Integer.parseInt(values[1]);
        int iAno = Integer.parseInt(values[2]);
        GregorianCalendar gcData = new GregorianCalendar(iAno, iMes - 1, iDia);
        return gcData;
    }

    public static String transformaData_GregorianCalendar_to_YYYYMMDD(GregorianCalendar data) {
        String strData = getAno(data)+"/"+getMes(data)+"/"+getDia(data);
        return strData;
    }
    
    public boolean comparaData(String data){
        if(transformaData_YYYYMMDD_Insere_no_banco(data).after(gcData)){
            return false;
           
    }
    return true;
    
    }
}
