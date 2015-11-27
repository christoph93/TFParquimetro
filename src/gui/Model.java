/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.math.BigDecimal;
import negocio.Facade;
import negocio.Parquimetro;

public class Model {        
    
    private Controller c;
    private String tempo;
    private String valor;
    private Facade f;
    
    public Model(Parquimetro p){
        f = new Facade(p);
        String[] s = f.getMinimos();
        tempo = s[0];
        valor = s[1];
    }

    public String setValor(BigDecimal v){
        if(f.insereMoeda(v)){
         return "Moeda inserida: " + v;
        }
        return "Moeda não aceita! Retornando valor: R$" + v;
    }
    
    public String getValor() {
        return valor;
    }
    
    public String[] incrementaTempo() {
        //System.out.println(f.incrementaTempo());
       return f.incrementaTempo();
    }
    
    public String[] decrementaTempo() {
        //System.out.println(f.decrementaTempo());
       return f.decrementaTempo();
    }
    
    public String getTempo(){
        return tempo;
    }
    
    public void clear(){
        String[] s = f.getMinimos();
        valor = s[1];
        tempo = s[0];
    }
    
    public Facade getFacade() {
        return f;
    } 
}
