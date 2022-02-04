
package controlador;

import datos.Datos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Alumno;
import modelo.Operario;
import modelo.Sistema;
import vista.JFrameAgregarAlumno;
import vista.JFrameAlumno;
import vista.JFrameCambiarRaciones;
import vista.JFrameMostrarTurnos;
import vista.JFrameOperario;
import vista.JFrameSistema;
import vista.JFrameSolicitarTicket;
import vista.JFrameTablaDeTicketsTotales;
import vista.JFrameValidarTicket;

/**
 *
 * @author Favio
 */
public class ControladorSistema {
    
     JFrameSistema sistemaGeneral;
     Sistema sistema;
     Alumno alumnot;
    
  
    public ControladorSistema(JFrameSistema sistemaGeneral, Sistema sistema, Alumno alumnot) {
        this.sistemaGeneral = sistemaGeneral;
        this.sistema = sistema;
        this.alumnot = alumnot;
        
        
          if(this.alumnot == null){
              adjuntarDatosOperario();  
          }
          else{
               adjuntarDatosAlumno();
          }
          
          if(this.alumnot==null){
              sistemaGeneral.jMenuAlumno.setEnabled(false);
          }else{
              sistemaGeneral.jMenuOperario.setEnabled(false);
          }
                 
        
        
          
        this.sistemaGeneral.jMostrarTicketsTotales.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    
                   sistemaGeneral.dispose();
                   JFrameTablaDeTicketsTotales vistaTablaTT = new JFrameTablaDeTicketsTotales();
                   ControladorTicketsTotales ticketTT = new ControladorTicketsTotales(vistaTablaTT,sistema,alumnot); 
                   vistaTablaTT.setVisible(true);
                   vistaTablaTT.setLocationRelativeTo(null);  
                  //adjuntarDatosAlumno();
                  //adjuntarDatosOperario();
            }
        });
        
        this.sistemaGeneral.jMenuAlumSolicitarT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sistemaGeneral.dispose();
                JFrameSolicitarTicket vistast = new JFrameSolicitarTicket();
                ControladorSolicitarTicket contrST = new ControladorSolicitarTicket(vistast, sistema, alumnot);
                vistast.setLocationRelativeTo(null);
                vistast.setVisible(true);
                //sistema.asignarTicket(alumnot);
                //JOptionPane.showMessageDialog(sistemaGeneral, sistema.getTicketscreadosconfecha());
            }
        });
        
       this.sistemaGeneral.jButtonRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sistemaGeneral.dispose();
                
                if(alumnot == null){
                JFrameOperario vistaOperario = new JFrameOperario();
                ControladorVentanaOperario ventanaOperario = new ControladorVentanaOperario(vistaOperario,sistema);
                vistaOperario.setVisible(true);
                vistaOperario.setLocationRelativeTo(null);
                }
                
                else{
                    JFrameAlumno vistaAlumno = new JFrameAlumno();
                    ControladorVentanaAlumno ventanaAlumno = new ControladorVentanaAlumno(alumnot, vistaAlumno, sistema);
                    vistaAlumno.setVisible(true);
                    vistaAlumno.setLocationRelativeTo(null);
                }
            }
        });
       
       
       this.sistemaGeneral.jCambiarRaciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 
                sistemaGeneral.dispose();
                JFrameCambiarRaciones vistaCR = new JFrameCambiarRaciones();
                ControladorModificarRaciones contrlMR = new ControladorModificarRaciones(vistaCR, sistema, alumnot);
                vistaCR.setLocationRelativeTo(null);
                vistaCR.setVisible(true);  
           }
       });
       
       this.sistemaGeneral.jMenuAlumMostrarT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                  sistemaGeneral.dispose();
                  JFrameMostrarTurnos vistaMT = new JFrameMostrarTurnos();
                  ControladorMostrarTurnos contrlMT = new ControladorMostrarTurnos(vistaMT, sistema, alumnot);
                  vistaMT.setLocationRelativeTo(null);
                  vistaMT.setVisible(true);
            }
       });
       
      this.sistemaGeneral.jMenuValidarTicket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 sistemaGeneral.dispose();
                 JFrameValidarTicket vistaVT = new JFrameValidarTicket();
                 ControladorValidarTickets contrlVT = new ControladorValidarTickets(vistaVT, sistema, alumnot);
                 vistaVT.setLocationRelativeTo(null);
                 vistaVT.setVisible(true);
            }
      });
      
      this.sistemaGeneral.jMenuItemVersion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(sistemaGeneral,Datos.version,"VERSIÓN",JOptionPane.INFORMATION_MESSAGE);
                System.out.println("????");
            }
      });
       
    }
     
     public void adjuntarDatosAlumno(){ 
      
        sistemaGeneral.jTextFieldNombre.setText(alumnot.getNombres());
        sistemaGeneral.jTextFieldApellido.setText(alumnot.getApellidos());
        sistemaGeneral.jTextFieldDNI.setText(String.valueOf(alumnot.getDNI()));
        sistemaGeneral.jTextFieldCodigo.setText(alumnot.getCodigo()); 
        sistemaGeneral.jTextFieldNombre.setEditable(false);
        sistemaGeneral.jTextFieldApellido.setEditable(false);
        sistemaGeneral.jTextFieldDNI.setEditable(false);
        sistemaGeneral.jTextFieldCodigo.setEditable(false);
        
    }
     public void adjuntarDatosOperario(){
        
        sistemaGeneral.jTextFieldNombre.setText(sistema.getOperario().getNombres());
        sistemaGeneral.jTextFieldApellido.setText(sistema.getOperario().getApellidos());
        sistemaGeneral.jTextFieldDNI.setText(String.valueOf(sistema.getOperario().getDni()));
        sistemaGeneral.jTextFieldCodigo.setText(sistema.getOperario().getCodigo());
        sistemaGeneral.jTextFieldNombre.setEditable(false);
        sistemaGeneral.jTextFieldApellido.setEditable(false);
        sistemaGeneral.jTextFieldDNI.setEditable(false);
        sistemaGeneral.jTextFieldCodigo.setEditable(false);
    }
}
