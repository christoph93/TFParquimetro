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

    public Processamento(Parquimetro parq) {
        tempo = Time.valueOf("00:00:00");
        parquim = parq;
        valorPagamento = 0.00;
        tempoMax = parquim.getTempoMax();
        tempoMin = parquim.getTempoMin();
        aux = 0;
    }

    public boolean incrementaTempo() {
        long auxMilis = tempo.getTime() + parquim.getIncremento().getTime();
        Time aux = Time.valueOf("00:00:00");
        aux.setTime(auxMilis);

        if (!aux.after(tempoMax)) {
            tempo.setTime(tempo.getTime() + parquim.getIncremento().getTime());
            valorPagamento += parquim.getValorIncremento();
            return true;
        } else {
            return false;
        }
    }

    public boolean decrementaTempo() {
        long auxMilis = tempo.getTime() - parquim.getIncremento().getTime();
        Time aux = Time.valueOf("00:00:00");
        aux.setTime(auxMilis);

        if (!aux.before(tempoMin)) {
            tempo.setTime(tempo.getTime() - parquim.getIncremento().getTime());
            valorPagamento += parquim.getValorIncremento();
            return true;
        } else {
            return false;
        }
    }

    public boolean insereMoeada(BigDecimal vMoeda) {
        if (aux == 0) {
            pag = new PagamentoMoeda(parquim);
        }
        aux = 1;

        for (Moeda m : parquim.getMoedas()) {
            if (m.valor() == vMoeda.doubleValue()) {
                return pag.recebe(m);
            } else {
                return false;
            }
        }
        return false;
    }

    public double paga() {
       return pag.getValor() - valorPagamento;        
    }

    public double getValorPagamento() {
        return valorPagamento;
    }

    boolean pagaComCartao(Cartao cart) {
        if(aux == 0){
            pag = new PagamentoCartao(cart);
        }else{
            return false;
        }
        
        return pag.recebe();
        
    }

}
