/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.negocio.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author WELLITON
 */
public class Valida {

    String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean validarCPF(String cpfNum) {
        int[] cpf = new int[cpfNum.length()]; //define o valor com o tamanho da string
        int resultP = 0;
        int resultS = 0;
        if (cpfNum.length() != 11) {
            return false;
        }

        //converte a string para um array de integer
        for (int i = 0; i < cpf.length; i++) {
            cpf[i] = Integer.parseInt(cpfNum.substring(i, i + 1));
        }

        //calcula o primeiro nÃºmero(DIV) do cpf
        for (int i = 0; i < 9; i++) {
            resultP += cpf[i] * (i + 1);
        }
        int divP = resultP % 11;

        //se o resultado for diferente ao 10Âº digito do cpf retorna falso
        if (divP != cpf[9]) {
            return false;
        } else {
            //calcula o segundo nÃºmero(DIV) do cpf
            for (int i = 0; i < 10; i++) {
                resultS += cpf[i] * (i);
                //  return false;
            }
            int divS = resultS % 11;

            //se o resultado for diferente ao 11Âº digito do cpf retorna falso
            if (divS != cpf[10]) {
                return false;
            }
        }

        //se tudo estiver ok retorna verdadeiro
        return true;
    }//

    public boolean isDateValid(String data, String formato) {

        try {
            if (data.length() < 8 || data.length() > 10) {
                return false;
            }
            String ano = "", mes = "", dia = "";

            String palavras[] = data.split("/");

            if (palavras.length != 3) {
                return false;
            }

            if (formato.equalsIgnoreCase("dd/mm/yyyy")) {
                dia = palavras[0];
                mes = palavras[1];
                ano = palavras[2];
            } else if (formato.equalsIgnoreCase("mm/dd/yyyy")) {
                mes = palavras[0];
                dia = palavras[1];
                ano = palavras[2];
            } else if (formato.equalsIgnoreCase("yyyy/mm/dd")) {
                ano = palavras[0];
                mes = palavras[1];
                dia = palavras[2];
            }
            if (ano.length() != 4) {
                return false;
            }
            //   if (ano.length() != 4 && ano.length() != 2) return false;

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
            sdf.parse(data);

            //validação ok, vamos construir o objeto GregorianCalendar
            //    iMes = Integer.parseInt(mes);
            //   iDia = Integer.parseInt(dia);
            //     gcData = new GregorianCalendar(iAno, iMes-1, iDia);

        } catch (ParseException e) {
            data = null;
            return false;
        } /*catch (IllegalArgumentException e) {
        data = null;
        return false;
        }*/
        return true;



    }

    public String visualizaAMD(String data) throws ParseException {


        String ano = "", mes = "", dia = "";

        String palavras[] = data.split("/");
        dia = palavras[0];
        mes = palavras[1];
        ano = palavras[2];
        return (ano + "" + mes + "" + dia);


    }

    public String visualizaDMA(String data) throws ParseException {


        String ano = "", mes = "", dia = "";

        String palavras[] = data.split("-");
        ano = palavras[0];
        mes = palavras[1];
        dia = palavras[2];
        return (dia + "/" + mes + "/" + ano);


    }

    public Date getDataAtual() {
        GregorianCalendar gcAtual = new GregorianCalendar();
        return gcAtual.getTime();
    }
}
