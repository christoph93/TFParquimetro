/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.ParquimetroDAO;
import persistencia.ParquimetroDAOXML;
import persistencia.ParquimetroDAOException;

/**
 *
 * @author ccalifi
 */
public class Configuracao {

    private ParquimetroDAOXML dao;
    
    public Configuracao() throws FileNotFoundException, IOException, ParquimetroDAOException {
        
        Parquimetro p = dao.getParquimetro();      
        
        
        }

}
