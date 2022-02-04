package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Alumno;
import modelo.Sistema;
import vista.JFrameCambiarRaciones;
import vista.JFrameSistema;

/**
 *
 * @author Favio
 */
public class ControladorModificarRaciones {

    JFrameCambiarRaciones vista;
    Sistema sistema;
    Alumno alumnoAt;

    public ControladorModificarRaciones(JFrameCambiarRaciones vista, Sistema sistema, Alumno alumnoP) {
        this.vista = vista;
        this.sistema = sistema;
        this.alumnoAt = alumnoP;

        vista.jTextFieldRActuales.setText(String.valueOf(Sistema.racionestotalesporturno));
        vista.jTextFieldRActuales.setEditable(false);
        
        this.vista.btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista.dispose();
                JFrameSistema vistaSis = new JFrameSistema();
                ControladorSistema contrlSis = new ControladorSistema(vistaSis, sistema, alumnoP);
                vistaSis.setLocationRelativeTo(null);
                vistaSis.setVisible(true);
            }
        });

        this.vista.btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int newrac;
                newrac = Integer.parseInt(vista.jTextFieldRNuevas.getText());
                Sistema.setRacionestotalesporturno(newrac);
            }
        });

    }

}
