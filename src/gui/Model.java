/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.math.BigDecimal;
import java.sql.Time;
import negocio.Facade;
import negocio.Parquimetro;

public class Model {        
    
    private Controller c;
    private Time tempo = Time.valueOf("00:00:00");
    private BigDecimal valor = new BigDecimal(0);
    private Facade f;

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
    
    public Time incrementaTempo() {
        //System.out.println(f.incrementaTempo());
       return f.incrementaTempo();
    }
    
    public Time decrementaTempo() {
        System.out.println(f.decrementaTempo());
       return f.decrementaTempo();
    }
    
    public Time getTempo(){
        return tempo;
    }
    
    public void clear(){
        valor = new BigDecimal(0);
        tempo = Time.valueOf("00:00:00");
    }
    
    public Facade getFacade() {
        return f;
    }

    public void setFacade(Parquimetro p) {
        if(f == null){
            f = new Facade(p);
        }
    }
    
    
}
