/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author Favio
 */
public class ArregloCabeceras  implements Serializable {

    private int indice;
    private CabeceraTicket[] cabeceras;

    public ArregloCabeceras() {
        this.indice = 0;
        this.cabeceras = new CabeceraTicket[Sistema.turnospordia];
    }

    public boolean agregarticketscreadosconfecha(CabeceraTicket ticketscreadosconfecha) {

        //boolean input = false;
        boolean result = false;
        int n = 0;
        for (int i = 0; i < Sistema.turnospordia; i++) {
            n++;
            if (this.cabeceras[i] == null && result == false) {
                this.cabeceras[i] = ticketscreadosconfecha;
                result = true;
                System.out.println("Se ha agregado una cabecera a la lista de cabeceras");

            }

        }
        return result;
    }

    public boolean asignarTicketCabeceras(Alumno alumno) {
        boolean result = false;
        if (this.cabeceras == null) {
            System.out.println("NO HAY TICKETS DISPONIBLES EN EL SISTEMA");

        } else {
            boolean verificar = false;
            for (int i = 0; i < Sistema.turnospordia; i++) {
                if (this.cabeceras[i] != null && verificar == false) {
                    result = this.cabeceras[i].asignarticketalumno(alumno);

                    verificar = true;
                }

            }

        }
        return result;
    }

    public boolean asignarTicketCabecerasManual(Alumno alumno, int nivel, int turno) {
        boolean result = false;
        if (this.cabeceras == null) {
            System.out.println("NO HAY TICKETS DISPONIBLES EN EL SISTEMA");

        } else {
            boolean verificar = false;
            for (int i = 0; i < Sistema.turnospordia; i++) {
                if (this.cabeceras[i] != null && verificar == false) {
                    if (this.cabeceras[i].getNivel().getNumeronivel() == nivel
                            && this.cabeceras[i].getTurno().getNumeroTurno() == turno) {

                        result = this.cabeceras[i].asignarticketalumno(alumno);
                        verificar = true;

                    }
                }
            }
        }
        return result;
    }

    public boolean validaralumnocabeceras(String codigo) {
        boolean result = false;
        for (int i = 0; i < Sistema.turnospordia; i++) {
            if (cabeceras[i] != null) {
                if (cabeceras[i].validarticketcab(codigo) == true) {
                    result = true;
                }
            }
        }
        return result;
    }

    public void validarTodasCabeceras() {

        for (int i = 0; i < Sistema.turnospordia; i++) {
            if (cabeceras[i] != null) {
                cabeceras[i].validarTodosTicketCab();
            }
        }
    }
    
    
    public CabeceraTicket encontrarCabeceraTicket(int nivel, int turno) {

        CabeceraTicket result = null;
        for (int i = 0; i < Sistema.turnospordia; i++) {
            if (cabeceras[i] != null) {
                if (cabeceras[i].getNivel().getNumeronivel() == nivel && cabeceras[i].getTurno().getNumeroTurno() == turno) {
                    System.out.println("Cabecera encontrada");
                    result = cabeceras[i];
                } else {
                    System.out.println("No encontrado");
                }
            }
        }
        return result;
    }

    @Override
    
   /* public String toString() {
        return "ArregloCabeceras{" + "cabeceras=" + Arrays.toString(cabeceras) + '}';
    }*/
    
    /*public String toString() {
        return  Arrays.toString(cabeceras);
    }*/
     public String toString() {
        
        String result="";  //Cadena vacia //Lo que va a hacer es ver si hay elementos con this.indice y si encuenta usuarios va a llamar al toString de cada objeto usuario y este devulve lo que se ve en la linea 87 de la clase Usuario
        for (int i=0; i<Sistema.turnospordia;i++){
            if(this.cabeceras[i]!=null){
                result+="Turno: "+this.cabeceras[i].getTurno().toString()+"  Nivel: "+this.cabeceras[i].getNivel().toString();
                result += this.cabeceras[i] + "\n\n"; 
            }
                
                
        }             

        return result;
    }
}
