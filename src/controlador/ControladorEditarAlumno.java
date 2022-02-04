
package controlador;

import datos.Datos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import modelo.Alumno;
import modelo.Facultad;
import modelo.Sistema;
import vista.JFrameEditarAlumno;
import vista.JFrameMostrarAlumnosDelSistema;

/**
 *
 * @author Favio
 */
public class ControladorEditarAlumno {
    
    JFrameEditarAlumno vista;
    Sistema sistema;
    Alumno alumnoAt;

    public ControladorEditarAlumno(JFrameEditarAlumno vista, Sistema sistema,Alumno alumnoP) {
        this.vista = vista;
        this.sistema = sistema;
        this.alumnoAt = alumnoP;
        
        
         this.vista.btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  String codigo,nombres,apellidos,correo,facultad;
                  int DNI;
                  Facultad facu ;
                  
                  
                  codigo=vista.txtCodigo.getText();
                  nombres=vista.txtNombres.getText();
                  apellidos=vista.txtApellidos.getText();
                  correo=vista.txtCorreo.getText();
                  DNI=Integer.parseInt(vista.txtDNI.getText());
                  facultad = vista.cboFacultad.getSelectedItem().toString();
                  facu = new Facultad(facultad);
                  
                  if(sistema.getAlumnosRegistrados().verificarAlumnoYCambiar(
                  alumnoAt.getContraseña(),alumnoAt.getCodigo(), codigo, nombres, apellidos,
                          correo, DNI, facu)==true){
                       JOptionPane.showMessageDialog(vista,"Alumno actualizado con exito");
                  }else{
                      JOptionPane.showMessageDialog(vista, "No se pudo actualizar","ERROR!!!",JOptionPane.ERROR_MESSAGE);
                  }
            }
         } );
        
         this.vista.btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                   vista.dispose();
                   JFrameMostrarAlumnosDelSistema vistaMDS = new JFrameMostrarAlumnosDelSistema();
                   ControladorMostrarAS controlMAS = new ControladorMostrarAS(vistaMDS, sistema);
                   vistaMDS.setLocationRelativeTo(null);
                   vistaMDS.setVisible(true);
            }
         });
        
        
    }  
    
    public void iniciar_vista(){
        
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
        
        vista.txtCodigo.setText(alumnoAt.getCodigo());
        vista.txtApellidos.setText(alumnoAt.getApellidos());
        vista.txtCorreo.setText(alumnoAt.getCorreo());
        vista.txtNombres.setText(alumnoAt.getNombres());
        vista.txtDNI.setText(String.valueOf(alumnoAt.getDNI()));
        
        

        DefaultComboBoxModel modelocombobox = new DefaultComboBoxModel();
        for( Object o : Datos.arreglotipofacultad.getDatosCombo()){
            modelocombobox.addElement(o);
        }
        this.vista.cboFacultad.setModel(modelocombobox);
            
        int indice_tmp = Datos.arreglotipofacultad.find(alumnoAt.getFacultad().getNombrefacultad());
        vista.cboFacultad.setSelectedIndex(indice_tmp);
              
    }
}
