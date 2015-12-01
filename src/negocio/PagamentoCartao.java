package negocio;

import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.CartaoDAOException;
import persistencia.CartaoDAOXML;

/**
 *
 * @authors Christoph Califice, Lucas Caltabiano
 */
public class PagamentoCartao implements Pagamento {

    private BigDecimal valorPagamento;
    private Cartao cart;
    private BigDecimal valorTicket;
    private CartaoDAOXML daoC;
    
    public PagamentoCartao(Cartao ca, BigDecimal valor) {
        try {
            cart = ca;
            valorTicket = valor;
            daoC = new CartaoDAOXML();
        } catch (CartaoDAOException ex) {
            Logger.getLogger(PagamentoCartao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean recebe() {
        if (cart.getTipo().equalsIgnoreCase("residente")) {
            valorPagamento = valorTicket;
            return true;
        } else if (cart.getTipo().equalsIgnoreCase("prepago")){
            if(cart.getSaldo().compareTo(valorTicket) >= 0){
                valorPagamento = valorTicket;
                
                cart.setSaldo(cart.getSaldo().subtract(valorTicket));
                daoC.setSaldo(cart.getCodigo(), cart.getSaldo().subtract(valorTicket).toString());
                return true;
                
            }else{
                return false;
            }
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
