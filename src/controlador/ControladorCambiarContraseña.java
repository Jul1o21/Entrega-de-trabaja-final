
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Alumno;
import modelo.Sistema;
import vista.JFrameAlumno;
import vista.JFrameCambiarContraseña;

/**
 *
 * @author Favio
 */
public class ControladorCambiarContraseña {
    
    JFrameCambiarContraseña vistaCC ;
    Sistema sistema;
    Alumno alumno;
   
     
    public ControladorCambiarContraseña(JFrameCambiarContraseña vistaCC, Sistema sistema, Alumno alumno) {
        this.vistaCC = vistaCC;
        this.sistema = sistema;
        this.alumno = alumno;
       
      mostrarDatos(); 
        
        this.vistaCC.btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               vistaCC.dispose();
               JFrameAlumno vistaAl = new JFrameAlumno();
               ControladorVentanaAlumno contrAl = new ControladorVentanaAlumno(alumno, vistaAl, sistema);
               vistaAl.setLocationRelativeTo(null);
               vistaAl.setVisible(true);
            }
        });
        
        this.vistaCC.btnCambiarContraseña.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alumno.cambiarContraseña(vistaCC.txtFieldNewContraseña.getText());
                JOptionPane.showMessageDialog(vistaCC, "Contraseña Cambiada con exito");
            }
        });  
        
    }  
    
    private void mostrarDatos(){         
        
         this.vistaCC.txtFieldNombre.setText(alumno.getNombres());
         this.vistaCC.txtFieldApellidos.setText(alumno.getApellidos());
         this.vistaCC.txtFieldCodigo.setText(alumno.getCodigo());
         this.vistaCC.txtFieldDNI.setText(String.valueOf(alumno.getDNI()));
         this.vistaCC.txtFieldCActual.setText(alumno.getContraseña());
         this.vistaCC.txtFieldNombre.setEditable(false);
         this.vistaCC.txtFieldApellidos.setEditable(false);
         this.vistaCC.txtFieldCodigo.setEditable(false);
         this.vistaCC.txtFieldDNI.setEditable(false);
         this.vistaCC.txtFieldCActual.setEditable(false);
         
    }
}
