/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Ticket {

    private final Parquimetro parq;
    private final Endereco endereco;
    private final int codigo;
    private final LocalDateTime emissao;
    private final LocalDateTime validade;
    private final BigDecimal valor;

    public Ticket(Parquimetro par, Endereco end, int codigo, BigDecimal valor, LocalDateTime emiss, LocalDateTime val) {
        this.valor = valor;
        parq = par;
        endereco = end;
        this.codigo = codigo;
        emissao = emiss;
        validade = val;
    }

    public Parquimetro getParquimetro() {
        return parq;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public int getNumero() {
        return codigo;
    }

    public LocalDateTime getEmissao() {
        return emissao;
    }

    public LocalDateTime getValidade() {
        return validade;
    }

    // Número de identificação do parquímetro (5 dígitos de tamanho fixo);
// Endereço do parquímetro;
// Número serial do tíquete emitido (5 dígitos de tamanho fixo);
// Data e hora de emissão do tíquete;
// Data e hora de validade do tíquete.
    
    @Override
    public String toString() {
        return "Parquimetro: " + parq.getCodigo() +
                "\nEndereço: " + parq.getEnder().toString() +
                "\nTicket:   " + codigo +
                "\nEmissão:  " + emissao.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)) +
                "\nValidade: " + validade.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT));
    }

}
