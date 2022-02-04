package controlador;

import datos.Datos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import modelo.Alumno;
import modelo.ArregloAlumnos;
import modelo.Facultad;
import modelo.Sistema;
import vista.JFrameAgregarAlumno;
import vista.JFrameOperario;
import vista.JFrameSistema;

/**
 *
 * @author Favio
 */
public class ControladorRegistrarAlumno {

    JFrameAgregarAlumno vistaAA;
    Sistema sistema;

    public ControladorRegistrarAlumno(JFrameAgregarAlumno vistaAA, Sistema sistema) {
        this.vistaAA = vistaAA;
        this.sistema = sistema;
        
  iniciar_vista();
  
  
        this.vistaAA.btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vistaAA.dispose();
                JFrameOperario vistaO = new JFrameOperario();
                Alumno alumno = null;
                ControladorVentanaOperario contrOP = new ControladorVentanaOperario(vistaO, sistema);
                vistaO.setLocationRelativeTo(null);
                vistaO.setVisible(true);
            }
        });

        this.vistaAA.btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nombre, apellido, codigo, contrasena, correo;
                int dni;
                Facultad facu;

                nombre = vistaAA.TxtFieldNombre.getText();
                apellido = vistaAA.TxtFieldApellidos.getText();
                codigo = vistaAA.TxtFieldCodigo.getText();
                contrasena = vistaAA.jPasswordFieldContraseña.getText();
                dni = Integer.parseInt(vistaAA.TxtFieldDNI.getText());
                facu = new Facultad(vistaAA.ComboBoxEscuela.getSelectedItem().toString());
                correo = vistaAA.jTextFieldCorreo.getText();

                Alumno alumnoNew = new Alumno(dni, correo, contrasena, nombre, apellido, codigo, facu);
                sistema.getOperario().registrarAlumno(alumnoNew, sistema.getAlumnosRegistrados());
                JOptionPane.showMessageDialog(vistaAA, "Alumno Registrado Con Exito");
            }
        });

    }
    
    
         public void iniciar_vista(){
        

        DefaultComboBoxModel modelocombobox = new DefaultComboBoxModel();
        for( Object o : Datos.arreglotipofacultad.getDatosCombo()){
            modelocombobox.addElement(o);
        }
        this.vistaAA.ComboBoxEscuela.setModel(modelocombobox);
            
        int indice_tmp = Datos.arreglotipofacultad.find("Sistemas");
        vistaAA.ComboBoxEscuela.setSelectedIndex(indice_tmp);
        vistaAA.ComboBoxEscuela.setSelectedIndex(-1);
              
    }
    
  
}
