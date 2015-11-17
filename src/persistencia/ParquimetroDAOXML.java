/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;
import negocio.Endereco;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author lcaltab
 */
public class ParquimetroDAOXML implements ParquimetroDAO {

    private String codigo, rua, cidade, estado, pais, hInicio, hFinal, tMin, tMax, tIncr;
    private int numero;
    private double vIncr;
    private File inputFile;
    private SAXBuilder saxBuilder;
    private Document document;
    private Element elementoParquimetro;
    private List<Element> listaParq;

    public ParquimetroDAOXML() throws ParquimetroDAOException, SQLException {
        try {
            inputFile = new File("parquimetro.xml");

            saxBuilder = new SAXBuilder();

            document = saxBuilder.build(inputFile);

            elementoParquimetro = document.getRootElement();
            
            listaParq = elementoParquimetro.getChildren();

             for (Element parquimetro : listaParq) {
                Attribute attribute = parquimetro.getAttribute("codigo");
                codigo = attribute.getValue();
                rua = parquimetro.getChild("rua").getText();
                cidade = parquimetro.getChild("cidade").getText();
                estado = parquimetro.getChild("estado").getText();
                pais = parquimetro.getChild("pais").getText();
                numero = Integer.parseInt(parquimetro.getChild("numero").getText());

                hInicio = parquimetro.getChild("horaInicio").getText();
                hFinal = parquimetro.getChild("horaFinal").getText();
                tMin = parquimetro.getChild("tempoMin").getText();
                tMax = parquimetro.getChild("tempoMax").getText();
                tIncr = parquimetro.getChild("incremento").getText();
                vIncr = Double.parseDouble(parquimetro.getChild("valorIncremento").getText());
            }
        } catch (JDOMException | IOException e) {
        }
    }

    @Override
    public int getCodigo() {
        return Integer.parseInt(codigo);
    }
 

    @Override
    public Endereco getEndereco() {
        return new Endereco(rua, numero, cidade, estado, pais);
    }

    @Override
    public Time getHoraInicio() {
        return Time.valueOf(hInicio);
    }

    @Override
    public Time getHoraFinal() {
        return Time.valueOf(hFinal);
    }

    @Override
    public Time getTempoMinimo() {
        return Time.valueOf(tMin);
    }

    @Override
    public Time getTempoMaximo() {
        return Time.valueOf(tMax);
    }

    @Override
    public Time getIncremento() {
        return Time.valueOf(tIncr);
    }

    @Override
    public double getValorIncremento() {
        return vIncr;
    }

}
