/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.math.BigDecimal;
import java.time.*;

/**
 *
 * @author 12104806
 */
public class Processamento {

    private Duration tempo;
    private Pagamento pag;
    private Parquimetro parquim;
    private double valorPagamento;
    private Duration tempoMax;
    private Duration tempoMin;
    private int aux;
    private int numTick;
    private Duration incremento;

    public Processamento(Parquimetro parq, int numerTick) {
        tempo = parq.getTempoMin();
        parquim = parq;

        tempoMax = parquim.getTempoMax();
        tempoMin = parquim.getTempoMin();
        aux = 0;
        numTick = numerTick;
        incremento = parquim.getIncremento();
        valorPagamento = calculaValorPorTempo();
    }

    public double calculaValorPorTempo() {
        double aux = tempo.getSeconds() / incremento.getSeconds();
        return (int) aux * parquim.getValorIncremento();
    }

    public String[] incrementaTempo() {
        if (tempo.plus(incremento).compareTo(tempoMax) <= 0) {
            tempo = tempo.plus(incremento);
            calculaValorPorTempo();
        }

        long aux = tempo.getSeconds();
        String t = String.format("%d:%02d:%02d",
                aux / 3600,
                (aux % 3600) / 60,
                aux % 60);
        String[] a = {t, String.valueOf(valorPagamento)};
        return a;
    }

    public String getTempoMinimo() {
        return parquim.getTempoMin().toString();
    }

    public String[] decrementaTempo() {
        if (tempo.minus(incremento).compareTo(tempoMin) >= 0) {
            tempo = tempo.minus(incremento);
            calculaValorPorTempo();
        }
        long aux = tempo.getSeconds();
        String t = String.format("%d:%02d:%02d",
                aux / 3600,
                (aux % 3600) / 60,
                aux % 60);
        String[] a = {t, String.valueOf(valorPagamento)};
        return a;
    }

    public boolean insereMoeada(BigDecimal vMoeda) {
        if (aux == 0) {
            pag = new PagamentoMoeda(parquim);
        }
        aux = 1;

        for (Moeda m : parquim.getMoedas()) {
            if (m.valor() == vMoeda.doubleValue()) {
                return pag.recebe(m);
            }
        }
        return false;
    }

    public String paga() {
//        String troco = "";
//        if (pag.getValor() - valorPagamento == 0) {
//            Emissao tick = new Emissao(tempo, numTick, valorPagamento, parquim);
//            return "Pagamento aceito.";
//        } else if (pag.getValor() - valorPagamento < 0) {
//            return "Pagamento insuficiente";
//        } else if (pag.getValor() - valorPagamento > 0) {
//            troco = "Pagamento aceito. Troco: ";
//            //fazer logica do troco
//        }
//        return troco;
    }

    public double getValorPagamento() {
        return valorPagamento;
    }

    boolean pagaComCartao(Cartao cart) {
        if (aux == 0) {
            pag = new PagamentoCartao(cart);
        } else {
            return false;
        }

        return pag.recebe();

    }

}
