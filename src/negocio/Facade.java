/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.math.BigDecimal;
import java.sql.Time;
import java.time.LocalTime;
import persistencia.CartaoDAOXML;

/**
 *
 * @author ccalifi
 */
public class Facade {

    private CartaoDAOXML daoC;
    private Processamento proc;
    private Parquimetro parquim;
    private int numercaoTicket = 1;

    public Facade(Parquimetro parq) {
        daoC = new CartaoDAOXML();
        parquim = parq;
        proc = new Processamento(parquim, numercaoTicket);
    }

    public String cancela() {
        String moedas = proc.getMoedasAsString();
        proc = new Processamento(parquim, numercaoTicket);

        return "Retornando moedas: " + moedas;
    }

    //somente para pagamento com moeda
    public String imprime() {
        String aux = proc.paga();
        if (aux == null) {
            return "pagamento não encontrado";
        } else {
            numercaoTicket++;
            return aux;
        }
    }

    public String[] decrementaTempo() {
        return proc.decrementaTempo();
    }

    public String[] getMinimos() {
        return proc.getMinimos();
    }

    public String[] incrementaTempo() {
        return proc.incrementaTempo();
    }

    public boolean insereMoeda(BigDecimal moeda) {
        return proc.insereMoeada(moeda);
    }

    public String passaCartao() {
        //System.out.println(proc.paga(daoC.getCartao()));
        return proc.paga(daoC.getCartao());
    }

}
