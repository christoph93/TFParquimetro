/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import negocio.Endereco;

/**
 *
 * @author ccalifi
 */
public class TesteEndereco {
    
    public static void main(String[] args) {
        Endereco e = new Endereco("Rua ABC", 123, "Cidade C", "Estado C", "Pais P");
        Endereco e2 = new Endereco("Rua ABC", "Cidade C", "Estado C", "Pais P");
        System.out.println("Construtor completo:" + e.toString());
        System.out.println("Construtor sem numero:" + e2.toString());
    }
    
}
