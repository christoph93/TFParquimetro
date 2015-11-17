/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import negocio.Configuracao;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import persistencia.ParquimetroDAOException;

/**
 *
 * @author ccalifi
 */
public class TesteConfiguração {
    
    public static void main(String[] args) throws IOException, FileNotFoundException, ParquimetroDAOException {
        
        Configuracao c = new Configuracao();
        System.out.println(c.getParquimetro().toString());
        
    }
    
}
