/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author ccalifi
 */
public class Impressao {
    
    Timestamp now;
    

    public Impressao() {
        now = new Timestamp(System.currentTimeMillis());
    }

    public boolean imprime(Ticket tick) {
        Ticket t = tick;
        
        //     Número de identificação do parquímetro (5 dígitos de tamanho fixo);
// Endereço do parquímetro;
// Número serial do tíquete emitido (5 dígitos de tamanho fixo);
// Data e hora de emissão do tíquete;
// Data e hora de validade do tíquete.

        try {
            PrintWriter writer = new PrintWriter("ticket" + t.getNumero() + ".txt", "UTF-8");
            writer.println("Ticket número " + t.getNumero());
            writer.println("Endereço do parquímetro: " + t.getEndereco().toString());
            writer.println("Número do parquímetro: " + t.getParquimetro().getCodigo());
            writer.println("Tíquete emitido em " + t.getEmissao().toString());
            writer.println("Tíquete válido até " + t.getValidade().toString());
            writer.close();
            return true;
            
        } catch (IOException ex) {
            Logger.getLogger(Impressao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
    
    
    public boolean imprime(Log lo){
        Log l = lo;
        
        try {
            PrintWriter writer = new PrintWriter("log" + l.getTicket().getNumero() + ".txt", "UTF-8");
            writer.println("Informações do ticket: \n" + l.getTicket().toString());
            writer.println("Informações do parquímetro: \n" + l.getParquimetro().toString());
            writer.println("Informações do cartão: \n" + l.getCartao().toString());
            writer.println("Log gerado em: " + now.toString());
            writer.close();
            return true;
            
        } catch (IOException ex) {
            Logger.getLogger(Impressao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

}
