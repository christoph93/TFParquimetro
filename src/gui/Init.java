/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import negocio.Facade;
import negocio.Parquimetro;
import persistencia.ParquimetroDAOException;
import persistencia.ParquimetroDAOXML;
/**
 *
 * @author lcaltab
 */
public class Init {

    
    
    private static void criarGui() {
        try {
            Model m = new Model();
            View v = new View();
            Controller c = new Controller();
            
            ParquimetroDAOXML daoP = new ParquimetroDAOXML();
            Parquimetro p = daoP.getParquimetro();
            Facade f = new Facade(p);
            
            c.associaModel(m);
            c.associaView(v);
            
            c.setUpViewEvents();
            v.setVisible(true);
            
            
            
        } catch (ParquimetroDAOException ex) {
            Logger.getLogger(Init.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Init.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Init.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                criarGui();
            }
        });
    }
}
