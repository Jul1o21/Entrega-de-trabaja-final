package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Alimento;
import modelo.CabeceraTicket;
import modelo.Fecha;
import modelo.Nivel;
import modelo.Sistema;
import modelo.Turno;
import vista.*;


/**
 *
 * @author Favio
 */
public class ControladorDatosTickets {

    JFrameDatosTicket datosTicket;
    Fecha fecha;
    Sistema sistema;
    
            
    public ControladorDatosTickets(JFrameDatosTicket datosTicket,Fecha fecha,Sistema sistema) {
        this.datosTicket = datosTicket;
        this.fecha = fecha;
        this.sistema = sistema;
        this.datosTicket.jComboBoxIntervalo.setSelectedIndex(-1);
        
        this.datosTicket.btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                datosTicket.dispose();
                JFrameOperario vistaOperario = new JFrameOperario();
                ControladorVentanaOperario ventanaOperario = new ControladorVentanaOperario(vistaOperario,sistema);
                vistaOperario.setVisible(true);
                vistaOperario.setLocationRelativeTo(null);
            }
        });

        this.datosTicket.btnGenerar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int numeronivel,numeroturno;
                String intervaloturno,alimentoname;
                Nivel nivel;
                Turno turno;
                Alimento alimento;

                numeronivel = Integer.parseInt(datosTicket.TxtFieldNivel.getText());
                numeroturno = Integer.parseInt(datosTicket.TxtFieldTurno.getText());
                intervaloturno = datosTicket.jComboBoxIntervalo.getSelectedItem().toString();
                alimentoname = datosTicket.TxtAlmuerzo.getText();
                
                nivel = new Nivel(numeronivel);
                turno = new Turno(numeroturno, intervaloturno);
                alimento = new Alimento(alimentoname);

                CabeceraTicket ticketsgeneradosporop;
                ticketsgeneradosporop = fecha.creartickets(nivel, turno, alimento, fecha);
                // ticketsgeneradosporop = new CabeceraTicket(333, nivel, turno, alimento, fechagenerada);
                
                if(fecha.isEstadoopen()==true){  
                     sistema.setTicketscreadosconfecha(ticketsgeneradosporop);
                      limpiarYActualizarTabla(ticketsgeneradosporop);
                }else{
                      JOptionPane.showMessageDialog(datosTicket, "Fuera de horario");
                }
               
                //JOptionPane.showMessageDialog(datosTicket,sistema.getTicketscreadosconfecha());
               
            }
        });
        
        this.datosTicket.btnMostrarFechaCreada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                
                JOptionPane.showMessageDialog(datosTicket, "La fecha generada es"+fecha);
                
            }
        });

    }
   

    
    
    private void limpiarYActualizarTabla(CabeceraTicket ticketsgeneradosporop) {
        
        datosTicket.txtTurnoLabel.setText(datosTicket.TxtFieldTurno.getText()+" - "+datosTicket.jComboBoxIntervalo.getSelectedItem().toString());
        datosTicket.txtNivelLabel.setText(datosTicket.TxtFieldNivel.getText());
        datosTicket.txtAlmuerzoLabel.setText(datosTicket.TxtAlmuerzo.getText());
        
        datosTicket.TxtFieldNivel.setText("");
        datosTicket.TxtFieldTurno.setText("");
        datosTicket.jComboBoxIntervalo.setSelectedIndex(-1);
        datosTicket.TxtAlmuerzo.setText("");
        
        DefaultTableModel modelotabla = new DefaultTableModel(ticketsgeneradosporop.getDatos(),ticketsgeneradosporop.getCabecera());
        this.datosTicket.jTableTickets.setModel(modelotabla);
       
        //this.vista.txtCodigo.requestFocus();
        //this.vista.txtCodigo.selectAll(); 
    }
    
}
