package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Alumno;
import modelo.ArregloAlumnos;
import modelo.CabeceraTicket;
import modelo.Sistema;
import vista.JFrameEditarAlumno;
import vista.JFrameMostrarAlumnosDelSistema;
import vista.JFrameOperario;
import static archivos.Archivo.*;
/**
 *
 * @author Favio
 */
public class ControladorMostrarAS {

    JFrameMostrarAlumnosDelSistema vistaMAS;
    Sistema sistema;
   
    
    public ControladorMostrarAS(JFrameMostrarAlumnosDelSistema vistaMAS, Sistema sistema) {
        this.vistaMAS = vistaMAS;
        this.sistema = sistema;
        
        ActualizarTabla();

        this.vistaMAS.btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vistaMAS.dispose();
                JFrameOperario vistaOp = new JFrameOperario();
                ControladorVentanaOperario contrOp = new ControladorVentanaOperario(vistaOp, sistema);
                vistaOp.setLocationRelativeTo(null);
                vistaOp.setVisible(true);
            }
        });

        this.vistaMAS.btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int fila = vistaMAS.jTableAR.getSelectedRow();
                int columna = vistaMAS.jTableAR.getSelectedColumn();
                if (fila >= 0) {
                    String codigoeliminar = vistaMAS.jTableAR.getValueAt(fila, 0).toString();
                    sistema.getAlumnosRegistrados().remove(codigoeliminar);
                    ActualizarTabla();
                    JOptionPane.showMessageDialog(vistaMAS, "Registro eliminado", "Eliminar Persona", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    if (sistema.getAlumnosRegistrados().isVacio()) {
                        JOptionPane.showMessageDialog(vistaMAS, "No existen registros para eliminar", "Elimiar Persona", JOptionPane.WARNING_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(vistaMAS, "Selecciones una fila de la tabla ", "Elimiar Persona", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        
        this.vistaMAS.btnEditarNuevaVentana.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                   int fila = vistaMAS.jTableAR.getSelectedRow();
                if( fila >= 0) {
                    vistaMAS.dispose();
                    
                    Alumno  modeloAlumno =  sistema.getAlumnosRegistrados().devolverAlumno(vistaMAS.jTableAR.getValueAt(fila, 0).toString());
                    JFrameEditarAlumno vistaEP = new JFrameEditarAlumno();                 
                    ControladorEditarAlumno contrEA = new ControladorEditarAlumno(vistaEP, sistema,modeloAlumno);
                    contrEA.iniciar_vista();
                    vistaEP.setLocationRelativeTo(null);
                    vistaEP.setVisible(true);   
                    
                }else {
                    JOptionPane.showMessageDialog(vistaMAS,"Selecciones una fila de la tabla para Editar: ", "Editar Persona" , JOptionPane.ERROR_MESSAGE );                    
                }  
            }
        });
        
       this.vistaMAS.btnReporteAlum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String alumregistString;
               
               alumregistString = sistema.getAlumnosRegistrados().toString();
               crearArchivo("Reporte Alumnos Registrados.txt");
               anexarArchivo("Reporte Alumnos Registrados.txt", alumregistString);
               JOptionPane.showMessageDialog(vistaMAS, "Reporte creado con exito", "Reporte", JOptionPane.INFORMATION_MESSAGE);
                   
            }
       });
       this.vistaMAS.btnOrdenarNombre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                sistema.getAlumnosRegistrados().ordenarPorPrimerNombre();
                ActualizarTabla();    
            }
       });
      
      this.vistaMAS.btnOrdenarXPaterno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sistema.getAlumnosRegistrados().ordenarPorPaterno();
                ActualizarTabla();
            }
      });
      this.vistaMAS.btnOrdenarCodigo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              sistema.getAlumnosRegistrados().ordenarPorCodigo();
              ActualizarTabla();
            }
      });
    }

    private void ActualizarTabla() {

        DefaultTableModel modelotabla = new DefaultTableModel(sistema.getAlumnosRegistrados().getDatos(), sistema.getAlumnosRegistrados().getCabecera());
        this.vistaMAS.jTableAR.setModel(modelotabla);

        //this.vista.txtCodigo.requestFocus();
        //this.vista.txtCodigo.selectAll(); 
    }

}
