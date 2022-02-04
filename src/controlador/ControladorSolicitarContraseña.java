/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
*/
import javax.swing.JOptionPane;
import modelo.Alumno;
import modelo.Sistema;
import vista.JFrameSolicitarContraseña;
import controlador.ControladorLogueo;
import vista.JFrameAlumno;

/**
 *
 * @author Favio
 */
public class ControladorSolicitarContraseña {
    
    private Alumno alumnoAt;
    private JFrameSolicitarContraseña vista;
    private Sistema sistema ;
        
    public ControladorSolicitarContraseña(Alumno alumnoP, JFrameSolicitarContraseña vista,Sistema sistema) {
        this.alumnoAt = alumnoP;
        this.vista = vista;
        this.sistema = sistema;
        
        mostrarDatosYbloquearFields();
        vista.btnSolicitar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              /* Properties propiedad = new Properties();
               propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");
               propiedad.setProperty("mail.smtp.starttls.enable", "true");
               propiedad.setProperty("mail.smtp.port", "587");
               propiedad.setProperty("mail.smtp.auth", "true");
               
               Session sesion = Session.getDefaultInstance(propiedad);
               
               //String correoEnviar = modelo.getCorreo();
               String correoEnviar = "favioalonso156@gmail.com";
               String contrasena = "aaaa";
               String destinatario = vista.txtFieldCodigo.getText();
               String asunto = vista.txtFieldDNI.getText();
               String mensaje = vista.txtFieldUsuario.getText();
               
               MimeMessage mail = new MimeMessage(sesion);
                try {
                    mail.setFrom(new InternetAddress(correoEnviar));
                    mail.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
                    mail.setSubject(asunto);
                    mail.setText(mensaje);
                    
                    Transport transporte  = sesion.getTransport("smtp");
                    transporte.connect(correoEnviar,contrasena);
                    transporte.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));
                    transporte.close();
                    
                    JOptionPane.showMessageDialog(vista,"Correo Enviado");
                    
                } catch (AddressException ex) {
                    Logger.getLogger(ControladorSolicitarContraseña.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MessagingException ex) {
                    Logger.getLogger(ControladorSolicitarContraseña.class.getName()).log(Level.SEVERE, null, ex);
                }
                */
                
              JOptionPane.showMessageDialog(vista,alumnoP.getContraseña());
            }
        });
        
        this.vista.btnRegresarContraseña.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 vista.dispose();
                 JFrameAlumno vistaRetroceder = new JFrameAlumno();
                 ControladorVentanaAlumno contVolver = new ControladorVentanaAlumno(alumnoP, vistaRetroceder, sistema);
                 vistaRetroceder.setLocationRelativeTo(null);
                 vistaRetroceder.setVisible(true);
            }
        });
    }
    
    public void mostrarDatosYbloquearFields(){
           vista.txtFieldUsuario.setText(alumnoAt.getNombres());
           vista.txtFieldCodigo.setText(alumnoAt.getCodigo());
           vista.txtFieldDNI.setText(String.valueOf(alumnoAt.getDNI()));
           
           vista.txtFieldUsuario.setEditable(false);
           vista.txtFieldCodigo.setEditable(false);
           vista.txtFieldDNI.setEditable(false);
           
    }
    
}
