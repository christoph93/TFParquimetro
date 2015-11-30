/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.math.BigDecimal;
import negocio.Cartao;
import negocio.Moeda;
import negocio.PagamentoCartao;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author lcaltab
 */
public class PagamentoCartaoTeste {
    
    private static Cartao ca;
    private static BigDecimal valorTicket;
    private static PagamentoCartao c;
    
    public PagamentoCartaoTeste() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        ca = new Cartao("123456789", BigDecimal.valueOf(200.0), "Residente");
        valorTicket = BigDecimal.valueOf(3.00);
        c = new PagamentoCartao(ca, valorTicket);
    }
    
    @Before
    public void setUp() {
        ca = new Cartao("123456789", BigDecimal.valueOf(200.0), "Residente");
        valorTicket = BigDecimal.valueOf(3.00);
        c = new PagamentoCartao(ca, valorTicket);
    }
    
    @Test
    public void recebe() {
        assertEquals(true, c.recebe());
        
    }
    
    @Test
    public void getValor() {
        c.recebe();
        assertEquals(BigDecimal.valueOf(3.00), c.getValor());
    }

    @Test
    public void recebeMoeda() {
        Moeda m = Moeda.CINQUENTA;
        assertEquals(false, c.recebe(m));
    }
    
}
