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
import negocio.Parquimetro;
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

    private File inputFile;
    private SAXBuilder saxBuilder;
    private Document document;
    private Element parq;

    public ParquimetroDAOXML() throws ParquimetroDAOException, SQLException, IOException {
        try {
            inputFile = new File("parquimetro.xml");

            saxBuilder = new SAXBuilder();

            document = saxBuilder.build(inputFile);

            parq = document.getRootElement();

        } catch (JDOMException e) {
        }
    }

    @Override
    public Parquimetro getParquimetro() {

        String rua, cidade, estado, pais;
        Time hInicio, hFinal, tMin, tMax, tIncr;
        int numero, codigo;
        double vIncr;

        Element parquimetro = parq.getChild("parquimetro");

        Attribute attCodigo = parquimetro.getAttribute("codigo");
        codigo = Integer.parseInt(attCodigo.getValue());
        rua = parquimetro.getChild("rua").getText();
        cidade = parquimetro.getChild("cidade").getText();
        estado = parquimetro.getChild("estado").getText();
        pais = parquimetro.getChild("pais").getText();
        numero = Integer.parseInt(parquimetro.getChild("numero").getText());

        hInicio = Time.valueOf(parquimetro.getChild("horaInicio").getText());
        hFinal = Time.valueOf(parquimetro.getChild("horaFinal").getText());
        tMin = Time.valueOf(parquimetro.getChild("tempoMin").getText());
        tMax = Time.valueOf(parquimetro.getChild("tempoMax").getText());
        tIncr = Time.valueOf(parquimetro.getChild("incremento").getText());
        vIncr = Double.parseDouble(parquimetro.getChild("valorIncremento").getText());

        Endereco e = new Endereco(rua, numero, cidade, estado, pais);
        Parquimetro p = new Parquimetro(e, codigo, hInicio, hFinal, tMin, tMax, tIncr, vIncr);

        return p;
    }

}
