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
public class PagamentoCartao implements Pagamento {

    private double valorTotal;
    private Cartao ca;

    public PagamentoCartao(Cartao cart) {
        ca = cart;
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
