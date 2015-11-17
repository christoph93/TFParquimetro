/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.sql.SQLException;
import negocio.Parquimetro;
import persistencia.ParquimetroDAOException;
import persistencia.ParquimetroDAOXML;
import persistencia.TicketDAOXML;
import persistencia.ticketDAOException;

/**
 *
 * @author ccalifi
 */
public class Teste {
    
    
    
    public static void main(String[] args) throws ParquimetroDAOException, SQLException, ticketDAOException {
        
        
        //leitura do parquimetro.xml
         ParquimetroDAOXML daoP = new ParquimetroDAOXML();
         Parquimetro p = daoP.getParquimetro();
         System.out.println(p.toString());
         
         //leitura do tickets.xml
         TicketDAOXML daoT = new TicketDAOXML();
         daoT.getTicketPorCodigo(55555);
         
         
         
         
        
    }
    
}
