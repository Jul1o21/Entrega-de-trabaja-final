package archivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;


public class Archivo {
    
       public static void crearArchivo(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(archivo);
            salida.close();
            System.out.println("Se ha creado el archivo");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void escribirArchivo(String nombreArchivo, String contenido) {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(archivo);
            salida.println(contenido);
            salida.close();
            System.out.println("Se ha escrito al archivo");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void anexarArchivo(String nombreArchivo, String contenido) {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, true));
            salida.println(contenido);
            salida.close();
            System.out.println("Se ha anexado informacion al archivo");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void leerArchivo(String nombreArchivo) {
        var archivo = new File(nombreArchivo);
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            var lectura = entrada.readLine();
            while(lectura != null){
                System.out.println("lectura = " + lectura);
                lectura = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
 
    public static void serializar ( String sNombreArchivo, 
                                ArrayList  arreglo) {
        try {
            ObjectOutputStream escritor = 
              new  ObjectOutputStream (
                      new FileOutputStream (sNombreArchivo));
            escritor.writeObject(arreglo);
            escritor.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void serializar ( String sNombreArchivo, 
                                Object  arreglo) {
        try {
            ObjectOutputStream escritor = 
              new  ObjectOutputStream (
                      new FileOutputStream (sNombreArchivo));
            escritor.writeObject(arreglo);
            escritor.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static Object deserializar (String sNombreArchivo) {
        Object  arreglo;// = new ArrayList ();
         try{
            ObjectInputStream lector = 
                new ObjectInputStream(
                        new FileInputStream(sNombreArchivo)); 
            arreglo = (Object)lector.readObject();
        
        } catch ( FileNotFoundException e){
            throw new RuntimeException(e);
        } catch (IOException e){
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return arreglo;    
    
    }
}

