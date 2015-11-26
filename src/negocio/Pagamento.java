/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;




/**
 *
 * @author ccalifi
 */
public interface Pagamento {
    
    public double getValor();
    
    public boolean recebe();
    
    public boolean recebe(Moeda moed);
    
}
