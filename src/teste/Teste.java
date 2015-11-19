/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.io.IOException;
import java.sql.SQLException;
import negocio.Parquimetro;
import negocio.Ticket;
import org.jdom2.JDOMException;
import persistencia.ParquimetroDAOException;
import persistencia.ParquimetroDAOXML;
import persistencia.TicketDAOXML;
import persistencia.ticketDAOException;

/**
 *
 * @author ccalifi
 */
public class Teste {
    
    
    
    public static void main(String[] args) throws ParquimetroDAOException, SQLException, ticketDAOException, IOException, JDOMException {
        
        
        //leitura do parquimetro.xml
         ParquimetroDAOXML daoP = new ParquimetroDAOXML();
         Parquimetro p = daoP.getParquimetro();        
         
         //leitura do tickets.xml
         TicketDAOXML daoT = new TicketDAOXML();         
         
         for (Ticket t : daoT.getTickets()){
             System.out.println(t.toString());
         }
         
         
         
         
         
         
        
    }
    
}
