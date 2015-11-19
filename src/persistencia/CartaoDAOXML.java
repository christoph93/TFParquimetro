/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.File;
import java.io.IOException;
import java.util.List;
import negocio.Cartao;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

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
        double saldo;

        for (Element e : listaCartoes) {
            if (codigo.equals(e.getAttribute("codigo").getValue())) {
                cod = e.getAttribute("codigo").getValue();
                saldo = Double.parseDouble(e.getChild("saldo").getValue());
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

    }

    @Override
    public boolean setSaldo(String codigoCartao, double valor) {
        for (Element e : listaCartoes) {
            if (codigoCartao.equals(e.getAttribute("codigo").getValue())) {
                e.getChild("saldo").setText(String.valueOf(valor));
                return true;
            }
        }
        return false;
    }

}
