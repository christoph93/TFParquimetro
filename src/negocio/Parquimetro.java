/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.sql.Time;

/**
 *
 * @author ccalifi
 */
public class Parquimetro {

    private int codigo;
    private Endereco ender;
    private Time horaInicio;
    private Time horaFim;
    private Time tempoMin;
    private Time tempoMax;
    private Time incremento;
    private double valorIncremento;

    public Parquimetro(Endereco e, int cod, Time hIni, Time hFim, Time tMin, Time tMax, Time incr, double vIncr) {

        this.codigo = cod; //fazer geração do código
        this.ender = e;
        horaInicio = hIni;
        horaFim = hFim;
        tempoMin = tMin;
        tempoMax = tMax;
        incremento = incr;
        valorIncremento = vIncr;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int cod) {
        this.codigo = cod;
    }

    public Endereco getEnder() {
        return ender;
    }

    public void setEnder(Endereco ender) {
        this.ender = ender;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = Time.valueOf(horaInicio);
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Time getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(String horaFim) {
        this.horaFim = Time.valueOf(horaFim);
    }

    public void setHoraFim(Time horaFim) {
        this.horaFim = horaFim;
    }

    public Time getTempoMin() {
        return tempoMin;
    }

    public void setTempoMin(String tempoMin) {
        this.tempoMin = Time.valueOf(tempoMin);
    }

    public void setTempoMin(Time tempoMin) {
        this.tempoMin = tempoMin;
    }

    public Time getTempoMax() {
        return tempoMax;
    }

    public void setTempoMax(String tempoMax) {
        this.tempoMax = Time.valueOf(tempoMax);
    }

    public void setTempoMax(Time tempoMax) {
        this.tempoMax = tempoMax;
    }

    public Time getIncremento() {
        return incremento;
    }

    public void setIncremento(String incremento) {
        this.incremento = Time.valueOf(incremento);
    }

    public void setIncremento(Time incremento) {
        this.incremento = incremento;
    }

    public double getValorIncremento() {
        return valorIncremento;
    }

    public void setValorIncremento(double valorIncremento) {
        this.valorIncremento = valorIncremento;
    }

    @Override
    public String toString() {
        return "Parquimetro{" + "codigo=" + codigo + ", ender=" + ender.toString() + ", horaInicio=" + horaInicio + ", horaFim=" + horaFim + ", tempoMin=" + tempoMin + ", tempoMax=" + tempoMax + ", incremento=" + incremento + ", valorIncremento=" + valorIncremento + '}';
    }

}
