/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.math.BigDecimal;
import java.sql.Time;

/**
 *
 * @author 12104806
 */
public class Processamento {

    private Time tempo;
    private Pagamento pag;
    private Parquimetro parquim;
    private double valorPagamento;
    private Time tempoMax;
    private Time tempoMin;
    private int aux;
    private int numTick;
    private Time incremento;

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
    
    
    public double calculaValorPorTempo(){
        Time a1 = Time.valueOf("00:00:00");
        long aux = System.currentTimeMillis();
                
        a1.setTime(aux);
        System.out.println(a1);
        
        
        return 0;
    }

    public Time incrementaTempo() {
        Time aux = Time.valueOf("00:00:00");
        aux.setTime(tempo.getTime());
        aux.setMinutes(aux.getMinutes() + incremento.getMinutes());


        if (aux.compareTo(tempoMax) <= 0) {
            tempo.setHours(aux.getHours());
            tempo.setMinutes(aux.getMinutes());
            valorPagamento += parquim.getValorIncremento();
            System.out.println("tempo se passou: " + tempo);
        }

        return tempo;
    }
    
    public Time getTempoMinimo(){
        return parquim.getTempoMin();
    }

    public Time decrementaTempo() {
        Time aux = Time.valueOf("00:00:00");
        aux.setTime(tempo.getTime());
        aux.setMinutes(aux.getMinutes() - incremento.getMinutes());
          
        if (aux.compareTo(tempoMin) >= 0) {
            tempo.setHours(aux.getHours());
            tempo.setMinutes(aux.getMinutes());
            valorPagamento -= parquim.getValorIncremento();
            System.out.println("tempo se passou: " + tempo);
        }
        return tempo;
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
//            Emissao tick = new Emissao(tempo,numTick, valorPagamento, parquim);
//            return "Pagamento aceito.";
//        } else if (pag.getValor() - valorPagamento < 0) {
//            return "Pagamento insuficiente";
//        } else if (pag.getValor() - valorPagamento > 0) {
//            troco = "Pagamento aceito. Troco: ";
//            //fazer logica do troco
//        }
//        return troco;
        return null;
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
