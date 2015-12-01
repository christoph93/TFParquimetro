package negocio;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 *
 * @authors Christoph Califice, Lucas Caltabiano
 */

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

    
    @Override
    public String toString() {
        return "Parquimetro: " + parq.getCodigo() +
                "\nEndereço: " + parq.getEnder().toString() +
                "\nTicket:   " + codigo +
                "\nEmissão:  " + emissao.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)) +
                "\nValidade: " + validade.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT));
    }

}
