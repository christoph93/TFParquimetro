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
    private Cartao cart; 

    public PagamentoCartao(Cartao ca) {
        cart = ca;
    }

    @Override
    public boolean recebe() {
        if (cart.getTipo().equalsIgnoreCase("residente")){
            
        }
        return false;
    }

    @Override
    public double getValor() {
        return valorTotal;
    }

    @Override
    public boolean recebe(Moeda moed) {
        return false;
    }

}
