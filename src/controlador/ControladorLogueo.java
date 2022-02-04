package controlador;

import archivos.Archivo;
import datos.Datos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.*;
import vista.JFrameAlumno;
import vista.JFrameLogeo;
import vista.JFrameOperario;
import static archivos.Archivo.*;

/**
 *
 * @author Favio
 */
public class ControladorLogueo {

    JFrameLogeo fIngreso;
    Sistema sistemaAtributo;

    public ControladorLogueo(JFrameLogeo fIngreso, Sistema sistemaParametro) {

        this.fIngreso = fIngreso;

        if (sistemaParametro == null) {//Primera vez que se ingresa a la aplicacion 
            this.sistemaAtributo = Datos.crearSistemaPorDefecto();
            //

        } else {
            this.sistemaAtributo = sistemaParametro;
            //
            Archivo.serializar("Ultimo Sistema", sistemaAtributo);
            //
        }

        /*    this.fIngreso.btnSaliryGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 Archivo.serializar("Ultimo Sistema",sistemaAtributo);
                  JOptionPane.showMessageDialog(fIngreso, "Sistema Guardado con exito", "Sistema", JOptionPane.INFORMATION_MESSAGE);
                 System.exit(0);
            }
       });*/
        this.fIngreso.btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //
                Archivo.serializar("Ultimo Sistema", sistemaAtributo);
                //
                System.exit(0);
            }
        });

        this.fIngreso.btnReiniciarSistema.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sistemaAtributo = Datos.crearSistemaPorDefecto();
                Archivo.serializar("Ultimo Sistema", sistemaAtributo);
                JOptionPane.showMessageDialog(fIngreso, "Sistema Reiniciado", "Sistema", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        this.fIngreso.btnIniciarSesion.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //
                sistemaAtributo = (Sistema) Archivo.deserializar("Ultimo Sistema");
                // 
                if (sistemaAtributo.getAlumnosRegistrados().verificarAlumno(fIngreso.jPasswordFieldContraseña.getText(),
                        fIngreso.TxtFieldCodigo.getText()) == true) {
                    Alumno modelo;
                    modelo = sistemaAtributo.getAlumnosRegistrados().devolverAlumno(fIngreso.TxtFieldCodigo.getText());
                    fIngreso.dispose();
                    JFrameAlumno vistaAlumno = new JFrameAlumno();
                    ControladorVentanaAlumno ventanaAlumno = new ControladorVentanaAlumno(modelo, vistaAlumno, sistemaAtributo);
                    vistaAlumno.setVisible(true);
                    vistaAlumno.setLocationRelativeTo(null);
                } else if (sistemaAtributo.getOperariosRegistrados().verificarOperario(fIngreso.jPasswordFieldContraseña.getText(),
                        fIngreso.TxtFieldCodigo.getText()) ==true){
                    Operario operario;
                    operario = sistemaAtributo.getOperariosRegistrados().devolverOperario(fIngreso.TxtFieldCodigo.getText());
                    sistemaAtributo.setOperarioLogueado(operario);
                    fIngreso.dispose();

                    JFrameOperario vistaOperario = new JFrameOperario();
                    ControladorVentanaOperario ventanaOperario = new ControladorVentanaOperario(vistaOperario, sistemaAtributo);
                    vistaOperario.setVisible(true);
                    vistaOperario.setLocationRelativeTo(null);
                } else {
                    JOptionPane.showMessageDialog(fIngreso, "No se encuentra registrado en el sistema");
                }

            }
        });

        /* this.fIngreso.btnIniciarSesionCargarSiste.addActionListener(new ActionListener() {            
            @Override
            public void actionPerformed(ActionEvent e) {
                
               sistemaAtributo = (Sistema)Archivo.deserializar("Ultimo Sistema");
                JOptionPane.showMessageDialog(fIngreso, "Sistema Cargado con exito", "Sistema", JOptionPane.INFORMATION_MESSAGE);
            }
      });*/
    }

    public void iniciar() {
        this.fIngreso.setLocationRelativeTo(null);
        this.fIngreso.setVisible(true);
    }

}
