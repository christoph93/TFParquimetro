package negocio;


import java.math.BigDecimal;


/**
 *
 * @authors Christoph Califice, Lucas Caltabiano
 */
public class PagamentoMoeda implements Pagamento {

    private Parquimetro parq;
    private BigDecimal valorTotal;

    public PagamentoMoeda(Parquimetro pq) {
        parq = pq;
        valorTotal = new BigDecimal(0);
    }

    @Override
    public boolean recebe(Moeda m) {        
        if (parq.getMoedas().contains(m)) {
            BigDecimal aux = new BigDecimal(m.valor());
            valorTotal.add(aux);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public BigDecimal getValor() {
        return valorTotal;
    }

    @Override
    public boolean recebe() {
        return false;
    }

}
