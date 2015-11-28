/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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

    public Emissao(Duration tempo, int numTicket, BigDecimal valorTicket, Parquimetro parq) {
        try {
            daoT = new TicketDAOXML();
            LocalDateTime tempoEmiss = LocalDateTime.now();

            LocalDateTime tempoValid = LocalDateTime.of(LocalDate.now(), LocalTime.now().plusSeconds(tempo.getSeconds()));
            System.out.println(tempoValid);

            tick = new Ticket(parq, parq.getEnder(), numTicket, valorTicket, tempoEmiss, tempoValid);

            daoT.adicionar(tick);            

        } catch (JDOMException ex) {
            Logger.getLogger(Emissao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Emissao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ticketDAOException ex) {
            Logger.getLogger(Emissao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String imprimeTicket() {
        PrintWriter writer = null;
        try {
            String nomeArquivo = "ticket"+String.valueOf(tick.getNumero())+".txt";
            writer = new PrintWriter(nomeArquivo, "UTF-8");
            writer.println("The first line");
            writer.println("The second line");
            writer.close();
            } catch (FileNotFoundException ex) {
            Logger.getLogger(Emissao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Emissao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            writer.close();
        }
        return tick.toString();
    }

}
