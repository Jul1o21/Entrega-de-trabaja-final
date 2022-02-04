package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Alumno;
import modelo.Sistema;
import vista.JFrameSistema;
import vista.JFrameSolicitarTicket;
import vista.JFrameSolicitarTicketManual;

/**
 *
 * @author Favio
 */
public class ControladorSolicitarTicket {
    
    JFrameSolicitarTicket vistaST ;
    Sistema sistema;
    Alumno alumnoAt;
    
     
    public ControladorSolicitarTicket(JFrameSolicitarTicket vistaST, Sistema sistema, Alumno alumnoP) {
        this.vistaST = vistaST;
        this.sistema = sistema;
        this.alumnoAt = alumnoP;
        
        mostrarDatos();
        
        this.vistaST.btnSolicitarTicketAuto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
           
                
                
                if(sistema.asignarTicket(alumnoAt)==true){
                    
                    alumnoAt.setHaveticket(true);
                    JOptionPane.showMessageDialog(vistaST, "Ticket Asignado a  "+alumnoAt.getCodigo());
                }
                else{
                    JOptionPane.showMessageDialog(vistaST,"No se pudo Asignar un Ticket a  "+alumnoAt.getCodigo(),
                            "ERROR!!!",JOptionPane.ERROR_MESSAGE);
                }
    
            }
        });
        
        this.vistaST.btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vistaST.dispose();
                JFrameSistema vistaSist = new JFrameSistema();
                ControladorSistema contrSist = new ControladorSistema(vistaSist, sistema, alumnoP);
                vistaSist.setLocationRelativeTo(null);
                vistaSist.setVisible(true);
            }
        });
        
        this.vistaST.btnSolicitarTicketManual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 vistaST.dispose();
                 JFrameSolicitarTicketManual vistaST = new JFrameSolicitarTicketManual();
                 ControladorSolicitarTicketManual contrST = new ControladorSolicitarTicketManual(vistaST, sistema,alumnoP);
                 vistaST.setLocationRelativeTo(null);
                 vistaST.setVisible(true);
            }
        });
    }  
    
    
    public void mostrarDatos(){
        
        this.vistaST.jTextFieldNombr3.setText(alumnoAt.getNombres());
        this.vistaST.jTextFieldApellid0.setText(alumnoAt.getApellidos());
        this.vistaST.jTextFieldCodig0.setText(alumnoAt.getCodigo());
        this.vistaST.jTextFieldDN1.setText(String.valueOf(alumnoAt.getDNI()));
        this.vistaST.jTextFieldCorr3o.setText(alumnoAt.getCorreo());
        this.vistaST.jTextFieldNombr3.setEditable(false);
        this.vistaST.jTextFieldApellid0.setEditable(false);
        this.vistaST.jTextFieldCodig0.setEditable(false);
        this.vistaST.jTextFieldDN1.setEditable(false);
        this.vistaST.jTextFieldCorr3o.setEditable(false);
    }
    
}
