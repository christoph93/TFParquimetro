/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author ccalifi
 */

import java.util.UUID;


public class Cartao {
 
    StringBuilder sb = new StringBuilder();
    
    private final String codigo;
    private double saldo;
    private final String tipo;
    
    
    public Cartao(double saldo, String t){
        codigo = geraCodigo();
        this.saldo = saldo;
        tipo = t;
    }
    
    private String geraCodigo(){
        String cod = "";
        
        for (int i = 0; i <=3; i++){
            cod += UUID.randomUUID().toString().replaceAll("-", "");
        }        
        return cod;
    }

    public String getCodigo() {
        return codigo;
    }
            
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getTipo() {
        return tipo;
    }    

    @Override
    public String toString() {
        return "Cartao{" + "codigo=" + codigo + ", saldo=" + saldo + ", tipo=" + tipo + '}';
    }
    
    
   
    
}
