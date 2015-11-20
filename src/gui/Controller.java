/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author ccalifi
 */
public class Controller{
    private Model model;
    private View view;
    private ActionListener incrementa,btCancelar,btUm,btImprimir,btDecrementa,btDez;
    
    public void associaModel(Model m){
        model = m;
    }
    
    public void associaView(View v) {
        view = v;
    }
   
    public void setUpViewEvents() {
        incrementa = new ActionListener() {
         public void actionPerformed(ActionEvent actionEvent) {                  
          //TODO
         }
        };                
        view.getIncrementa().addActionListener(incrementa);

        btCancelar = new ActionListener() {
         public void actionPerformed(ActionEvent actionEvent) {                  
          //TODO
         }
        };                
        view.getBtCancelar().addActionListener(btCancelar);

        btUm = new ActionListener() {
         public void actionPerformed(ActionEvent actionEvent) {                  
          //TODO
         }
        };                
        view.getBtUm().addActionListener(btUm);
        
        btImprimir = new ActionListener() {
         public void actionPerformed(ActionEvent actionEvent) {                  
          //TODO
         }
        };                
        view.getBtImprimir().addActionListener(btImprimir);
        
        btDecrementa = new ActionListener() {
         public void actionPerformed(ActionEvent actionEvent) {                  
          //TODO
         }
        };                
        view.getBtDecrementa().addActionListener(btDecrementa);
        
        btDez = new ActionListener() {
         public void actionPerformed(ActionEvent actionEvent) {                  
          //TODO
         }
        };                
        view.getBtDez().addActionListener(btDez);        
    }    
}
