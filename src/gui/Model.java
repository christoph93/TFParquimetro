/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author ccalifi
 */
public class Model {
    private int contador;
    
    public void setValor(int v){
        contador = v;
    }
    
    public int getValor() {
        return contador;
    }
    
    public void incrementaValor() {
        contador++;
    }
}
