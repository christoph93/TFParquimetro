/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.io.IOException;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.JDOMException;
import persistencia.TicketDAOXML;

/**
 *
 * @author ccalifi
 */
class Emissao {
    
    private TicketDAOXML daoT;
    private Ticket tick;
    
    
    public Emissao(Time tempo, double valorT, Parquimetro parq, int numTick){
        try {
            daoT = new TicketDAOXML();
            
            Time tempoIni = Time.valueOf("00:00:00");
            tempoIni.setTime(System.currentTimeMillis());
            Time tempoFim = Time.valueOf("00:00:00");
            tempoFim.setTime(tempoIni.getTime() + tempo.getTime());
            
            tick = new Ticket(parq, parq.getEnder(), numTick, valorT, tempoIni, tempoFim);
            
            emiteTicket();
            
        } catch (JDOMException ex) {
            Logger.getLogger(Emissao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Emissao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void emiteTicket() {
        
        
        
    }
    
}
