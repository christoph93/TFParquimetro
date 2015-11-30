/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import negocio.Endereco;
import negocio.Moeda;
import negocio.Parquimetro;
import negocio.Processamento;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lcaltab
 */
public class ProcessamentoTeste {

    private static Processamento p;
    private static Parquimetro p1;
    private static Endereco e;
    private static ArrayList<Moeda> m = new ArrayList<>();

    public ProcessamentoTeste() {
    }

    @BeforeClass
    public static void setUpClass() {
        m.add(Moeda.CINCO);
        m.add(Moeda.DEZ);
        e = new Endereco("Rua", 20, "Porto Alegre", "RS", "Brasil");
        p1 = new Parquimetro(e, 55555, LocalTime.parse("09:00:00"), LocalTime.parse("19:00:00"), Duration.parse("PT30M"), Duration.parse("PT2H"), Duration.parse("PT10M"), 10.0, m);
        p = new Processamento(p1, 55555);
    }

    @Before
    public void setUp() {
        m.add(Moeda.CINCO);
        m.add(Moeda.DEZ);
        e = new Endereco("Rua", 20, "Porto Alegre", "RS", "Brasil");
        p1 = new Parquimetro(e, 55555, LocalTime.parse("09:00:00"), LocalTime.parse("19:00:00"), Duration.parse("PT30M"), Duration.parse("PT2H"), Duration.parse("PT10M"), 10.0, m);
        p = new Processamento(p1, 55555);
    }

    @Test
    public void calculaValorPorTempo() {
        assertEquals(BigDecimal.valueOf(30), p.calculaValorPorTempo());
    }

    @Test
    public void incrementaTempo() {
        assertArrayEquals(new String[]{"0:40:00", "40"}, p.incrementaTempo());
    }

    @Test
    public void existePagamento() {
        assertEquals(false, p.existePagamento());
    }

    @Test
    public void getMinimos() {
        assertArrayEquals(new String[]{"0:30:00", "30"}, p.getMinimos());
    }

    @Test
    public void decrementaTempo() {
        p.incrementaTempo();
        assertArrayEquals(new String[]{"0:30:00", "30"}, p.decrementaTempo());
    }

    @Test
    public void insereMoeada() {
        assertEquals(true, p.insereMoeada(BigDecimal.valueOf(0.10)));
    }

    @Test
    public void insereMoeadaNaoExistente() {
        assertEquals(false, p.insereMoeada(BigDecimal.valueOf(0.25)));
    }

    @Test
    public void getMoedasAsString() {
        assertEquals("", p.getMoedasAsString());
    }
}
