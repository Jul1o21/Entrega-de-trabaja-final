package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Alumno;
import modelo.CabeceraTicket;
import modelo.Sistema;
import vista.JFrameSolicitarTicket;
import vista.JFrameSolicitarTicketManual;

/**
 *
 * @author Favio
 */
public class ControladorSolicitarTicketManual {

    JFrameSolicitarTicketManual vistaST;
    Sistema sistema;
    Alumno alumnoAt;

    String valorNivel = " ";
    String valorTurno = " ";
    CabeceraTicket cabeceraEncontrada;
    
    
    
    public ControladorSolicitarTicketManual(JFrameSolicitarTicketManual vistaST, Sistema sistema, Alumno alumnoP) {
        this.vistaST = vistaST;
        this.sistema = sistema;
        this.alumnoAt = alumnoP;
        
            vistaST.jComboBoxTurno.setSelectedIndex(-1);
            vistaST.jComboBoxNivel.setSelectedIndex(-1);
            
        this.vistaST.btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vistaST.dispose();
                JFrameSolicitarTicket vistaST = new JFrameSolicitarTicket();
                ControladorSolicitarTicket contrST = new ControladorSolicitarTicket(vistaST, sistema, alumnoP);
                vistaST.setLocationRelativeTo(null);
                vistaST.setVisible(true);
            }
        });

        this.vistaST.jComboBoxNivel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //System.out.println(tablaTT.jComboBoxNivel.getSelectedItem().toString());
                valorNivel = vistaST.jComboBoxNivel.getSelectedItem().toString();
                //encontrar();
                if (!valorNivel.equals(" ") && !valorTurno.equals(" ")) {
                    encontrar();
                }

            }
        });

        this.vistaST.jComboBoxTurno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //System.out.println(tablaTT.jComboBoxTurno.getSelectedItem().toString());  
                valorTurno = vistaST.jComboBoxTurno.getSelectedItem().toString();
                //encontrar();
                if (!valorNivel.equals(" ") && !valorTurno.equals(" ")) {
                    encontrar();
                }
            }

        });
        this.vistaST.btnConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int nivelEntero, turnoEntero;
                nivelEntero = Integer.parseInt(valorNivel);

                turnoEntero = Integer.parseInt(valorTurno);

                

                if (sistema.asignarTicketManual(alumnoAt, nivelEntero, turnoEntero)==true) {
                    JOptionPane.showMessageDialog(vistaST, "Ticket Asignado a  " + alumnoAt.getCodigo());
                     LlenarIndicesTabla(cabeceraEncontrada);
                } else{
                    JOptionPane.showMessageDialog(vistaST, "No se pudo Asignar un Ticket a  " + alumnoAt.getCodigo(),
                            "ERROR!!!", JOptionPane.ERROR_MESSAGE);
                }

            }
           
            
            
        });
    }

    public void encontrar() {

        MandarDatos("1", "1");
        MandarDatos("1", "2");
        MandarDatos("1", "3");
        MandarDatos("1", "4");
        MandarDatos("2", "1");
        MandarDatos("2", "2");
        MandarDatos("2", "3");
        MandarDatos("2", "4");
    }

    private void LlenarIndicesTabla(CabeceraTicket ticketsEncontrados) {

        //datosTicket.txtAlmuerzoLabel.setText(datosTicket.TxtAlmuerzo.getText());
        //tablaTT.jComboBoxNivel.setSelectedIndex(-1);
        //tablaTT.jComboBoxTurno.setSelectedIndex(-1);
        DefaultTableModel modelotabla = new DefaultTableModel(ticketsEncontrados.getDatos2(), ticketsEncontrados.getCabecera2());
        this.vistaST.jTableTicketsLimitados.setModel(modelotabla);

        //this.vista.txtCodigo.requestFocus();
        //this.vista.txtCodigo.selectAll(); 
    }

    public void MandarDatos(String n, String t) {
        if (valorNivel.equals(n) && valorTurno.equals(t)) {
            int niv = Integer.parseInt(valorNivel);
            int tur = Integer.parseInt(valorTurno);

            cabeceraEncontrada = sistema.getTicketscreadosconfecha().encontrarCabeceraTicket(niv, tur);
            if (cabeceraEncontrada != null) {
                LlenarIndicesTabla(cabeceraEncontrada);
            } else {
                JOptionPane.showMessageDialog(vistaST, "La cabecera no existe!!!");
            }
        }
    }

}
