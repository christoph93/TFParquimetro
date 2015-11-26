/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.math.BigDecimal;
import java.sql.Time;
import persistencia.CartaoDAOXML;

/**
 *
 * @author ccalifi
 */
public class Facade {
    
    
    private Cartao cart;
    private CartaoDAOXML daoC;
    private Processamento proc;
   private Parquimetro parquim;

    public Facade(Parquimetro parq) {
        daoC = new CartaoDAOXML();       
        proc = new Processamento(parq);
    }
    
    
    
    public String cancela(){
        proc = new Processamento(parquim);
        return "Retornando moedas";
    }
    
    public String imprime(){
        return "Pagamento aceito. Imprimindo ticket";
    }
    
    public Time decrementaTempo(){
        return proc.decrementaTempo();
    }
    
    public Time incrementaTempo(){
        return proc.incrementaTempo();
    }
    
    public boolean insereMoeda(BigDecimal moeda){
        return proc.insereMoeada(moeda);
    }
    
    public boolean pagaComCartao(){
        cart = daoC.getCartao();
        return proc.pagaComCartao(cart);
    }
    
    
}
