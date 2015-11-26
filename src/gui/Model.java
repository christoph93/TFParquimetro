/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.math.BigDecimal;
import java.sql.Time;
import negocio.Facade;

public class Model {        
    
    private Controller c;
    private Time tempo = Time.valueOf("00:00:00");
    private BigDecimal valor = new BigDecimal(0);
    private Facade f = new Facade();
    
    
    public String setValor(BigDecimal v){
        if(f.insereMoeda(v)){
         valor = valor.add(v);
         return "Moeda inserida: " + v;
        }
        return "Moeda não aceita! Retornando valor: R$" + v;
    }
    
    public BigDecimal getValor() {
        return valor;
    }
    
    public void setTempo(int v) {
        
        tempo.setMinutes(tempo.getMinutes() + v);
    }
    
    public Time getTempo() {
        return tempo;
    }
    
    public void clear(){
        valor = new BigDecimal(0);
        tempo = Time.valueOf("00:00:00");
    }
}
