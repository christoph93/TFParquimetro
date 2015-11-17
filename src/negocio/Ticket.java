/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.sql.Time;

/**
 *
 * @author ccalifi
 */
public class Ticket {
    
// Número de identificação do parquímetro (5 dígitos de tamanho fixo);
// Endereço do parquímetro;
// Número serial do tíquete emitido (5 dígitos de tamanho fixo);
// Data e hora de emissão do tíquete;
// Data e hora de validade do tíquete.
    
    
    
    private final Parquimetro parq;
    private final Endereco endereco;
    private final int codigo;
    private final Time emissao;
    private final Time validade;
    private final double valor;
    
    public Ticket(Parquimetro par, Endereco end,int codigo, double valor, Time emiss, Time val){
        this.valor = valor;
        parq = par;
        endereco = end;
        this.codigo = codigo;
        emissao = emiss;
        validade = val;                
    }
    
    
    private int geraCodigo(){
        return 55555; // fazer geração de código
    }

    public Parquimetro getParquimetro() {
        return parq;
    }

 
    public double getValor() {
        return valor;
    }
    
    
    public Endereco getEndereco() {
        return endereco;
    }

    public int getNumero() {
        return codigo;
    }

    public Time getEmissao() {
        return emissao;
    }

    public Time getValidade() {
        return validade;
    }

    @Override
    public String toString() {
        return "Ticket{" + "parq=" + parq + ", endereco=" + endereco + ", codigo=" + codigo + ", emissao=" + emissao + ", validade=" + validade + ", valor=" + valor + '}';
    }

    
    
    
    
    
}
