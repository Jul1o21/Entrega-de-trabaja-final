package modelo;

import java.io.Serializable;

/**
 *
 * @author Favio
 */
public class ArregloOperario implements Serializable {
    
     private Operario operarioA[];
     private int indice;
     private int cantOperarios;

    public ArregloOperario(int cantOperarios) {
        
        this.operarioA = new Operario[cantOperarios];
        this.indice = 0;
    }
     
     public boolean agregarOperario(Operario operario) {
        boolean result = false;
        if (verificarRepetidos(operario.getCodigo()) == false) {
            Operario TempOperario[];
            TempOperario = new Operario[this.indice + 1];

            for (int i = 0; i < this.indice; i++) {
                TempOperario[i] = this.operarioA[i];

            }

            this.operarioA= TempOperario;

            this.operarioA[this.indice] = operario;
            this.indice++;
            result = true;

            //System.out.println("Alumno agregado con exito");
        }
        return result;
    }

     
      public boolean verificarRepetidos(String codigo) {
        boolean result = false;

        for (int i = 0; i < this.indice; i++) {
            if (this.operarioA[i].getCodigo().equals(codigo)) {
                result = true;
                System.out.println("El alumno ya se encuentra registrado\n");
                break;
            }
        }

        return result;
    }
     
      
    public boolean verificarOperario(String contrasena, String codigo) { //Esto se usa para verificar si el alumno que intenta logearse ya esta en el sistema
        boolean result = false;
        for (int i = 0; i < this.indice; i++) {
            if (this.operarioA[i].getCodigo().equals(codigo) && this.operarioA[i].getContraseña().equals(contrasena)) {
                result = true;

                break;
            }
        }
        return result;
    }
      
       public Operario devolverOperario(String codigo) {
        Operario result = null;
        for (int i = 0; i < this.indice; i++) {
            if (this.operarioA[i].getCodigo().equalsIgnoreCase(codigo)) {
                result = operarioA[i];
                break;
            }
        }
        return result;
    }   
    
   
      
}
