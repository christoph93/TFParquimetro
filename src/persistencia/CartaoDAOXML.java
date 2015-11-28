/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.Cartao;
import org.jdom2.Attribute;
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
public class CartaoDAOXML implements CartaoDAO {

    private File inputFile;
    private SAXBuilder saxBuilder;
    private Document document;
    private Element root;
    private List<Element> listaCartoes;

    public CartaoDAOXML() {

        try {
            inputFile = new File("cartoes.xml");

            saxBuilder = new SAXBuilder();

            document = saxBuilder.build(inputFile);

            root = document.getRootElement();

            listaCartoes = root.getChildren();

        } catch (JDOMException | IOException e) {
        }

    }

    @Override
    public Cartao getCartao(String codigo) {
        Cartao c = null;

        String cod, tipo;
        BigDecimal saldo;

        for (Element e : listaCartoes) {
            if (codigo.equals(e.getAttribute("codigo").getValue())) {
                cod = e.getAttribute("codigo").getValue();
                saldo = new BigDecimal(e.getChild("saldo").getValue());
                tipo = e.getChild("tipo").getValue();
                c = new Cartao(cod, saldo, tipo);
                return c;
            }
        }
        return c;
    }

    @Override
    public void addcartao(Cartao cart) {

        Element elemCartao = new Element("cartao");
        elemCartao.setAttribute(new Attribute("codigo", String.valueOf(cart.getCodigo())));

        Element elemSaldo = new Element("saldo");
        elemSaldo.setText(String.valueOf(cart.getSaldo()));

        Element elemTipo = new Element("tipo");
        elemTipo.setText(cart.getTipo());

        elemCartao.addContent(elemSaldo);
        elemCartao.addContent(elemTipo);

        root.addContent(elemCartao);

        XMLOutputter xmlOutput = new XMLOutputter();

        xmlOutput.setFormat(Format.getPrettyFormat());

        try {
            xmlOutput.output(document, new FileWriter("cartoes.xml"));
        } catch (IOException ex) {
            Logger.getLogger(TicketDAOXML.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void setSaldo(String codigoCartao, String valor) {
        for (Element e : listaCartoes) {
            if (codigoCartao.equals(e.getAttribute("codigo").getValue())) {
                e.getChild("saldo").setText(String.valueOf(valor));
                XMLOutputter xmlOutput = new XMLOutputter();

                xmlOutput.setFormat(Format.getPrettyFormat());

                try {
                    xmlOutput.output(document, new FileWriter("cartoes.xml"));
                } catch (IOException ex) {
                    Logger.getLogger(TicketDAOXML.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public List<Cartao> getCartoes() {
        List<Cartao> cartoes = new ArrayList<>();

        for (Element e : listaCartoes) {

            Cartao c = new Cartao(
                    e.getAttribute("codigo").getValue(),
                    new BigDecimal(e.getChild("saldo").getValue()),
                    e.getChild("tipo").getValue());
            cartoes.add(c);
        }

        return cartoes;
    }

    @Override
    public Cartao getCartao() {
        return getCartoes().get(0);
    }

}
