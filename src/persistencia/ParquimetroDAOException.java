package persistencia;

/**
 *
 * @authors Christoph Califice, Lucas Caltabiano
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
