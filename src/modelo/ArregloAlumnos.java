package modelo;

import interfaces.IColecciones;
import java.io.Serializable;
import java.util.Arrays;

/**
 *
 * @author Favio
 */
public class ArregloAlumnos implements IColecciones, Serializable  {

    private Alumno AlumnoA[];
    private int indice;
    private final String[] cabecera = {"Codigo", "Nombre(s)", "Apellidos", "DNI", "Correo", "Facultad"};

    public ArregloAlumnos(int cantidadAlumnos) {

        this.indice = 0;
        this.AlumnoA = new Alumno[cantidadAlumnos];
    }

    public Alumno[] getAlumnoA() {
        return AlumnoA;
    }

    public int getIndice() {
        return indice;
    }

    public boolean agregarAlumno(Alumno alumno) {
        boolean result = false;
        if (verificarRepetidos(alumno.getCodigo()) == false) {
            Alumno TempAlumnos[];
            TempAlumnos = new Alumno[this.indice + 1];

            for (int i = 0; i < this.indice; i++) {
                TempAlumnos[i] = this.AlumnoA[i];

            }

            this.AlumnoA = TempAlumnos;

            this.AlumnoA[this.indice] = alumno;
            this.indice++;
            result = true;

            //System.out.println("Alumno agregado con exito");
        }
        return result;
    }

    public boolean verificarAlumno(String contrasena, String codigo) { //Esto se usa para verificar si el alumno que intenta logearse ya esta en el sistema
        boolean result = false;
        for (int i = 0; i < this.indice; i++) {
            if (this.AlumnoA[i].getCodigo().equals(codigo) && this.AlumnoA[i].getContraseña().equals(contrasena)) {
                result = true;

                break;
            }
        }
        return result;
    }

    public boolean verificarAlumnoYCambiar(String contrasena, String codigo,
            String codigoNuevo, String nombre, String apellido, String correo, int DNI, Facultad facu) { //Esto se usa para verificar si el alumno que intenta logearse ya esta en el sistema
        boolean result = false;
        for (int i = 0; i < this.indice; i++) {
            if (this.AlumnoA[i].getCodigo().equals(codigo) && this.AlumnoA[i].getContraseña().equals(contrasena)) {
                result = true;

                this.AlumnoA[i].setCodigo(codigoNuevo);
                this.AlumnoA[i].setNombres(nombre);
                this.AlumnoA[i].setApellidos(apellido);
                this.AlumnoA[i].setCorreo(correo);
                this.AlumnoA[i].setDNI(DNI);
                this.AlumnoA[i].setFacultad(facu);
                break;
            }
        }
        return result;
    }

    public Alumno devolverAlumno(String codigo) {
        Alumno result = null;
        for (int i = 0; i < this.indice; i++) {
            if (this.AlumnoA[i].getCodigo().equalsIgnoreCase(codigo)) {
                result = AlumnoA[i];
                break;
            }
        }
        return result;
    }

    public boolean verificarRepetidos(String codigo) {
        boolean result = false;

        for (int i = 0; i < this.indice; i++) {
            if (this.AlumnoA[i].getCodigo().equals(codigo)) {
                result = true;
                System.out.println("El alumno ya se encuentra registrado\n");
                break;
            }
        }

        return result;
    }

    public void ordenarPorPaterno() {

        Alumno aux;

        for (int i = 0; i < this.indice - 1; i++) {
            for (int j = 0; j < this.indice - 1; j++) {
                if (AlumnoA[j].getApellidos().compareToIgnoreCase(AlumnoA[j + 1].getApellidos()) > 0) {
                    aux = AlumnoA[j];
                    AlumnoA[j] = AlumnoA[j + 1];
                    AlumnoA[j + 1] = aux;
                }
            }
        }
    }

    public void ordenarPorPrimerNombre() {

        Alumno aux;

        for (int i = 0; i < this.indice - 1; i++) {
            for (int j = 0; j < this.indice - 1; j++) {
                if (AlumnoA[j].getNombres().compareToIgnoreCase(AlumnoA[j + 1].getNombres()) > 0) {
                    aux = AlumnoA[j];
                    AlumnoA[j] = AlumnoA[j + 1];
                    AlumnoA[j + 1] = aux;
                }
            }
        }
    }

    public void ordenarPorCodigo() {

        Alumno aux;

        for (int i = 0; i < this.indice - 1; i++) {
            for (int j = 0; j < this.indice - 1; j++) {
                if (Integer.parseInt(AlumnoA[j].getCodigo()) > Integer.parseInt(AlumnoA[j + 1].getCodigo())) {
                    aux = AlumnoA[j];
                    AlumnoA[j] = AlumnoA[j + 1];
                    AlumnoA[j + 1] = aux;
                }
            }
        }

    }

    @Override
    public boolean add(Object elemento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int find(String codigo) {
        int resultado = -1;
        for (int indice = 0; indice < this.indice; indice++) {
            if (this.AlumnoA[indice].getCodigo().equalsIgnoreCase(codigo)) {
                resultado = indice;
                break;
            }
        }
        return resultado;
    }

    @Override
    public Object[][] getDatos() {

        Object resultado[][] = new Object[this.indice][6];
        if (!isVacio()) {
            for (int indice = 0; indice < this.indice; indice++) {
                if (this.AlumnoA[indice] == null) {
                    resultado[indice][0] = this.AlumnoA[indice];
                } else {
                    resultado[indice][0] = this.AlumnoA[indice].getCodigo();
                }
                resultado[indice][1] = this.AlumnoA[indice].getNombres();
                resultado[indice][2] = this.AlumnoA[indice].getApellidos();
                resultado[indice][3] = this.AlumnoA[indice].getDNI();
                resultado[indice][4] = this.AlumnoA[indice].getCorreo();
                resultado[indice][5] = this.AlumnoA[indice].getFacultad().getNombrefacultad();

            }
        }
        return resultado;

    }

    @Override
    public boolean update(Object elemento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remove(String codigo) {
        boolean resultado = false;
        int encontrado = this.find(codigo);
        if (encontrado >= 0) {
            moverElementos(encontrado);
            resultado = true;
        }
        return resultado;
    }

    @Override
    public String[] getCabecera() {
        return cabecera;
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
        this.indice--;
        for (; posicion < indice; posicion++) {
            this.AlumnoA[posicion] = this.AlumnoA[posicion + 1];
        }
        this.AlumnoA[indice] = null;
    }

    @Override
    public boolean isVacio() {
        return this.indice == 0;
    }

    @Override
    public String toString() {
        
        String result="Codigo\t\tNombre(s)\tApellidos\t\t\tDNI\t\tCorreo\t\t\tFacultad\n";  //Cadena vacia //Lo que va a hacer es ver si hay elementos con this.indice y si encuenta usuarios va a llamar al toString de cada objeto usuario y este devulve lo que se ve en la linea 87 de la clase Usuario
        for (int i=0; i<this.indice;i++){ //Recorrido de cada uno de los obejtos dentro del arreglo 
                result += this.AlumnoA[i] + "\n"; //Acumalara en result  la información de lo que tenga en el arreglo this.arregloU
                
        }             

        return result;
    }
   
}
