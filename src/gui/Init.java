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
 * @authors Christoph Califice, Lucas Caltabiano
 */
public class Init {

    
    
    private static void criarGui() {
        try {

            ParquimetroDAOXML daoP = new ParquimetroDAOXML();
            Parquimetro p = daoP.getParquimetro();
            
            Model m = new Model(p);
            View v = new View();
            Controller c = new Controller();

            System.out.println(p);
            
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
