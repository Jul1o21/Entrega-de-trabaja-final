
package modelo;

import java.io.Serializable;
import java.util.Arrays;

/**
 *
 * @author Favio
 */
public class ArregloFecha  implements Serializable {
    private final Fecha FechaA[];
    private int indice;

    public ArregloFecha() {
        this.indice = 0;
        this.FechaA = new Fecha[7];  //de momento 7, ya que una fecha representara un dia de la semana

    }

    public boolean agregarFecha(Fecha fecha) {
        boolean result = false;

        this.FechaA[this.indice] = fecha;
        this.indice++;

        result = true;

        return result;
    }

    @Override
    public String toString() {
        return "ArregloFecha{" + "FechaA=" + Arrays.toString(FechaA) + ", indice=" + indice + '}';
    }
}
