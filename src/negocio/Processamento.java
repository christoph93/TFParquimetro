/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.sql.Time;

/**
 *
 * @author 12104806
 */
public class Processamento {

    private Time tempo;
    private Pagamento pag;
    private Parquimetro p;
    private double valorPagamento;
    Time tempoMax;
    Time tempoMin;

    public Processamento(Parquimetro parq) {
        tempo = Time.valueOf("00:00:00");
        p = parq;
        valorPagamento = 0.00;
        tempoMax = p.getTempoMax();
        tempoMin = p.getTempoMin();
    }

    public boolean incrementaTempo() {
        long auxMilis = tempo.getTime() + p.getIncremento().getTime();
        Time aux = Time.valueOf("00:00:00");
        aux.setTime(auxMilis);

        if (!aux.after(tempoMax)) {
            tempo.setTime(tempo.getTime() + p.getIncremento().getTime());
            valorPagamento += p.getValorIncremento();
            return true;
        } else{
            return false; 
        }
    }

    public boolean decrementaTempo() {
        long auxMilis = tempo.getTime() - p.getIncremento().getTime();
        Time aux = Time.valueOf("00:00:00");
        aux.setTime(auxMilis);

        if (!aux.before(tempoMin)) {
            tempo.setTime(tempo.getTime() - p.getIncremento().getTime());
            valorPagamento += p.getValorIncremento();
            return true;
        } else{
            return false; 
        }
    }

    public boolean insereMoeada(Moeda m) {
        if(p.getMoedas().contains(m)){
            valorPagamento += m.valor();
            return true;
        }
        return false;
    }

    public boolean paga(Pagamento pag) {

        return false;
    }

    public double getValorPagamento() {
        return valorPagamento;
    }

}
