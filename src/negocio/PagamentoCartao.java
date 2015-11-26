/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import persistencia.CartaoDAOXML;

/**
 *
 * @author ccalifi
 */
public class PagamentoCartao implements Pagamento {

    private double valorTotal;
    private Cartao ca;
    private CartaoDAOXML daoC;

    public PagamentoCartao() {
        daoC = new CartaoDAOXML();
        ca = daoC.getCartao();
    }

    public void leCartao() {
        if (ca.getTipo().equalsIgnoreCase("residente")){
            
        }
    }

    @Override
    public double getValor() {
        return valorTotal;
    }

}
