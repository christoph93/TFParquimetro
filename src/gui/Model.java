/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.Moeda;
import negocio.Pagamento;
import negocio.PagamentoCartao;
import negocio.PagamentoMoeda;
import negocio.Parquimetro;
import negocio.Processamento;
import persistencia.ParquimetroDAOException;
import persistencia.ParquimetroDAOXML;

/**
 *
 * @author ccalifi
 */
public class Model {        
        private ParquimetroDAOXML daoP;
        private Parquimetro p;
        private Processamento proc;
        private boolean existePagMoeda = false;
        private Pagamento pag;
        
        
        
        public Model(){
            try {                
                daoP  = new ParquimetroDAOXML();
                p = daoP.getParquimetro(); 
                proc = new Processamento(p);
            } catch (ParquimetroDAOException ex) {
                Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    public void incrementaTempo(){
        
    }
        
    public void decrementaTempo() {
        
    }
    
        
    public void cancelar(){
        //cancela
    }
    
    public void imprime(){
        
    }
    
    public void insereCinco(){
        if(!existePagMoeda){
            try {
                pag = new PagamentoMoeda();
            } catch (ParquimetroDAOException ex) {
                Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        existePagMoeda = true;
        proc.insereMoeada(Moeda.CINCO);
    }
    
    public void insereDez(){
        existePagMoeda = true;
    proc.insereMoeada(Moeda.DEZ);    
    }
    
    public void insereVinteECinco(){
        existePagMoeda = true;
        proc.insereMoeada(Moeda.VINTEECINCO);
    }
 
    
    public void insereCinquenta(){
        existePagMoeda = true;
        proc.insereMoeada(Moeda.CINQUENTA);
    }
    
    public void insereUm(){
        existePagMoeda = true;
        proc.insereMoeada(Moeda.UMREAL);
    }
    
    public void pagaComCartao(){
        
    }
    
}
