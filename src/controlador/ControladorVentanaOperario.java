
package controlador;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Alumno;
import modelo.Facultad;
import modelo.Fecha;
import modelo.Sistema;
import vista.JFrameAgregarAlumno;
import vista.JFrameDatosTicket;
import vista.JFrameLogeo;
import vista.JFrameMostrarAlumnosDelSistema;
import vista.JFrameOperario;
import vista.JFrameSistema;

/**
 *
 * @author Favio
 */
public class ControladorVentanaOperario {
    
    JFrameOperario fventanaOperario;
    Sistema sistema;
    
    public ControladorVentanaOperario(JFrameOperario fventanaOperario, Sistema sistema) {
        this.fventanaOperario = fventanaOperario;
        this.sistema = sistema;
        
        fventanaOperario.jLabelBienvenidaOp.setText(sistema.getOperario().getNombres());
        
        this.fventanaOperario.btnCrearFechaYTicket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                         
                         Fecha fechagenerada;
                         fechagenerada = sistema.getOperario().crearFechaParaTickets();    
                         fventanaOperario.dispose();
                         JFrameDatosTicket datosTicket = new JFrameDatosTicket();
                         ControladorDatosTickets datosT = new ControladorDatosTickets(datosTicket,fechagenerada,sistema);
                         datosTicket.setVisible(true);
                         datosTicket.setLocationRelativeTo(null);
                
            }
            
        });
            
        this.fventanaOperario.btnAccederSistemaOp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                   fventanaOperario.dispose();
                   JFrameSistema vistaSistema = new JFrameSistema();
                   ControladorSistema contrSistema = new ControladorSistema(vistaSistema,sistema, null);
                   vistaSistema.setVisible(true);
                   vistaSistema.setLocationRelativeTo(null);
                   
            }
        });
        
        this.fventanaOperario.btnSalirOp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                   fventanaOperario.dispose();
                   JFrameLogeo vistaLogueo = new JFrameLogeo();
                    ControladorLogueo contLogueo = new ControladorLogueo(vistaLogueo,sistema);
                    vistaLogueo.setVisible(true);
                    vistaLogueo.setLocationRelativeTo(null);
                    
            }
        });
        
        this.fventanaOperario.btnRegistrarAlumno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                 fventanaOperario.dispose();
                 JFrameAgregarAlumno ventanaAA = new JFrameAgregarAlumno();
                 ControladorRegistrarAlumno contrRA = new ControladorRegistrarAlumno(ventanaAA, sistema);
                 ventanaAA.setLocationRelativeTo(null);
                 ventanaAA.setVisible(true);
            }
        });
        
        this.fventanaOperario.btnMostAlumRegistrados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                  fventanaOperario.dispose();
                  JFrameMostrarAlumnosDelSistema vistaMAS = new JFrameMostrarAlumnosDelSistema();
                  ControladorMostrarAS contrMAS  = new ControladorMostrarAS(vistaMAS, sistema);
                  vistaMAS.setLocationRelativeTo(null);
                  vistaMAS.setVisible(true);
                
            }
        });
    }
    
    public void iniciarVentanaOp(){
           fventanaOperario.setLocationRelativeTo(null);
          fventanaOperario.setVisible(true); 
         
    }
    
    
}
