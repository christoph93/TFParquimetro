/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.math.BigDecimal;
import java.time.*;
import java.util.ArrayList;
import persistencia.CartaoDAOXML;


/**
 *
 * @author 12104806
 */
public class Processamento {

    private Duration tempo;
    private Pagamento pag;
    private Parquimetro parquim;
    private BigDecimal valorTicket;
    private Duration tempoMax;
    private Duration tempoMin;
    private int aux;
    private int numTick;
    private Duration incremento;
    private ArrayList<Moeda> moedas;
    private CartaoDAOXML daoC;

    public Processamento(Parquimetro parq, int numerTick) {
        tempo = parq.getTempoMin();
        parquim = parq;
        tempoMax = parquim.getTempoMax();
        tempoMin = parquim.getTempoMin();
        aux = 0;
        numTick = numerTick;
        incremento = parquim.getIncremento();
        valorTicket = calculaValorPorTempo();
        daoC = new CartaoDAOXML();
        moedas = new ArrayList<>();
    }

    public BigDecimal calculaValorPorTempo() {
        double aux = tempo.getSeconds() / incremento.getSeconds();
        return new BigDecimal((int) aux * parquim.getValorIncremento());
    }

    public String[] incrementaTempo() {
        if (tempo.plus(incremento).compareTo(tempoMax) <= 0) {
            tempo = tempo.plus(incremento);
            valorTicket = calculaValorPorTempo();
        }

        long aux = tempo.getSeconds();
        String t = String.format("%d:%02d:%02d",
                aux / 3600,
                (aux % 3600) / 60,
                aux % 60);
        String[] a = {t, valorTicket.toString()};
        return a;
    }
    
    public boolean existePagamento(){
        return aux != 0;
    }

    public String[] getMinimos() {
        long aux = parquim.getTempoMin().getSeconds();
        String t = String.format("%d:%02d:%02d",
                aux / 3600,
                (aux % 3600) / 60,
                aux % 60);
        double aux2 = parquim.getTempoMin().getSeconds() / incremento.getSeconds();
        BigDecimal a = new BigDecimal((int) aux2 * parquim.getValorIncremento());
        String[] s = {t, a.toString()};
        return s;
    }

    public String[] decrementaTempo() {
        if (tempo.minus(incremento).compareTo(tempoMin) >= 0) {
            tempo = tempo.minus(incremento);
            valorTicket = calculaValorPorTempo();
        }
        long aux = tempo.getSeconds();
        String t = String.format("%d:%02d:%02d",
                aux / 3600,
                (aux % 3600) / 60,
                aux % 60);
        String[] a = {t, String.valueOf(valorTicket)};
        return a;
    }

    public boolean insereMoeada(BigDecimal vMoeda) {
        if (aux == 0) {
            pag = new PagamentoMoeda(parquim);
        }
        aux = 1;

        for (Moeda m : parquim.getMoedas()) {
            
            if (m.valor() == vMoeda.doubleValue()) {
                moedas.add(m);
                return pag.recebe(m);
            }
        }
        return false;
    }

    public String getMoedasAsString(){
        String stringMoedas = "  ";
        for(Moeda m : moedas){
            stringMoedas += (m.valor() + ", ");
        }
        return stringMoedas.substring(0, stringMoedas.length()-2);
    }
    
    //paga com moedas
    public String paga() {   
        System.out.println(aux);
        if (aux == 2) {
            return null;
            } else if (aux == 1) {
            if (pag.getValor().compareTo(valorTicket) <= 0) {
                Emissao em = new Emissao(tempo, numTick, valorTicket , parquim);
                return "pagamento aceito, retornando [troco]" + "\n" + em.imprimeTicket();
            } else {
                return "pagamento insuficiente";
            }
        }
        return null;

    }

    public BigDecimal getValorPagamento() {
        return valorTicket;
    }

    public String paga(Cartao cart) {
        if (aux == 0) {
            pag = new PagamentoCartao(cart, valorTicket);
            aux = 2;
            boolean aceitou = pag.recebe();
            if(aceitou){
                Emissao em = new Emissao(tempo, numTick, valorTicket , parquim);
                return "pagamento com cartão aceito. \nCartão " + daoC.getCartao().getCodigo() + "\nNovo saldo: " + daoC.getCartao().getSaldo().toString() +
                        "\n" + em.imprimeTicket();
            } else{
                return "saldo do cartao insuficiente";
            }
        } else if (aux == 2) {
            return "está pagando com moedas. cancele";
        }
        return "pagamento não aceito";
    }

}
