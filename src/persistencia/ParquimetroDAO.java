/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Time;
import negocio.Endereco;

/**
 *
 * @author ccalifi
 */
public interface ParquimetroDAO {

    public int getCodigo();

    public double getValorIncremento();

    public Endereco getEndereco();

    public Time getHoraInicio();

    public Time getHoraFinal();

    public Time getTempoMinimo();

    public Time getTempoMaximo();

    public Time getIncremento();

}
