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

    private Parquimetro p;
    private Endereco e;
    ParquimetroDAO dao;

    public Configuracao() throws FileNotFoundException, IOException, ParquimetroDAOException {
        try {
            this.dao = new ParquimetroDAOXML();
        } catch (SQLException ex) {
            Logger.getLogger(Configuracao.class.getName()).log(Level.SEVERE, null, ex);
        }

        e = dao.getParquimetro().getEnder();
        
        p = dao.getParquimetro();

        
    }

    public Parquimetro getParquimetro() {
        return p;
    }

}
