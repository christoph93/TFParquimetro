/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

/**
 *
 * @author lcaltab
 */
public class ParquimetroDAOException extends Exception {
    public ParquimetroDAOException() {
    }
    
    public ParquimetroDAOException(String msg) {
        super(msg);
    }

    public ParquimetroDAOException(String message, Throwable cause) {
        super(message, cause);
    }
}
