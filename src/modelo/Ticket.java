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
public class Ticket implements Serializable {

    private Alumno alumno;
    private int numeroticket;
    private int almuerzosdisp;
    private EstadoTicket estado;

    //
    public Ticket(Alumno alumno, int numeroticket, int stockalmuerzo, EstadoTicket estado) {
        this.alumno = alumno;
        this.numeroticket = numeroticket;
        this.almuerzosdisp = stockalmuerzo;
        this.estado = estado;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public int getNumeroticket() {
        return numeroticket;
    }

    public int getStockalmuerzo() {
        return almuerzosdisp;
    }

    public EstadoTicket getEstado() {
        return estado;
    }

    public void setEstado(EstadoTicket estado) {
        this.estado = estado;
    }

    @Override
    /*public String toString() {
        return "\n" + "\n---------------------------------------------------------\n"
                + "\n" + "Ticket{" + "\n"
                + "alumno=" + alumno + "\n"
                + ", numeroticket=" + numeroticket + "\n"
                + ", stockalmuerzo=" + almuerzosdisp + "\n"
                + ", estado=" + estado + "\n"
                + '}';
    }*/
    
    public String toString() {
        return "\n------------------------------------------------------------------------------------------------------------------\n"
                
                + "Alumno: " + alumno + "\n"
                + "#Ticket: " + numeroticket + "\t"
                + "Stock Almuerzo: " + almuerzosdisp + "\t"
                + "Estado: " + estado + "\n";
           
    }

}
