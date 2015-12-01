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
public class Facade {

    private CartaoDAOXML daoC;
    private Processamento proc;
    private Parquimetro parquim;
    private int numercaoTicket = 1;

    public Facade(Parquimetro parq){
        try {
            daoC = new CartaoDAOXML();
            parquim = parq;
            proc = new Processamento(parquim, numercaoTicket);
        } catch (CartaoDAOException ex) {
            Logger.getLogger(Facade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String cancela() {
        String moedas = proc.getMoedasAsString();
        proc = new Processamento(parquim, numercaoTicket);

        return "Retornando moedas: " + moedas;
    }

    //somente para pagamento com moeda
    public String imprime() {
        String aux = proc.paga();
        if (aux == null) {
            return "pagamento não encontrado";
        } else {
            numercaoTicket++;
            return aux;
        }
    }

    public String[] decrementaTempo() {
        return proc.decrementaTempo();
    }

    public String[] getMinimos() {
        return proc.getMinimos();
    }

    public String[] incrementaTempo() {
        return proc.incrementaTempo();
    }

    public boolean insereMoeda(BigDecimal moeda) {
        return proc.insereMoeada(moeda);
    }

    public void geraLog(){
        proc.geraLog();
    }
    
    public String passaCartao() throws CartaoDAOException {
        return proc.paga(daoC.getCartao());
    }

}
