/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.File;
import java.io.IOException;
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

    private String codigo, tipo;
    private double saldo;
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

            for (Element parquimetro : listaCartoes) {
                Attribute attribute = parquimetro.getAttribute("codigo");
                codigo = attribute.getValue();

            }
        } catch (JDOMException | IOException e) {
        }

    }

    @Override
    public Cartao getCartao(String codigo) {
        Cartao c = null;

        for (Element e : listaCartoes) {
            if (codigo.equals(e.getAttribute("codigo").getValue())) {
                this.codigo = e.getAttribute("codigo").getValue();
                this.saldo = Double.parseDouble(e.getChild("saldo").getValue());
                this.tipo = e.getChild("tipo").getValue();
                c = new Cartao(this.codigo, this.saldo, this.tipo);
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
            if (codigo.equals(e.getAttribute("codigo").getValue())) {
                e.getChild("saldo").setText(String.valueOf(valor));
                return true;
            }
        }
        return false;
    }

}
