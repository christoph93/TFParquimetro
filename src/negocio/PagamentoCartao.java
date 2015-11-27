/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.math.BigDecimal;
import persistencia.CartaoDAOXML;

/**
 *
 * @author ccalifi
 */
public class PagamentoCartao implements Pagamento {

    private BigDecimal valorPagamento;
    private Cartao cart;
    private BigDecimal valorTicket;
    private CartaoDAOXML daoC;
    
    public PagamentoCartao(Cartao ca, BigDecimal valor) {
        cart = ca;
        valorTicket = valor;
         daoC = new CartaoDAOXML();
    }

    @Override
    public boolean recebe() {
        if (cart.getTipo().equalsIgnoreCase("residente")) {
            valorPagamento = valorTicket;
            return true;
        } else if (cart.getTipo().equalsIgnoreCase("prepago")){
            if (cart.getSaldo().compareTo(valorTicket) >= 0){
                valorPagamento = valorTicket;
                daoC.setSaldo(cart.getCodigo(), cart.getSaldo().subtract(valorPagamento).toPlainString());
                return true;
            }           
            return false; 
        }
        return false;
    }

    @Override
    public BigDecimal getValor() {
        return valorPagamento;
    }

    @Override
    public boolean recebe(Moeda moed) {
        return false;
    }

}
