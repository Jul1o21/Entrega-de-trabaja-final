package modelo;

import java.io.Serializable;

/**
 *
 * @author Favio
 */
public class Alimento  implements Serializable {

    private String tipoAlimento;

    public Alimento(String tipoAlimento) {
        this.tipoAlimento = tipoAlimento;
    }

    public String getTipoAlimento() {
        return tipoAlimento;
    }
    
    

    @Override
    public String toString() {
        return  tipoAlimento;
    }
}
