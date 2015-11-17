/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.SQLException;
import negocio.Parquimetro;
import negocio.Ticket;

/**
 *
 * @author ccalifi
 */
public class TesteDAOXML {
    public static void main(String[] args) throws ParquimetroDAOException, SQLException, ticketDAOException {
        
        TicketDAOXML td = new TicketDAOXML();
        ParquimetroDAOXML pd = new ParquimetroDAOXML();
                
        
        Parquimetro p = new Parquimetro(pd.getEndereco(), pd.getCodigo(), pd.getHoraInicio(), pd.getHoraFinal(), pd.getTempoMinimo(), pd.getTempoMaximo(), pd.getIncremento(), pd.getValorIncremento());
        
                
        Ticket t = new Ticket(p, p.getEnder(), 12.5, p.getHoraInicio(), p.getIncremento());
        
        td.adicionar(t);
        
    }
    
}
