/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.security.CodeSource;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.ParquimetroDAOException;

/**
 *
 * @author ccalifi
 */
public class Inicializcao {

    public static void main(String[] args) throws UnsupportedEncodingException, URISyntaxException, IOException, FileNotFoundException, ParquimetroDAOException {
        CodeSource codeSource = Inicializcao.class.getProtectionDomain().getCodeSource();
        File jarFile = new File(codeSource.getLocation().toURI().getPath());
        String jarDir = jarFile.getParentFile().getPath();

        try {

            //Configuracao c = new Configuracao(jarDir + "\\" + "parquimetro.xml");
            Configuracao c = new Configuracao();

        } catch (IOException ex) {
            Logger.getLogger(Inicializcao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
