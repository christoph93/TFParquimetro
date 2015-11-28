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
public class Controller {

    private Model model;
    private View view;
    private ActionListener incrementa, btCancelar, btUm, btImprimir, btDecrementa, btDez, btCinq, btQuarter, btCinco, btCartao, btLogs;

    public void associaModel(Model m) {
        model = m;
    }

    public void associaView(View v) {
        view = v;
        view.getTempo().setText(model.getTempo());
        view.getValor().setText(model.getValor());
    }

    public void setUpViewEvents() {
        incrementa = (ActionEvent actionEvent) -> {
            System.out.println("Teste incrementa!");
            String[] aux = model.incrementaTempo();
            view.getTempo().setText(aux[0]);
            view.getValor().setText(aux[1]);
        };
        view.getIncrementa().addActionListener(incrementa);

        btCancelar = (ActionEvent actionEvent) -> {
            System.out.println("Teste Cancelar!");
            setMoedaEnable(Boolean.TRUE);
            setCartaoEnable(Boolean.TRUE);
            model.clear();
            view.getTempo().setText(model.getTempo());
            view.getValor().setText(model.getValor());
            view.getConsole().setText(model.cancela());
        };
        view.getBtCancelar().addActionListener(btCancelar);

        btUm = (ActionEvent actionEvent) -> {
            System.out.println("Teste R$1.00!");
            setCartaoEnable(Boolean.FALSE);
            view.getConsole().setText(view.getConsole().getText() + "\n" + model.setValor(BigDecimal.valueOf(1.00)));
        };
        view.getBtUm().addActionListener(btUm);

        btImprimir = (ActionEvent actionEvent) -> {
            System.out.println("Teste Imprimir!");
            setMoedaEnable(Boolean.TRUE);
            setCartaoEnable(Boolean.TRUE);
            view.getConsole().setText(model.imprime());
        };
        view.getBtImprimir().addActionListener(btImprimir);

        btDecrementa = (ActionEvent actionEvent) -> {
            System.out.println("Teste decrementa!");
            String[] aux = model.decrementaTempo();
            view.getTempo().setText(aux[0]);
            view.getValor().setText(aux[1]);
        };
        view.getBtDecrementa().addActionListener(btDecrementa);

        btDez = (ActionEvent actionEvent) -> {
            System.out.println("Teste R$0.10!");
            setCartaoEnable(Boolean.FALSE);
            view.getConsole().setText(view.getConsole().getText() + "\n" + model.setValor(BigDecimal.valueOf(0.10)));
        };
        view.getBtDez().addActionListener(btDez);

        btCinq = (ActionEvent actionEvent) -> {
            System.out.println("Teste R$0.50!");
            setCartaoEnable(Boolean.FALSE);
            view.getConsole().setText(view.getConsole().getText() + "\n" + model.setValor(BigDecimal.valueOf(0.50)));
        };
        view.getBtCinq().addActionListener(btCinq);

        btQuarter = (ActionEvent actionEvent) -> {
            System.out.println("Teste R$0.25!");
            setCartaoEnable(Boolean.FALSE);
            view.getConsole().setText(view.getConsole().getText() + "\n" + model.setValor(BigDecimal.valueOf(0.25)));
        };
        view.getBtQuarter().addActionListener(btQuarter);

        btCinco = (ActionEvent actionEvent) -> {
            System.out.println("Teste R$0.05!");
            setCartaoEnable(Boolean.FALSE);
            view.getConsole().setText(view.getConsole().getText() + "\n" + model.setValor(BigDecimal.valueOf(0.05)));
        };
        view.getBtCinco().addActionListener(btCinco);

        btCartao = (ActionEvent actionEvent) -> {
            System.out.println("Teste Cartão");
            setMoedaEnable(Boolean.FALSE);
            view.getConsole().setText("\n" + model.passaCartao());
        };
        view.getBtCartao().addActionListener(btCartao);
        
        btLogs = (ActionEvent actionEvent) -> {
            System.out.println("Teste Logs");
            model.geraLog();
            view.getConsole().setText("Logs gerados");
        };
        view.getBtLogs().addActionListener(btLogs);
    }

    public void setCartaoEnable(Boolean t) {
        view.getBtCartao().setEnabled(t);
    }

    public void setMoedaEnable(Boolean t) {
        view.getBtCinco().setEnabled(t);
        view.getBtCinq().setEnabled(t);
        view.getBtDez().setEnabled(t);
        view.getBtQuarter().setEnabled(t);
        view.getBtUm().setEnabled(t);
    }
}
