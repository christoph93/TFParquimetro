/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.Parquimetro;
import negocio.Ticket;
import org.jdom2.Attribute;
import org.jdom2.DataConversionException;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author ccalifi
 */
public class TicketDAOXML implements ticketDAO {

    private Element root;
    private Document doc;
    private File inputFile;
    private SAXBuilder saxBuilder;

    public TicketDAOXML() throws JDOMException, IOException {

        inputFile = new File("tickets.xml");

        saxBuilder = new SAXBuilder();

        doc = saxBuilder.build(inputFile);

        root = doc.getRootElement();

    }

    @Override
    public void adicionar(Ticket t) throws ticketDAOException {

        Element elemTicket = new Element("ticket");
        elemTicket.setAttribute(new Attribute("codigo", String.valueOf(t.getNumero())));

        Element elemParquimetro = new Element("parquimetro");
        elemParquimetro.setText(String.valueOf(t.getParquimetro().getCodigo()));

        Element elemValor = new Element("valor");
        elemValor.setText(String.valueOf(t.getValor()));

        Element elemEmissao = new Element("emissao");
        elemEmissao.setText(t.getEmissao().toString());

        Element elemValidade = new Element("validade");
        elemValidade.setText(t.getValidade().toString());

        Element elemRua = new Element("rua");
        elemRua.setText(t.getEndereco().getNomeRua());

        Element elemNumero = new Element("numero");
        elemNumero.setText(String.valueOf(t.getEndereco().getNumero()));

        Element elemCidade = new Element("cidade");
        elemCidade.setText(t.getEndereco().getCidade());

        Element elemEstado = new Element("estado");
        elemEstado.setText(t.getEndereco().getEstado());

        Element elemPais = new Element("pais");
        elemPais.setText(t.getEndereco().getPais());

        elemTicket.addContent(elemParquimetro);
        elemTicket.addContent(elemValor);
        elemTicket.addContent(elemEmissao);
        elemTicket.addContent(elemValidade);
        elemTicket.addContent(elemRua);
        elemTicket.addContent(elemNumero);
        elemTicket.addContent(elemCidade);
        elemTicket.addContent(elemEstado);
        elemTicket.addContent(elemPais);

        root.addContent(elemTicket);

        XMLOutputter xmlOutput = new XMLOutputter();

        xmlOutput.setFormat(Format.getPrettyFormat());

        try {
            xmlOutput.output(doc, new FileWriter("tickets.xml"));
        } catch (IOException ex) {
            Logger.getLogger(TicketDAOXML.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public Ticket getTicketPorCodigo(int codigo) throws ticketDAOException {
        try {
            ParquimetroDAOXML daoT = new ParquimetroDAOXML();
            Parquimetro aux = daoT.getParquimetro();
            for (Element e : root.getChildren()) {
                if (codigo == e.getAttribute("codigo").getIntValue()) {
                    return new Ticket(
                            aux,
                            aux.getEnder(),
                            e.getAttribute("codigo").getIntValue(),
                            Double.parseDouble(e.getChild("valor").getValue()),
                            Time.valueOf(e.getChildText("emissao")),
                            Time.valueOf(e.getChildText("validade")));
                }
            }
        } catch (DataConversionException ex) {
            Logger.getLogger(TicketDAOXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParquimetroDAOException ex) {
            Logger.getLogger(TicketDAOXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TicketDAOXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TicketDAOXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Ticket> getTickets() {
        ArrayList<Ticket> tickets = new ArrayList<>();;
        try {
            ParquimetroDAOXML daoT = new ParquimetroDAOXML();
            Parquimetro aux = daoT.getParquimetro();

            for (Element e : root.getChildren()) {
                
                Ticket t = new Ticket(
                        aux,
                        aux.getEnder(),
                        e.getAttribute("codigo").getIntValue(),
                        Double.parseDouble(e.getChild("valor").getValue()),
                        Time.valueOf(e.getChildText("emissao")),
                        Time.valueOf(e.getChildText("validade")));              
                
                
                tickets.add(t);
            }            
        } catch (ParquimetroDAOException ex) {
            Logger.getLogger(TicketDAOXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TicketDAOXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TicketDAOXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DataConversionException ex) {
            Logger.getLogger(TicketDAOXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tickets;
    }

}
