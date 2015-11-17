/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.SQLException;
import negocio.Cartao;
import negocio.Endereco;
import negocio.Parquimetro;
import negocio.Ticket;

/**
 *
 * @author ccalifi
 */
public class TesteDAOXML {
    public static void main(String[] args) throws ParquimetroDAOException, SQLException, ticketDAOException {
//        
//        CartaoDAOXML dao = new CartaoDAOXML();
//        
//        Cartao c = new Cartao("cartao1", 12.4, "RESIDENTE");
//        
//               
//        dao.addcartao(c);
//        
//        System.out.println(dao.getCartao("cartao1").toString());
//        
//        dao.setSaldo("cartao1", 13.5);
//        
//        System.out.println(dao.getCartao("cartao1").toString());

        TicketDAOXML daoT = new TicketDAOXML();
        
        ParquimetroDAOXML daoP = new ParquimetroDAOXML();
        
        Ticket t = daoT.getTicketPorCodigo(55555);
        
        daoT.adicionar(t);

        
    }
    
}
