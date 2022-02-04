
package controlador;

import controlador.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Alumno;
import modelo.Sistema;
import vista.JFrameAlumno;
import vista.JFrameCambiarContraseña;
import vista.JFrameLogeo;
import vista.JFrameSistema;
import vista.JFrameSolicitarContraseña;

/**
 *
 * @author Favio
 */
public class ControladorVentanaAlumno {
    
        private Alumno alumnoAt;
        private JFrameAlumno vista;
        private Sistema sistema;

    public ControladorVentanaAlumno(Alumno alumnoP, JFrameAlumno vista, Sistema sistema) {
        this.alumnoAt = alumnoP;
        this.vista = vista;
        this.sistema = sistema;
        
        this.vista.jLabelAlumno.setText(alumnoAt.getNombres());
        
        this.vista.jButtonSolicitarContraseña.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
               vista.dispose();
               JFrameSolicitarContraseña vistaSolContraseña = new JFrameSolicitarContraseña();
               ControladorSolicitarContraseña contrSolContraseña = new ControladorSolicitarContraseña(alumnoAt,vistaSolContraseña,sistema);
               vistaSolContraseña.setVisible(true);
               vistaSolContraseña.setLocationRelativeTo(null);
            }
        });
    
        this.vista.jButtonAccederAlSistemaalum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                   vista.dispose();
                   JFrameSistema vistaSistema = new JFrameSistema();
                   ControladorSistema contrSistema = new ControladorSistema(vistaSistema,sistema, alumnoAt);
                   vistaSistema.setVisible(true);
                   vistaSistema.setLocationRelativeTo(null);
                   
            }
        });
        
        this.vista.jButtonSalirAlumno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                   vista.dispose();
                   JFrameLogeo vistaLogueo = new JFrameLogeo();
                    ControladorLogueo contLogueo = new ControladorLogueo(vistaLogueo,sistema);
                    vistaLogueo.setVisible(true);
                    vistaLogueo.setLocationRelativeTo(null);
                    
            }
        });
        
        this.vista.jButtonCambiarContraseña.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  vista.dispose();
                  JFrameCambiarContraseña vistaCc = new JFrameCambiarContraseña();
                  ControladorCambiarContraseña contrCC = new ControladorCambiarContraseña(vistaCc, sistema, alumnoAt);
                  vistaCc.setLocationRelativeTo(null);
                  vistaCc.setVisible(true);
            }
        });
        
    }
   private void reabrir(){
       JFrameSolicitarContraseña contraseña = new JFrameSolicitarContraseña();
      
   }
    public void iniciarAlumno(){
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
    }    
}
