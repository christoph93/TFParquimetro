/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.io.IOException;
import java.sql.SQLException;
import persistencia.ParquimetroDAOException;
import persistencia.ParquimetroDAOXML;

/**
 *
 * @author ccalifi
 */
public class PagamentoMoeda implements Pagamento {

    private ParquimetroDAOXML daoP;
    private Parquimetro p;
    private double valorTotal;

    public PagamentoMoeda() throws ParquimetroDAOException, SQLException, IOException {

        daoP = new ParquimetroDAOXML();
        p = daoP.getParquimetro();
    }

    public boolean recebeMoeda(Moeda m) {
        if (p.getMoedas().contains(m)) {
            valorTotal += m.valor();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public double getValor() {
        return valorTotal;
    }

}
