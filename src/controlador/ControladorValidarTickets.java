
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Alumno;
import modelo.Sistema;
import vista.JFrameSistema;
import vista.JFrameValidarTicket;

/**
 *
 * @author Favio
 */
public class ControladorValidarTickets {
    
    JFrameValidarTicket vista;
    Sistema sistemaAt;
    Alumno alumnoAt;
    
    public ControladorValidarTickets(JFrameValidarTicket vista, Sistema sistemaP,Alumno alumnoP) {
        this.vista = vista;
        this.sistemaAt = sistemaP;
        this.alumnoAt = alumnoP;
        
        
        this.vista.btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista.dispose();
                JFrameSistema vistaSis = new JFrameSistema();
                ControladorSistema contrSis = new ControladorSistema(vistaSis, sistemaP, alumnoAt);
                vistaSis.setLocationRelativeTo(null);
                vistaSis.setVisible(true);
            }
        });
        
        
        this.vista.btnValidarXCodigo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo;
                codigo = vista.jTextFieldCodigo.getText();
                
                //JOptionPane.showConfirmDialog(vista, "¿Estás Seguro?","¿?",1);
              String[] arreglo = {"SI","Cancelar"}; 
              int opcion = JOptionPane.showOptionDialog(vista, "¿Estas seguro?","¿?", 0,JOptionPane.QUESTION_MESSAGE,null, arreglo,"");
              if(opcion==0){
                  if(sistemaAt.getOperario().validarticketop(codigo, sistemaAt.getTicketscreadosconfecha())==false) {
                      JOptionPane.showMessageDialog(vista,"Error al validar ticket", "Validar Ticket" , JOptionPane.ERROR_MESSAGE );
                  }else{
                      //JOptionPane.showMessageDialog(vista,"Ticket asignado con exito", "Asignar Ticket", JOptionPane.ERROR_MESSAGE );
                      JOptionPane.showMessageDialog(vista, "Ticket validado con exito");
                  }
                  
              }
            }
        });
        
        this.vista.btnValidarTodos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 
                  String[] arreglo = {"SI","Cancelar"}; 
              int opcion = JOptionPane.showOptionDialog(vista, "¿Estas seguro?","¿?", 0,JOptionPane.QUESTION_MESSAGE,null, arreglo,"");
              if(opcion==0){
                  sistemaP.getOperario().validarTodosTicketOp(sistemaP.getTicketscreadosconfecha()); 
              }    
            }
        });
        
    }
     
}
