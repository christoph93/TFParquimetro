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
import persistencia.ticketDAOException;

/**
 *
 * @author ccalifi
 */
class Emissao {

    private TicketDAOXML daoT;
    private Ticket tick;

    public Emissao(Time tempo, int numTicket, double valorPag, Parquimetro parq) {
        try {
            daoT = new TicketDAOXML();
            Time tempoEmiss = Time.valueOf("00:00:00");
            tempoEmiss.setTime(System.currentTimeMillis());

            Time tempoValid = Time.valueOf("00:00:00");
            tempoValid.setTime(tempoEmiss.getTime() + tempo.getTime());

            tick = new Ticket(parq, parq.getEnder(), numTicket, valorPag, tempoEmiss, tempoValid);

            daoT.adicionar(tick);

            imprimeTicket();

        } catch (JDOMException ex) {
            Logger.getLogger(Emissao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Emissao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ticketDAOException ex) {
            Logger.getLogger(Emissao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String imprimeTicket() {
        //escrever no txt e mandar para inteface
        return tick.toString();
    }

}
