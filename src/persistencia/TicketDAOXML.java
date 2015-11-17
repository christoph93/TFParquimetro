/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.Ticket;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;


/**
 *
 * @author ccalifi
 */
public class TicketDAOXML implements ticketDAO {

    private Element root;
    private Document doc;

    public TicketDAOXML() {
        
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
   
         // display xml
         xmlOutput.setFormat(Format.getPrettyFormat());
        try { 
            xmlOutput.output(doc, System.out);
        } catch (IOException ex) {
            Logger.getLogger(TicketDAOXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Ticket getTicketPorCodigo(int n) throws ticketDAOException {
        Ticket t = null;

        return t;
    }

}
