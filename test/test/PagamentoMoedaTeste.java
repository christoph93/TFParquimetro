package test;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import negocio.Endereco;
import negocio.Moeda;
import negocio.PagamentoMoeda;
import negocio.Parquimetro;
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
public class PagamentoMoedaTeste {

    private static Parquimetro p;
    private static Endereco e;
    private static ArrayList<Moeda> m = new ArrayList<>();
    private static PagamentoMoeda pm;

    public PagamentoMoedaTeste() {
    }

    @BeforeClass
    public static void setUpClass() {
        m.add(Moeda.CINCO);
        m.add(Moeda.DEZ);
        e = new Endereco("Rua", 20, "Porto Alegre", "RS", "Brasil");
        p = new Parquimetro(e, 55555, LocalTime.parse("09:00:00"), LocalTime.parse("19:00:00"), Duration.parse("PT30M"), Duration.parse("PT2H"), Duration.parse("PT10M"), 10.0, m);
        pm = new PagamentoMoeda(p);
    }

    @Before
    public void setUp() {
        m.add(Moeda.CINCO);
        m.add(Moeda.DEZ);
        e = new Endereco("Rua", 20, "Porto Alegre", "RS", "Brasil");
        p = new Parquimetro(e, 55555, LocalTime.parse("09:00:00"), LocalTime.parse("19:00:00"), Duration.parse("PT30M"), Duration.parse("PT2H"), Duration.parse("PT10M"), 10.0, m);
        pm = new PagamentoMoeda(p);
    }

    @Test
    public void recebeMoeda() {
        assertEquals(true, pm.recebe(Moeda.CINCO));
    }

    @Test
    public void getValor() {
        assertEquals(BigDecimal.valueOf(0), pm.getValor());
    }

    @Test
    public void recebe() {
        assertEquals(false, pm.recebe());
    }

}
