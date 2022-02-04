package modelo;

import java.io.Serializable;
import javax.swing.JOptionPane;


/**
 *
 * @author Favio
 */
public class Sistema implements Serializable {

    private boolean estadohabilitado;
    public static int racionestotalesporturno = 20;
    public static int turnospordia = 8;
    public static int intervaloinferior = 0;//Hora minima
    public static int intervalosuperior = 24;//Hora maxima
    private ArregloFecha fechasSistema;
    private ArregloTurno turnosSistema;
    private ArregloAlumnos alumnosRegistrados;
    private ArregloOperario operariosRegistrados;
    private ArregloCabeceras cabecerascreadasconfecha;
    private Operario operario;
    private int indice;

    public Sistema() {
    }
    

    public Sistema(boolean estadohabilitado, ArregloFecha fechasSistema, ArregloTurno turnosSistema, 
            ArregloAlumnos alumnosRegistrados ,ArregloOperario operarioRegistrados) {
        this.indice = 0;
        this.estadohabilitado = estadohabilitado;
        this.fechasSistema = fechasSistema;
        this.turnosSistema = turnosSistema;
        this.alumnosRegistrados = alumnosRegistrados;
        this.operariosRegistrados = operarioRegistrados;
        this.cabecerascreadasconfecha = new ArregloCabeceras();

    }

    public void setTicketscreadosconfecha(CabeceraTicket ticketscreadosconfecha) {
        if(this.cabecerascreadasconfecha.agregarticketscreadosconfecha(ticketscreadosconfecha)==false){
            
         JOptionPane.showMessageDialog(null,"No se pueden crear mas de 8 cabeceras","Error",JOptionPane.ERROR_MESSAGE);
                           
        }   
    }

       
    public ArregloFecha getFechasSistema() {
        return fechasSistema;
    }

    public ArregloTurno getTurnosSistema() {
        return turnosSistema;
    }
   
    public ArregloAlumnos getAlumnosRegistrados() {
        return alumnosRegistrados;
    }
    public ArregloOperario getOperariosRegistrados(){
        return operariosRegistrados;
    }

    public static int getRacionestotalesporturno() {
        return racionestotalesporturno;
    }

    public ArregloCabeceras getTicketscreadosconfecha() {
        return cabecerascreadasconfecha;
    }

    public boolean asignarTicket(Alumno alumno) {
        boolean result=false;
        if (this.cabecerascreadasconfecha.asignarTicketCabeceras(alumno) == true) {
            System.out.println("Se le asigno correctamente un ticket al alumno");
            result = true;
        } else {
            System.out.println("No se le pudo asignar un ticket al alumno");
        }
        return result;

    }
      public boolean asignarTicketManual(Alumno alumno,int nivel,int turno) {
          boolean result = false;
        if (this.cabecerascreadasconfecha.asignarTicketCabecerasManual(alumno,nivel,turno) == true) {
            System.out.println("Se le asigno correctamente un ticket al alumno");
               result = true;
        } else {
            System.out.println("No se le pudo asignar un ticket al alumno");
            result = false;
        }
        return result;
    }
    
    
    
      public  void setOperarioLogueado(Operario operario){
      this.operario = operario;
   }

    public Operario getOperario() {
        return operario;
    }
      
      
        public  void setAlumnoRegistrados(ArregloAlumnos alumnosRegistrados){
             this.alumnosRegistrados = alumnosRegistrados; 
   }

    public void setTurnosSistema(ArregloTurno turnosSistema) {
        this.turnosSistema = turnosSistema;
    }

    public void setEstadohabilitado(boolean estadohabilitado) {
        this.estadohabilitado = estadohabilitado;
    }

    public static void setRacionestotalesporturno(int racionestotalesporturno) {
        Sistema.racionestotalesporturno = racionestotalesporturno;
    }

    public boolean validarlogdeoperario(String codigoop, String contrasenaop) {
        boolean result = false;
        if (this.operario.getCodigo().equals(codigoop) && this.operario.getContraseña().equals(contrasenaop)) {
            result = true;

        }

        return result;
    }

    public void crearturnospordefect() {
        ArregloTurno turnos;
        Turno turnotemp;
        turnos = new ArregloTurno();
        turnotemp = new Turno(1, "12:00-12:30", new Nivel(1));
        turnos.agregarTurno(turnotemp);
        turnotemp = new Turno(2, "12:30-13:00", new Nivel(1));
        turnos.agregarTurno(turnotemp);
        turnotemp = new Turno(3, "13:00-13:30", new Nivel(1));
        turnos.agregarTurno(turnotemp);
        turnotemp = new Turno(4, "13:30-14:00", new Nivel(1));
        turnos.agregarTurno(turnotemp);
        turnotemp = new Turno(1, "12:00-12:30", new Nivel(2));
        turnos.agregarTurno(turnotemp);
        turnotemp = new Turno(2, "12:30-13:00", new Nivel(2));
        turnos.agregarTurno(turnotemp);
        turnotemp = new Turno(3, "13:00-13:30", new Nivel(2));
        turnos.agregarTurno(turnotemp);
        turnotemp = new Turno(4, "13:30-14:00", new Nivel(2));
        turnos.agregarTurno(turnotemp);
        
        setTurnosSistema(turnos);
        
    }
}
