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

import java.math.BigDecimal;
import java.util.UUID;


public class Cartao {
 
    StringBuilder sb = new StringBuilder();
    
    private String codigo;
    private BigDecimal saldo;
    private String tipo;
    
    
    public Cartao(String codigo, BigDecimal saldo, String t){
        this.codigo = codigo;
        this.saldo = saldo;
        tipo = t;
    }
    
//    private String geraCodigo(){
//        String cod = "";
//        
//        for (int i = 0; i <=3; i++){
//            cod += UUID.randomUUID().toString().replaceAll("-", "");
//        }        
//        return cod;
//    }

    public String getCodigo() {
        return codigo;
    }
            
    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
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
