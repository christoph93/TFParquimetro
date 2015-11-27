/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.time.*;
import java.util.ArrayList;

/**
 *
 * @author ccalifi
 */
public class Parquimetro {

    private int codigo;
    private ArrayList<Moeda> moedas;
    private Endereco ender;
    private LocalTime horaInicio;
    private LocalTime horaFim;
    private Duration tempoMin;
    private Duration tempoMax;
    private Duration incremento;
    private double valorIncremento;

    public Parquimetro(Endereco e, int cod, LocalTime hIni, LocalTime hFim, Duration tMin, Duration tMax, Duration incr, double vIncr, ArrayList<Moeda> moedas) {

        this.codigo = cod; //fazer geração do código
        this.ender = e;
        horaInicio = hIni;
        horaFim = hFim;
        tempoMin = tMin;
        tempoMax = tMax;
        incremento = incr;
        valorIncremento = vIncr;
        this.moedas = moedas;
    }

    public ArrayList<Moeda> getMoedas(){
        return moedas;
    }
    
    public void setMoedas(ArrayList<Moeda> moedas){
        this.moedas = moedas;
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

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = LocalTime.parse(horaInicio);
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(String horaFim) {
        this.horaFim = LocalTime.parse(horaFim);
    }

    public void setHoraFim(LocalTime horaFim) {
        this.horaFim = horaFim;
    }

    public Duration getTempoMin() {
        return tempoMin;
    }

    public void setTempoMin(String tempoMin) {
        this.tempoMin = Duration.parse(tempoMin);
    }

    public void setTempoMin(Duration tempoMin) {
        this.tempoMin = tempoMin;
    }

    public Duration getTempoMax() {
        return tempoMax;
    }

    public void setTempoMax(String tempoMax) {
        this.tempoMax = Duration.parse(tempoMax);
    }

    public void setTempoMax(Duration tempoMax) {
        this.tempoMax = tempoMax;
    }

    public Duration getIncremento() {
        return incremento;
    }

    public void setIncremento(String incremento) {
        this.incremento = Duration.parse(incremento);
    }

    public void setIncremento(Duration incremento) {
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
        String moedasAc = "";
        for (Moeda m : moedas){
            moedasAc += m.valor() + " ";
        }
        return "Parquimetro{" + "codigo=" + codigo + ", ender=" + ender.toString() + ", horaInicio=" + horaInicio + ", horaFim=" + horaFim + ", tempoMin=" + tempoMin + ", tempoMax=" + tempoMax + ", incremento=" + incremento + ", valorIncremento=" + valorIncremento +
                "moedas aceitas: " + moedasAc +'}';
    }

}
