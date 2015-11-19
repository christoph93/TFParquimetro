/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import negocio.Cartao;

/**
 *
 * @author ccalifi
 */
public interface CartaoDAO {
    
    public Cartao getCartao(String codigo);
    
    public void addcartao(Cartao cart);
    
    public boolean  setSaldo(String codigoCartao, double valor);
    
    public List<Cartao> getCartoes();
    
    
}
