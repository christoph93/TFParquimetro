/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.SwingUtilities;
/**
 *
 * @author lcaltab
 */
public class Init {

    private static void criarGui() {
        Model m = new Model();
        View v = new View();
        Controller c = new Controller();
        
        c.associaModel(m);
        c.associaView(v);

        v.setVisible(true);
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
