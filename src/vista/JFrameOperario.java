/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

/**
 *
 * @author Favio
 */
public class JFrameOperario extends javax.swing.JFrame {

    /**
     * Creates new form JFrameOperario
     */
    public JFrameOperario() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnSalirOp = new javax.swing.JButton();
        btnMostAlumRegistrados = new javax.swing.JButton();
        btnAccederSistemaOp = new javax.swing.JButton();
        btnRegistrarAlumno = new javax.swing.JButton();
        btnCrearFechaYTicket = new javax.swing.JButton();
        jLabelBienvenidaOp = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(252, 241, 180));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 2, 18)); // NOI18N
        jLabel1.setText("Bienvenido  Operario ");

        btnSalirOp.setFont(new java.awt.Font("SansSerif", 2, 14)); // NOI18N
        btnSalirOp.setText("Salir");
        btnSalirOp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirOpActionPerformed(evt);
            }
        });

        btnMostAlumRegistrados.setFont(new java.awt.Font("SansSerif", 2, 14)); // NOI18N
        btnMostAlumRegistrados.setText("Alumnos Registrados");
        btnMostAlumRegistrados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostAlumRegistradosActionPerformed(evt);
            }
        });

        btnAccederSistemaOp.setFont(new java.awt.Font("SansSerif", 2, 14)); // NOI18N
        btnAccederSistemaOp.setText("Opciones Comedor");
        btnAccederSistemaOp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccederSistemaOpActionPerformed(evt);
            }
        });

        btnRegistrarAlumno.setFont(new java.awt.Font("SansSerif", 2, 14)); // NOI18N
        btnRegistrarAlumno.setText("Registrar Alumno");

        btnCrearFechaYTicket.setFont(new java.awt.Font("SansSerif", 2, 14)); // NOI18N
        btnCrearFechaYTicket.setText("Crear Fecha y Tickets");
        btnCrearFechaYTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearFechaYTicketActionPerformed(evt);
            }
        });

        jLabelBienvenidaOp.setFont(new java.awt.Font("Yu Gothic UI Semilight", 2, 18)); // NOI18N
        jLabelBienvenidaOp.setText("           ");
        jLabelBienvenidaOp.setMaximumSize(new java.awt.Dimension(130, 25));
        jLabelBienvenidaOp.setMinimumSize(new java.awt.Dimension(125, 25));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/6843091_businessman_effective_effective employees_employee_professional_icon.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnSalirOp)
                .addGap(41, 41, 41))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(33, 33, 33)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnMostAlumRegistrados)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(9, 9, 9)
                                    .addComponent(btnRegistrarAlumno)))
                            .addGap(36, 36, 36)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnCrearFechaYTicket)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(btnAccederSistemaOp)
                                    .addGap(9, 9, 9))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGap(107, 107, 107)
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabelBienvenidaOp, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(jLabel2)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabelBienvenidaOp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAccederSistemaOp)
                            .addComponent(btnRegistrarAlumno))
                        .addGap(88, 88, 88))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnMostAlumRegistrados)
                            .addComponent(btnCrearFechaYTicket))
                        .addGap(27, 27, 27)))
                .addComponent(btnSalirOp)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMostAlumRegistradosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostAlumRegistradosActionPerformed
        // TODO add your handling code here:
 
    }//GEN-LAST:event_btnMostAlumRegistradosActionPerformed

    private void btnCrearFechaYTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearFechaYTicketActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCrearFechaYTicketActionPerformed

    private void btnSalirOpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirOpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalirOpActionPerformed

    private void btnAccederSistemaOpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccederSistemaOpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAccederSistemaOpActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrameOperario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameOperario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameOperario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameOperario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameOperario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAccederSistemaOp;
    public javax.swing.JButton btnCrearFechaYTicket;
    public javax.swing.JButton btnMostAlumRegistrados;
    public javax.swing.JButton btnRegistrarAlumno;
    public javax.swing.JButton btnSalirOp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabelBienvenidaOp;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
