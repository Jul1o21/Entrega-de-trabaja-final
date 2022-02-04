package datos;

import java.util.Date;
import modelo.*;


/**
 *
 * @author Favio
 */
public class Datos {
   
   public static String  version = "    🍗        1.0       🍗   ";
   public static TipoFacultadArreglo arreglotipofacultad  = new TipoFacultadArreglo();
 
    
   public static Sistema  crearSistemaPorDefecto(){
     
                Sistema sistemaP;
                Date fechaEntrada = new Date();
                ArregloFecha fechaObjeto = new ArregloFecha();
                ArregloTurno arregloTurno = new ArregloTurno();
                ArregloAlumnos alumnosSistema = new ArregloAlumnos(10);
                ArregloOperario operariosSistema = new ArregloOperario(5);
                Operario operarioAdd;
                Alumno alumnoAdd;
                Facultad facu;
                
                facu=new Facultad("Sistemas");
                
                alumnoAdd = new Alumno(70101, "pepe@gmail.com","23","Pepe","Grillo Chavez","23",facu);
                alumnosSistema.agregarAlumno(alumnoAdd);
                alumnoAdd = new Alumno(70102,"jorge@gmail.com","21","Jorge","Perez Lopez","21",facu);
                alumnosSistema.agregarAlumno(alumnoAdd);
                alumnoAdd = new Alumno(70103,"javier@gmail.com","24","Javier","Pevez Jara","24",facu);
                alumnosSistema.agregarAlumno(alumnoAdd);
                alumnoAdd = new Alumno(70104,"luz@gmail.com","22","Luz","Velez Ramirez","22",new Facultad("Derecho"));
                alumnosSistema.agregarAlumno(alumnoAdd);
                alumnoAdd = new Alumno(70105,"correo25@gmail.com","25","Nombres25","Apellidos25","25",new Facultad("Derecho"));
                alumnosSistema.agregarAlumno(alumnoAdd);
                alumnoAdd = new Alumno(70106,"correo26@gmail.com","27","Nombres26","Apellidos26","26",new Facultad("Derecho"));
                alumnosSistema.agregarAlumno(alumnoAdd);
                alumnoAdd = new Alumno(70107,"correo27@gmail.com","27","Nombres27","Apellidos27","27",new Facultad("Quimica"));
                alumnosSistema.agregarAlumno(alumnoAdd);
                alumnoAdd = new Alumno(70108,"correo28@gmail.com","28","Nombres28","Apellidos28","28",new Facultad("Quimica"));
                alumnosSistema.agregarAlumno(alumnoAdd);
                alumnoAdd = new Alumno(70109,"correo29@gmail.com","29","Nombres29","Apellidos29","29",new Facultad("Quimica"));
                alumnosSistema.agregarAlumno(alumnoAdd);
                alumnoAdd = new Alumno(70110,"correo30@gmail.com","30","Nombres30","Apellidos30","30",new Facultad("Quimica"));
                alumnosSistema.agregarAlumno(alumnoAdd);
                
                //Operarios 
                
                operarioAdd = new Operario(fechaEntrada,746514,"c","Joel","Lara Rosales","c");
                operariosSistema.agregarOperario(operarioAdd);
                operarioAdd = new Operario(fechaEntrada,744134,"jzr","Jorge","Zavala Rojas","jzr");
                operariosSistema.agregarOperario(operarioAdd);
                operarioAdd = new Operario(fechaEntrada,734565,"cñc","Carmen","Ñanez Cortez","cñc");
                operariosSistema.agregarOperario(operarioAdd);
                operarioAdd = new Operario(fechaEntrada,739994,"lpc","Luis","Perez Castillo","lpc");
                operariosSistema.agregarOperario(operarioAdd);
                operarioAdd = new Operario(fechaEntrada,841133,"dlh","David","Luca huaman","dlh");
                operariosSistema.agregarOperario(operarioAdd);
               
                sistemaP = new Sistema(true, fechaObjeto, arregloTurno, alumnosSistema, operariosSistema);
                sistemaP.setAlumnoRegistrados(alumnosSistema);
                //sistemaP.setOperario(operarioUnico);
                return sistemaP;
   }
   
   
   
   
  
}
