package negocio;

import java.math.BigDecimal;

/**
 *
 * @authors Christoph Califice, Lucas Caltabiano
 */
public interface Pagamento {
    
    public BigDecimal getValor();
    
    public boolean recebe();
    
    public boolean recebe(Moeda moed);
    
}
