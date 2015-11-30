/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import negocio.Endereco;
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
public class EnderecoTeste {

    private static Endereco e;

    public EnderecoTeste() {
    }

    @BeforeClass
    public static void setUpClass() {
        e = new Endereco("Rua", 20, "Porto Alegre", "RS", "Brasil");
    }

    @Test
    public void getNomeRua() {
        assertEquals("Rua", e.getNomeRua());
    }

    public void getEstado() {
        assertEquals("RS", e.getEstado());
    }

    public void getCidade() {
        assertEquals("Porto Alegre", e.getCidade());
    }

    public void getPais() {
        assertEquals("Brasil", e.getPais());
    }

    public void getNumero() {
        assertEquals(20, e.getNumero());
    }
}
