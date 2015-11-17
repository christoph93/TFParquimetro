/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author ccalifi
 */
public class Endereco {

    private final String nomeRua;
    private final String estado;
    private final String cidade;
    private final String pais;
    private final int numero;

    public Endereco(String rua, int num, String cida, String est, String pais) {
        nomeRua = rua;
        numero = num;
        cidade = cida;
        estado = est;
        this.pais = pais;
    }

    public Endereco(String r, String c, String e, String p) {
        nomeRua = r;
        numero = -1;
        cidade = c;
        estado = e;
        pais = p;
    }

    public String getNomeRua() {
        return nomeRua;
    }

    public String getEstado() {
        return estado;
    }

    public String getCidade() {
        return cidade;
    }

    public String getPais() {
        return pais;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return nomeRua + ", " + numero + " - " + cidade + ", " + estado + ", " + pais;
    }

    
    
}
