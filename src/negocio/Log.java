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
public class Log {
    
    private final Cartao cart;
    private final Ticket tick;
    private final Parquimetro parq;
    private int numLog;
            
    
    public Log(Parquimetro parq, Ticket tick, Cartao cart){
        this.cart = cart;
        this.tick = tick;
        this.parq = parq;        
    }

    public Cartao getCartao() {
        return cart;
    }

    public Ticket getTicket() {
        return tick;
    }

    public Parquimetro getParquimetro() {
        return parq;
    }
    
    public int getNumero(){
        return numLog;
    }
    
    
    
}
