package persistencia;

import java.util.List;
import negocio.Cartao;

/**
 *
 * @authors Christoph Califice, Lucas Caltabiano
 */
public interface CartaoDAO {
    
    public Cartao getCartao(String codigo);
    
    public Cartao getCartao();
    
    public void addcartao(Cartao cart);
    
    public void  setSaldo(String codigoCartao, String valor);
    
    public List<Cartao> getCartoes();
    
    
}
