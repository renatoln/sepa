/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.negocio.util;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

/**
 *
 * @author Carla
 */
public class Utilidades {

    public static boolean ehNumero(String msn) {
        try {
            Integer.parseInt(msn);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String removerCaracterEspecial(String entrada) {

        String retorno = "";
        String caracter[] = entrada.split("");
        for (int i = 0; i < caracter.length; i++) {
            if (this.ehNumero(String.valueOf(caracter[i]))) {
                retorno = retorno + caracter[i];
            }

        }
        System.out.println(retorno);
        return retorno;

    }
    /*String retorno= " ";
    String cpf2 [] = cpf.split(".*");
    ArrayList list = new ArrayList();
    for (int i= 0; i<cpf2.length; i++){
    list.add(cpf2[i]);
    }
    for (int i=0; i<cpf2.length;i++){
    Collections.sort(list);

    retorno = retorno+list.get(i);
    }*/
    /**
     * Tipos de mensagens de popUp
     * */
    public static final int POP_UP_MENSAGEM_ERRO = 1;
    public static final int POP_UP_MENSAGEM_INFORMACAO = 2;

    /**
     * Este método apresenta um popUp na tela com a mensagem msn o título (titulo), e o tipo\n
     * para o tipo use:\n
     * 	POP_UP_MENSAGEM_ERRO       - para Mensagem de erro,\n 
     *  POP_UP_MENSAGEM_INFORMACAO - Mensagem de informação \n
     * se o título for = null o método usará "Erro" e "Informação"  
     * */
    public static void mensagemPopUp(String msn, String titulo, int tipo) {

        switch (tipo) {
            case POP_UP_MENSAGEM_ERRO: {
                if (titulo == null) {
                    titulo = "Erro";
                }
                JOptionPane.showMessageDialog(null, msn, titulo, JOptionPane.ERROR_MESSAGE);
                break;
            }
            case POP_UP_MENSAGEM_INFORMACAO: {
                if (titulo == null) {
                    titulo = "Informação";
                }
                JOptionPane.showMessageDialog(null, msn, titulo, JOptionPane.INFORMATION_MESSAGE);
                break;
            }
        }


    }
}
