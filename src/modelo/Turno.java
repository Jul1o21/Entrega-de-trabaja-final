/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author Favio
 */
public class Turno implements Serializable  {

    private int numeroTurno;
    private String intervaloMinutos;
    private Nivel nivel;
    private Alimento alimento;
            
    public Turno(int numeroTurno, String intervaloMinutos) {
        this.numeroTurno = numeroTurno;
        this.intervaloMinutos = intervaloMinutos;
    }

    public Turno(int numeroturno, String intervalominutos, Nivel nivel) {
        this.numeroTurno = numeroturno;
        this.intervaloMinutos = intervalominutos;
        this.nivel = nivel;
    }

    public Turno(int numeroTurno, String intervaloMinutos, Nivel nivel, Alimento alimento) {
        this.numeroTurno = numeroTurno;
        this.intervaloMinutos = intervaloMinutos;
        this.nivel = nivel;
        this.alimento = alimento;
    }
    
    
    public Turno(int numeroTurno) {
        this.numeroTurno = numeroTurno;
    }
    
    public int getNumeroTurno() {
        return numeroTurno;
    }

    public String getIntervaloMinutos() {
        return intervaloMinutos;
    }

    @Override
    public String toString() {
        return /*"\n►Turno" + "#"+*/  numeroTurno + "  " + intervaloMinutos /*+ " "+ nivel*/;
    }

    
    
    
  
}
