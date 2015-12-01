/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.Facade;
import negocio.Parquimetro;
import persistencia.CartaoDAOException;

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
    
    public void geraLog(){
        f.geraLog();
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
        System.out.println(s[0] + "   " + s[1]);
        tempo = s[0];
        valor = s[1];
    }
    
    public String imprime(){
        return f.imprime();
    }
    
    public String cancela(){
        return f.cancela();
    }
    
    public String passaCartao(){
        try {
            return f.passaCartao();
        } catch (CartaoDAOException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Facade getFacade() {
        return f;
    } 
}
