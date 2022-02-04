
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Alumno;
import modelo.Sistema;
import vista.JFrameMostrarTurnos;
import vista.JFrameSistema;

/**
 *
 * @author Favio
 */
public class ControladorMostrarTurnos {
    
    JFrameMostrarTurnos vistaMT ;
    Sistema sistema;
    Alumno alumno;

    public ControladorMostrarTurnos(JFrameMostrarTurnos vistaMT, Sistema sistema, Alumno alumno) {
        this.vistaMT = vistaMT;
        this.sistema = sistema;
        this.alumno = alumno;
        
        bloquearFields();
        
        this.vistaMT.btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               vistaMT.dispose();
               JFrameSistema vistaSis = new JFrameSistema();
               ControladorSistema contrlSis = new ControladorSistema(vistaSis, sistema, alumno);
               vistaSis.setLocationRelativeTo(null);
               vistaSis.setVisible(true);
            }
        });
        
        
    }
    
    public void bloquearFields(){
        
        vistaMT.jTextField1.setEditable(false);
        vistaMT.jTextField2.setEditable(false);
        vistaMT.jTextField3.setEditable(false);
        vistaMT.jTextField4.setEditable(false);
        vistaMT.jTextField5.setEditable(false);
        vistaMT.jTextField6.setEditable(false);
        vistaMT.jTextField7.setEditable(false);
        vistaMT.jTextField8.setEditable(false);
    }
    
}
