package modelo;
import interfaces.IColecciones;
import java.io.Serializable;

/**
 *
 * @author Favio
 */
public class TipoFacultadArreglo implements IColecciones, Serializable  {
    
    private int indice, tamanio;
    private Facultad[] tipoEscuelas ;
    private final String[] cabecera =  {"NOMBRE"};

 
    public TipoFacultadArreglo(){
        this.indice = 0;
        this.tamanio = 20;
        this.tipoEscuelas = new Facultad[this.tamanio];
        
        this.add(new Facultad("Sistemas"));      
        this.add(new Facultad("Contabilidad"));    
        this.add(new Facultad("Derecho"));
        this.add(new Facultad("Quimica"));
        this.add(new Facultad("Matematica"));
        this.add(new Facultad("Geografia"));
    }

    @Override
    public boolean add(Object tipofacultad) {
      
        boolean resultado = false;
        if(!isLleno()){
            this.tipoEscuelas[this.indice]= (Facultad)tipofacultad;
            this.indice++;
            resultado = true;
        }
        return resultado;
    }

    @Override
    public int find(String nombre) {
        int resultado = -1 ;
         for(int indice=0; indice < this.indice; indice++){
             System.out.println(this.tipoEscuelas[indice].getNombrefacultad());
            if(this.tipoEscuelas[indice].getNombrefacultad().equalsIgnoreCase(nombre)){
                resultado = indice;
                break;
            }
        }
        return resultado;
    }

    @Override
    public Object[][] getDatos() {
         Object resultado[][]= null;
         return resultado;
    }

      public Object[] getDatosCombo() {
        Object resultado[] = null;
        if(!isVacio()){
            resultado = new Object[this.indice];
            for(int indice=0; indice < this.indice; indice++){
                resultado[indice] = this.tipoEscuelas[indice];
            }
        }
        return resultado;
    }
    
    
    @Override
    public boolean update(Object elemento) {
        boolean resultado = false;
        int encontrado = this.find(((Facultad)elemento).getNombrefacultad());
        if(encontrado>= 0){
            this.tipoEscuelas[encontrado].setNombrefacultad(((Facultad)elemento).getNombrefacultad());
            resultado = true;
        }
        return resultado; 
    }

    @Override
    public boolean remove(String id) {
        
        boolean resultado = false;
        int encontrado = this.find(id);
        if( encontrado >= 0 ) {
            moverElementos(encontrado);
            resultado = true;
        }
        return resultado;
    }

    @Override
    public String[] getCabecera() {
        return this.cabecera;
    }


    @Override
    public boolean isLleno() {
      boolean resultado = false;
        if (this.indice == this.tamanio){
            aumentarTamanho();
        }
        return resultado;
    }

    @Override
    public void aumentarTamanho() {
        int tamanio = this.tamanio*2;
        Facultad[] nuevoArreglo = new  Facultad[tamanio];
        for (int i = 0; i < this.indice; i++){
            nuevoArreglo[i] = this.tipoEscuelas[i];
        }
        this.tipoEscuelas = nuevoArreglo;
    }

    @Override
    public void moverElementos(int posicion) {
        this.indice--;
        for(;posicion<indice ;posicion++){
            this.tipoEscuelas[posicion] = this.tipoEscuelas[posicion+1];
        }
        this.tipoEscuelas[indice]= null;
    }

    @Override
    public boolean isVacio() {
       return this.indice ==0;
    }
    
}
