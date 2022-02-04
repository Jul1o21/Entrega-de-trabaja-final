package modelo;

import java.io.Serializable;

/**
 *
 * @author Favio
 */
public class Alumno extends Usuario  implements Serializable {

    private int DNI;
    private String correo;
    private Facultad facultad;
    private boolean haveticketSolicitud;
    private boolean canjeoTicket;

    public Alumno(int DNI, String correo, String contrasena, String nombres, String apellidos, String codigo, Facultad facultad) {

        super(contrasena, nombres, apellidos, codigo);
        this.DNI = DNI;
        this.correo = correo;
        this.facultad = facultad;
        this.haveticketSolicitud = false;
        this.canjeoTicket = false;

    }

    public Alumno(String contrasena, String codigo) {
        super(contrasena, codigo);
    }

    public void solicitarContraseña() {
        System.out.println("--------------------------------------------");
        System.out.println("Su contraseña es : " + getContraseña());
        System.out.println("--------------------------------------------");
    }

    public void cambiarContraseña(String nuevaContraseña) {
        this.contrasena = nuevaContraseña;
    }

    public Facultad getFacultad() {
        return facultad;
    }

    public int getDNI() {
        return DNI;
    }

    public String getCorreo() {
        return correo;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    
    
    
    public void setHaveticket(boolean haveticketSolicitud) {
        this.haveticketSolicitud = haveticketSolicitud;
    }

    public boolean isHaveticketSolicitado() {
        return haveticketSolicitud;
    }

    public boolean isHaveticketSolicitud() {
        return haveticketSolicitud;
    }

    public void setHaveticketSolicitud(boolean haveticketSolicitud) {
        this.haveticketSolicitud = haveticketSolicitud;
    }

    public boolean isCanjeoTicket() {
        return canjeoTicket;
    }

    public void setCanjeoTicket(boolean canjeoTicket) {
        this.canjeoTicket = canjeoTicket;
    }
    
    

    
    @Override
   /* public String toString() {
        return "Alumno{" + "\n" + "DNI=" + DNI + "\n"
                + "correo=" + correo + "\n"
                + //        "contraseña="+ this.getContraseña()+ "\n"+ 
                "codigo=" + this.getCodigo() + "\n"
                + "apellidos=" + this.getApellidos() + "\n"
                + "nombres=" + this.getNobmres() + "\n"
                + "-------------------------------------------------" + "\n"
                + '}';
    }*/
    
    public String toString() {   //Esto imprimar los datos 
        return this.getCodigo() + "\t\t" + 
                this.getNombres() + "\t\t" + 
                this.getApellidos() + "\t\t" + 
                this.DNI + "\t\t"+
                this.correo + "\t\t" + 
                this.facultad;
    }

}
