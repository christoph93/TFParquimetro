package test;

import java.math.BigDecimal;
import negocio.Cartao;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @authors Christoph Califice, Lucas Caltabiano
 */
public class CartaoTeste {

    private static Cartao c;

    public CartaoTeste() {
    }

    @BeforeClass
    public static void setUpClass() {
        c = new Cartao("123456789", BigDecimal.valueOf(200.0), "Residente");
    }

    @Before
    public void setUp() {
        c = new Cartao("123456789", BigDecimal.valueOf(200.0), "Residente");
    }

    @Test
    public void getCodigo() {
        assertEquals("123456789", c.getCodigo());
    }

    @Test
    public void getSaldo() {
        assertEquals(BigDecimal.valueOf(200.0), c.getSaldo());
    }

    @Test
    public void setSaldo() {
        c.setSaldo(BigDecimal.valueOf(350));
        assertEquals(BigDecimal.valueOf(350), c.getSaldo());
    }

    @Test
    public void getTipo() {
        assertEquals("Residente", c.getTipo());
    }
}
