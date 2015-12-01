package negocio;

/**
 *
 * @authors Christoph Califice, Lucas Caltabiano
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
