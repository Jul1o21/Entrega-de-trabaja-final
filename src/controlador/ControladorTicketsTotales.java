package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.*;
import vista.JFrameSistema;
import vista.JFrameTablaDeTicketsTotales;
import static archivos.Archivo.*;
/**
 *
 * @author Favio
 */
public class ControladorTicketsTotales {

    JFrameTablaDeTicketsTotales tablaTT;
    Sistema sistema;
    String valorNivel = " ";
    String valorTurno = " ";
    CabeceraTicket cabeceraEncontrada;
    Alumno alumno;

    public ControladorTicketsTotales(JFrameTablaDeTicketsTotales tablaTT, Sistema sistema, Alumno alumno) {
        this.tablaTT = tablaTT;
        this.sistema = sistema;
        this.alumno = alumno;
        tablaTT.jComboBoxNivel.setSelectedIndex(-1);
        tablaTT.jComboBoxTurno.setSelectedIndex(-1);

        this.tablaTT.jComboBoxNivel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //System.out.println(tablaTT.jComboBoxNivel.getSelectedItem().toString());
                valorNivel = tablaTT.jComboBoxNivel.getSelectedItem().toString();
                //encontrar();
                if (!valorNivel.equals(" ") && !valorTurno.equals(" ")) {
                    encontrar();
                }

            }
        });

        this.tablaTT.jComboBoxTurno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //System.out.println(tablaTT.jComboBoxTurno.getSelectedItem().toString());  
                valorTurno = tablaTT.jComboBoxTurno.getSelectedItem().toString();
                //encontrar();
                if (!valorNivel.equals(" ") && !valorTurno.equals(" ")) {
                    encontrar();
                }
            }

        });

        this.tablaTT.btnRegresarTT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tablaTT.dispose();
                JFrameSistema sistemaTT = new JFrameSistema();
                ControladorSistema controladorSG = new ControladorSistema(sistemaTT, sistema, alumno);
                sistemaTT.setLocationRelativeTo(null);
                sistemaTT.setVisible(true);
            }
        });
        
        this.tablaTT.btnReporteTicketTotatles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String TicketTotales;
               
               TicketTotales = sistema.getTicketscreadosconfecha().toString();
               crearArchivo("Reporte Tickets Totales.txt");
               anexarArchivo("Reporte Tickets Totales.txt", TicketTotales);
               JOptionPane.showMessageDialog(tablaTT, "Reporte creado con exito", "Reporte", JOptionPane.INFORMATION_MESSAGE);
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

        tablaTT.txtAlmuerzoTicketsTotales.setText(ticketsEncontrados.getAlimento().getTipoAlimento());
        //datosTicket.txtAlmuerzoLabel.setText(datosTicket.TxtAlmuerzo.getText());
        //tablaTT.jComboBoxNivel.setSelectedIndex(-1);
        //tablaTT.jComboBoxTurno.setSelectedIndex(-1);
        DefaultTableModel modelotabla = new DefaultTableModel(ticketsEncontrados.getDatos(), ticketsEncontrados.getCabecera());
        this.tablaTT.jTableTT.setModel(modelotabla);

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
                JOptionPane.showMessageDialog(tablaTT, "La cabecera no existe!!!");
            }
        }
    }
}
