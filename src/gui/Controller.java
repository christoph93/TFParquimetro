/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
/**
 *
 * @author ccalifi
 */
public class Controller{
    private Model model;
    private View view;
    private ActionListener incrementa,btCancelar,btUm,btImprimir,btDecrementa,btDez,btCinq,btQuarter,btCinco,btCartao;
    
    public void associaModel(Model m){
        model = m;
    }
    
    public void associaView(View v) {
        view = v;
    }
   
    public void setUpViewEvents() {
        incrementa = (ActionEvent actionEvent) -> {
            System.out.println("Teste incrementa!");
            model.setTempo(10);
            view.getTempo().setText(model.getTempo().toString());
        };                
        view.getIncrementa().addActionListener(incrementa);

        btCancelar = (ActionEvent actionEvent) -> {
            System.out.println("Teste Cancelar!");
            setMoedaEnable(Boolean.TRUE);
            setCartaoEnable(Boolean.TRUE);
            model.clear();
            view.getTempo().setText(model.getTempo().toString());
            view.getValor().setText(model.getValor().toString());
            view.getConsole().setText(null);
        };                
        view.getBtCancelar().addActionListener(btCancelar);

        btUm = (ActionEvent actionEvent) -> {
            System.out.println("Teste R$1.00!");
            setCartaoEnable(Boolean.FALSE);
            view.getConsole().setText(view.getConsole().getText() + "\n" + model.setValor(BigDecimal.valueOf(1.00)));
            view.getValor().setText(model.getValor().toString());
        };                
        view.getBtUm().addActionListener(btUm);
        
        btImprimir = (ActionEvent actionEvent) -> {
            System.out.println("Teste Imprimir!");
            setMoedaEnable(Boolean.TRUE);
            setCartaoEnable(Boolean.TRUE);
        };                
        view.getBtImprimir().addActionListener(btImprimir);
        
        btDecrementa = (ActionEvent actionEvent) -> {
            System.out.println("Teste decrementa!");
            model.setTempo(-10);
            view.getTempo().setText(model.getTempo().toString());            
        };                
        view.getBtDecrementa().addActionListener(btDecrementa);
        
        btDez = (ActionEvent actionEvent) -> {
            System.out.println("Teste R$0.10!");
            setCartaoEnable(Boolean.FALSE);
            view.getConsole().setText(view.getConsole().getText() + "\n" + model.setValor(BigDecimal.valueOf(0.10)));
            view.getValor().setText(model.getValor().toString());
        };                
        view.getBtDez().addActionListener(btDez);
        
        btCinq = (ActionEvent actionEvent) -> {
            System.out.println("Teste R$0.50!");
            setCartaoEnable(Boolean.FALSE);
            view.getConsole().setText(view.getConsole().getText() + "\n" + model.setValor(BigDecimal.valueOf(0.50)));
            view.getValor().setText(model.getValor().toString());
        };                
        view.getBtCinq().addActionListener(btCinq);
        
        btQuarter = (ActionEvent actionEvent) -> {
            System.out.println("Teste R$0.25!");
            setCartaoEnable(Boolean.FALSE);
            view.getConsole().setText(view.getConsole().getText() + "\n" + model.setValor(BigDecimal.valueOf(0.25)));
            view.getValor().setText(model.getValor().toString());
        };                
        view.getBtQuarter().addActionListener(btQuarter);
        
        btCinco = (ActionEvent actionEvent) -> {
            System.out.println("Teste R$0.05!");
            setCartaoEnable(Boolean.FALSE);
            view.getConsole().setText(view.getConsole().getText() + "\n" + model.setValor(BigDecimal.valueOf(0.05)));
            view.getValor().setText(model.getValor().toString());
        };                
        view.getBtCinco().addActionListener(btCinco);
        
        btCartao = (ActionEvent actionEvent) -> {
            System.out.println("Teste Cartão");
            setMoedaEnable(Boolean.FALSE);
        };                
        view.getBtCartao().addActionListener(btCartao);        
    }
    
    public void setCartaoEnable(Boolean t){
        view.getBtCartao().setEnabled(t);
    }
    
    public void setMoedaEnable(Boolean t){
        view.getBtCinco().setEnabled(t);
        view.getBtCinq().setEnabled(t);
        view.getBtDez().setEnabled(t);
        view.getBtQuarter().setEnabled(t);
        view.getBtUm().setEnabled(t);        
    }
}
