package modelo;

import java.io.Serializable;

/**
 *
 * @author Favio
 */
public class EstadoTicket  implements Serializable {

    private String estadoactual;

    public EstadoTicket(String estadoactual) {
        this.estadoactual = estadoactual;
    }

    public String getEstadoactual() {
        return estadoactual;
    }

    public void setEstadoactual(String estadoactual) {
        this.estadoactual = estadoactual;
    }

    @Override
    public String toString() {
        return " "+estadoactual;
    }

}
