package modelo;

import java.io.Serializable;
import java.util.Arrays;

/**
 *
 * @author Favio
 */
public class ArregloTurno  implements Serializable {

    private Turno TurnoA[];
    private int indice;

    public ArregloTurno() {
        this.indice = 0;
        this.TurnoA = new Turno[8]; //De momento lo coloco como 4, considerandolo diario (4 turnos por dia o por nivel)

    }
    
   
    public boolean agregarTurno(Turno turno) {
        boolean result = false;

        Turno TempTurnos[];
        TempTurnos = new Turno[this.indice + 1];

        for (int i = 0; i < this.indice; i++) {
            TempTurnos[i] = this.TurnoA[i];

        }
        this.TurnoA = TempTurnos;
        this.TurnoA[this.indice] = turno;
        this.indice++;
        result = true;
        System.out.println("Turno agregado con exito");
        return result;
    }

    public Turno[] getTurnoA() {
        return TurnoA;
    }

    public int getIndice() {
        return indice;
    }

    @Override
    public String toString() {
        return "ArregloTurno{" + "TurnoA=" + Arrays.toString(TurnoA) + " } "  ;
    }
}
