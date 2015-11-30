/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import negocio.Endereco;
import negocio.Moeda;
import negocio.Parquimetro;
import negocio.Ticket;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lcaltab
 */
public class TicketTeste {

    private static Ticket t;
    private static Parquimetro p;
    private static Endereco e;
    private static ArrayList<Moeda> m = new ArrayList<>();

    public TicketTeste() {
    }

    @BeforeClass
    public static void setUpClass() {
        m.add(Moeda.CINCO);
        m.add(Moeda.DEZ);
        e = new Endereco("Rua", 20, "Porto Alegre", "RS", "Brasil");
        p = new Parquimetro(e, 55555, LocalTime.parse("09:00:00"), LocalTime.parse("19:00:00"), Duration.parse("PT30M"), Duration.parse("PT2H"), Duration.parse("PT10M"), 10.0, m);
        t = new Ticket(p, e, 552135, BigDecimal.valueOf(3.0), LocalDateTime.parse("2007-12-03T10:15:30"), LocalDateTime.parse("2007-12-03T10:15:35"));
    }

    @Before
    public void setUp() {
        m.add(Moeda.CINCO);
        m.add(Moeda.DEZ);
        e = new Endereco("Rua", 20, "Porto Alegre", "RS", "Brasil");
        p = new Parquimetro(e, 55555, LocalTime.parse("09:00:00"), LocalTime.parse("19:00:00"), Duration.parse("PT30M"), Duration.parse("PT2H"), Duration.parse("PT10M"), 10.0, m);
        t = new Ticket(p, e, 552135, BigDecimal.valueOf(3.0), LocalDateTime.parse("2007-12-03T10:15:30"), LocalDateTime.parse("2007-12-03T10:15:35"));
    }

    @Test
    public void getParquimetro() {
        assertEquals(p, t.getParquimetro());
    }

    @Test
    public void getValor() {
        assertEquals(BigDecimal.valueOf(3.0), t.getValor());
    }

    @Test
    public void getEndereco() {
        assertEquals(e, t.getEndereco());
    }

    @Test
    public void getNumero() {
        assertEquals(552135, t.getNumero());
    }

    @Test
    public void getEmissao() {
        assertEquals(LocalDateTime.parse("2007-12-03T10:15:30"), t.getEmissao());
    }

    @Test
    public void getValidade() {
        assertEquals(LocalDateTime.parse("2007-12-03T10:15:35"), t.getValidade());
    }
}
