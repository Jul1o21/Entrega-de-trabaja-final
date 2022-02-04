
package modelo;

import java.io.Serializable;

/**
 *
 * @author Favio
 */
public class Nivel  implements Serializable {
      private int numeronivel;

    public Nivel(int tiponivel) {
        this.numeronivel = tiponivel;
    }

    public int getNumeronivel() {
        return numeronivel;
    }
    
    

    @Override
    public String toString() {
        return " " + numeronivel;
    }
}
