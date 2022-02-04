/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import interfaces.IColecciones;
import java.io.Serializable;
import java.util.Arrays;

/**
 *
 * @author Favio
 */
public class CabeceraTicket implements IColecciones, Serializable  {

    private Ticket TicketA[];
    private Nivel nivel;
    private Turno turno;
    private Alimento alimento;
    private Fecha fecha;
    private int canttickets;
    private final String[] cabecera = {"Alumno", "#Ticket", "Stock", "Estado"};
    private final String[] cabecera2 = {"Codigo", "#Ticket", "Estado", "Almuerzo"};

    public CabeceraTicket(int canttickets, Nivel nivel, Turno turno, Alimento alimento, Fecha fecha) {
        this.canttickets = 0;
        this.TicketA = new Ticket[canttickets];

        for (int i = 0; i < canttickets; i++) {
            Ticket tickettemp;
            EstadoTicket estadotictemp;
            estadotictemp = new EstadoTicket("Disponible");
            tickettemp = new Ticket(null, this.canttickets + 1, Sistema.racionestotalesporturno - this.canttickets - 1, estadotictemp);
            this.TicketA[i] = tickettemp;
            this.canttickets++;

        }

        this.nivel = nivel;
        this.turno = turno;
        this.alimento = alimento;
        this.fecha = fecha;
    }

    public Ticket[] getTicketA() {
        return TicketA;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public Turno getTurno() {
        return turno;
    }

    public boolean asignarticketalumno(Alumno alumno) {
        boolean result = false;
        boolean ticketasignado = false;
        //this.TicketA[3].setAlumno(alumno);

        for (int i = 0; i < TicketA.length; i++) {
            if (this.TicketA[i].getAlumno() == null && ticketasignado == false) {
                this.TicketA[i].setAlumno(alumno);
                if (this.TicketA[i].getAlumno().isHaveticketSolicitado() == true) {
                    this.TicketA[i].setAlumno(null);
                } else {
                    this.TicketA[i].getAlumno().setHaveticket(true);
                    ticketasignado = true;
                    EstadoTicket estadoalum;
                    estadoalum = new EstadoTicket("Reservado");
                    this.TicketA[i].setEstado(estadoalum);
                    result = true;
                    System.out.println("El alimento del turno asignado es " + getAlimento());
                }
            }
        }
        return result;
    }

    public boolean validarticketcab(String codigo) {
        boolean result = false;
        for (int i = 0; i < this.canttickets; i++) {
            if (this.TicketA[i].getAlumno() != null) {
                if (this.TicketA[i].getAlumno().isCanjeoTicket() == false && this.TicketA[i].getAlumno().getCodigo().equals(codigo) == true) {//Verifica y valida el ticket
                    EstadoTicket estadoval;
                    estadoval = new EstadoTicket("Validado");
                    this.TicketA[i].setEstado(estadoval);
                    this.TicketA[i].getAlumno().setCanjeoTicket(true);
                    result = true;
                }
            }
        }

        return result;
    }

    public boolean validarTodosTicketCab() {
        boolean result = false;
        for (int i = 0; i < this.canttickets; i++) {
            if (this.TicketA[i].getAlumno() != null) {
                EstadoTicket estadoval;
                estadoval = new EstadoTicket("Validado");
                this.TicketA[i].setEstado(estadoval);
                result = true;
            }
        }

        return result;
    }

    public Alimento getAlimento() {
        return alimento;
    }

    public Fecha getFecha() {
        return fecha;
    }

    @Override
    public boolean add(Object elemento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int find(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[][] getDatos() {
        Object resultado[][] = new Object[this.canttickets][4];
        if (!isVacio()) {
            for (int indice = 0; indice < this.canttickets; indice++) {
                if (this.TicketA[indice].getAlumno() == null) {
                    resultado[indice][0] = this.TicketA[indice].getAlumno();
                } else {
                    resultado[indice][0] = this.TicketA[indice].getAlumno().getCodigo();
                }
                resultado[indice][1] = this.TicketA[indice].getNumeroticket();
                resultado[indice][2] = this.TicketA[indice].getStockalmuerzo();
                resultado[indice][3] = this.TicketA[indice].getEstado();

            }
        }
        return resultado;
    }

    public Object[][] getDatos2() {
        Object resultado[][] = new Object[this.canttickets][4];

        if (!isVacio()) {
            for (int indice = 0; indice < this.canttickets; indice++) {
                if (this.TicketA[indice].getAlumno() == null) {
                    resultado[indice][0] = this.TicketA[indice].getAlumno();
                } else {
                    resultado[indice][0] = this.TicketA[indice].getAlumno().getCodigo();
                }
                resultado[indice][1] = this.TicketA[indice].getNumeroticket();
                resultado[indice][2] = this.TicketA[indice].getEstado();
                resultado[indice][3] = getAlimento();

            }
        }
        return resultado;
    }

    @Override
    public boolean update(Object elemento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remove(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[] getCabecera() {
        return cabecera;
    }

    public String[] getCabecera2() {
        return cabecera2;
    }


    @Override
    public boolean isLleno() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void aumentarTamanho() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void moverElementos(int posicion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isVacio() {
        return this.canttickets == 0;
    }

    @Override
    /* public String toString() {
        return "\tArreglo de Tickets" + "\n" + "TicketA=" + "\n" + Arrays.toString(TicketA) + "\n"
                + "------------------------------------------------------------------------------------" + "\n"
                + "nivel=" + nivel + "\n"
                + "turno=" + turno + "\n"
                + "alimento=" + alimento + "\n"
                + "fecha=" + fecha + "\n"
                + "----------------------------------------------------------------------------------" + "\n";
    }*/
    public String toString() {
        String result = " ";

        for (int i = 0; i < this.canttickets; i++) {
            if (this.TicketA[i] != null) {
                result += this.TicketA[i] + "\n";
            }

        }

        return result;
    }
    
}
