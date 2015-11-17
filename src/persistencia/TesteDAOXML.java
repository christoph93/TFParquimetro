/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.SQLException;
import negocio.Cartao;
import negocio.Parquimetro;
import negocio.Ticket;

/**
 *
 * @author ccalifi
 */
public class TesteDAOXML {
    public static void main(String[] args) throws ParquimetroDAOException, SQLException, ticketDAOException {
        
        CartaoDAOXML dao = new CartaoDAOXML();
        
        Cartao c = new Cartao("cartao1", 12.4, "RESIDENTE");
        
        System.out.println(dao.getCartao("123456789").toString());
        
        dao.addcartao(c);
        
    }
    
}
