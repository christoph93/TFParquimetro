package test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import negocio.Endereco;
import negocio.Moeda;
import negocio.Parquimetro;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author lcaltab
 */
public class ParquimetroTeste {

    private static Parquimetro p;
    private static Endereco e;
    private static ArrayList<Moeda> m = new ArrayList<>();

    public ParquimetroTeste() {
    }

    @BeforeClass
    public static void createParquimetro() {
        m.add(Moeda.CINCO);
        m.add(Moeda.DEZ);
        e = new Endereco("Rua", 20, "Porto Alegre", "RS", "Brasil");
        p = new Parquimetro(e, 55555, LocalTime.parse("09:00:00"), LocalTime.parse("19:00:00"), Duration.parse("PT30M"), Duration.parse("PT2H"), Duration.parse("PT10M"), 10.0, m);
    }

    @Before
    public void setUp() {
        e = new Endereco("Rua", 20, "Porto Alegre", "RS", "Brasil");
        p = new Parquimetro(e, 55555, LocalTime.parse("09:00:00"), LocalTime.parse("19:00:00"), Duration.parse("PT30M"), Duration.parse("PT2H"), Duration.parse("PT10M"), 10.0, m);
    }

    @Test
    public void getMoedas() {
        assertEquals(m, p.getMoedas());
    }

    public void setMoedas() {
        ArrayList<Moeda> m1 = new ArrayList<>();
        m1.add(Moeda.DEZ);
        m1.add(Moeda.CINQUENTA);
        m1.add(Moeda.VINTEECINCO);
        p.setMoedas(m1);
        assertEquals(m1, p.getMoedas());
    }

    @Test
    public void getCodigo() {
        assertEquals(55555, p.getCodigo());
    }

    public void setCodigo() {
        p.setCodigo(12345);
        assertEquals(12345, p.getCodigo());
    }

    @Test
    public void getEnder() {
        assertEquals(e, p.getEnder());
    }

    public void setEnder() {
        Endereco e1 = new Endereco("Rua1", 25, "Porto Alegre", "RS", "Brasil");
        p.setEnder(e1);
        assertEquals(e1, p.getEnder());
    }

    @Test
    public void getHoraInicio() {
        assertEquals(LocalTime.parse("09:00:00"), p.getHoraInicio());
    }

    @Test
    public void setHoraInicio() {
        p.setHoraInicio(LocalTime.parse("10:00:00"));
        assertEquals(LocalTime.parse("10:00:00"), p.getHoraInicio());
    }

    @Test
    public void getValorIncremento() {
        assertEquals(10.0, p.getValorIncremento(), 0);
    }

    @Test
    public void setValorIncremento() {
        p.setValorIncremento(15);
        assertEquals(15.0, p.getValorIncremento(), 0);
    }

    @Test
    public void getHoraFim() {
        assertEquals(LocalTime.parse("19:00:00"), p.getHoraFim());
    }

    @Test
    public void setHoraFim() {
        p.setHoraFim(LocalTime.parse("20:00:00"));
        assertEquals(LocalTime.parse("20:00:00"), p.getHoraFim());
    }

    @Test
    public void getTempoMin() {
        assertEquals(Duration.parse("PT30M"), p.getTempoMin());
    }

    @Test
    public void setTempoMin() {
        p.setTempoMin(Duration.parse("PT40M"));
        assertEquals(Duration.parse("PT40M"), p.getTempoMin());
    }

    @Test
    public void getTempoMax() {
        assertEquals(Duration.parse("PT2H"), p.getTempoMax());
    }

    @Test
    public void setTempoMax() {
        p.setTempoMax(Duration.parse("PT3H"));
        assertEquals(Duration.parse("PT3H"), p.getTempoMax());
    }

    @Test
    public void getIncremento() {
        assertEquals(Duration.parse("PT10M"), p.getIncremento());
    }

    @Test
    public void setIncremento() {
        p.setIncremento(Duration.parse("PT15M"));
        assertEquals(Duration.parse("PT15M"), p.getIncremento());
    }
}
