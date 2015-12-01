package negocio;

/**
 *
 * @authors Christoph Califice, Lucas Caltabiano
 */
public enum Moeda {
    CINCO (0.05),
    DEZ (0.10),
    VINTEECINCO (0.25), 
    CINQUENTA (0.50), 
    UMREAL (1.00);
    
    private final double valor;
    
    
    Moeda(double v){
        valor = v;
    }    
    
    public double valor(){
        return this.valor;
    }
    
    
        
}
