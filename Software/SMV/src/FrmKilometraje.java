
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aide
 */
public class FrmKilometraje extends javax.swing.JDialog {

    /**
     * Creates new form FrmKilometraje
     */
    public FrmKilometraje(javax.swing.JDialog parent, boolean modal, int ID) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
         txtid.setText(String.valueOf(ID));
         txtid.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtnAceptar = new javax.swing.JButton();
        TxtKilometraje = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        BtnAceptar.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        BtnAceptar.setText("ACEPTAR");
        BtnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAceptarActionPerformed(evt);
            }
        });
        BtnAceptar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnAceptarKeyPressed(evt);
            }
        });

        TxtKilometraje.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtKilometrajeKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel1.setText("KILOMETRAJE RECORRIDO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(TxtKilometraje, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(BtnAceptar)))
                .addContainerGap(45, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addComponent(txtid, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtKilometraje, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnAceptar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAceptarActionPerformed
             if (TxtKilometraje.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Llene el campo");
        } else {
              vehiculo mvehiculo = new vehiculo();
            mvehiculo.setKm_recorr(Float.valueOf(TxtKilometraje.getText()));
            mvehiculo.setIdentificador(Integer.valueOf(txtid.getText()));
            try {
                BD mBD = new BD();
                if (mBD.Conectar()) {
                    double km = 0;
                    mBD.agregarKilometraje(mvehiculo);
                    ResultSet result = mBD.ConskmFrenos(mvehiculo);
                    while(result.next()){
                        km = result.getDouble(1);
                    }
                    if(km >= 10000){
                        JOptionPane.showMessageDialog(rootPane, "Necesita realizar Mantenimiento a los frenos y a lo");
                    }
                    JOptionPane.showMessageDialog(rootPane, "Kilometraje recorrido");
                    this.setVisible(false);
                }

            } catch (Exception ex) {
                System.out.println(ex.toString());
                JOptionPane.showMessageDialog(rootPane, "Error");
            }
                this.setVisible(false);
             }
    }//GEN-LAST:event_BtnAceptarActionPerformed

    private void BtnAceptarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnAceptarKeyPressed
          if(evt.getKeyCode()==KeyEvent.VK_ENTER){
        if (TxtKilometraje.getText().equals("")) {
          //  JOptionPane.showMessageDialog(rootPane, "Llene el campo");
        } else {
                vehiculo mvehiculo = new vehiculo();
            mvehiculo.setKm_recorr(Float.valueOf(TxtKilometraje.getText()));
            mvehiculo.setIdentificador(Integer.valueOf(txtid.getText()));
            try {
                BD mBD = new BD();
                if (mBD.Conectar()) {
                    mBD.agregarKilometraje(mvehiculo);
                    JOptionPane.showMessageDialog(rootPane, "Kilometraje recorrido");
                    this.setVisible(false);
                }

            } catch (Exception ex) {
                System.out.println(ex.toString());
                JOptionPane.showMessageDialog(rootPane, "Error");
            }
                this.setVisible(false);
             }
          }
          
    }//GEN-LAST:event_BtnAceptarKeyPressed

    private void TxtKilometrajeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtKilometrajeKeyTyped
         char caracter = evt.getKeyChar();
        if (((caracter < '0') || (caracter > '9')) && (caracter != KeyEvent.VK_BACK_SPACE)
            && (caracter != '.')) {
            /* lo que deseo colocar aqui es si ya se pulso el caracter (.) el mismo no se pueda repetir*/
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingresar Solo Números");
        }
    }//GEN-LAST:event_TxtKilometrajeKeyTyped

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowGainedFocus

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
            java.util.logging.Logger.getLogger(FrmKilometraje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmKilometraje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmKilometraje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmKilometraje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                int dato=0;
                FrmKilometraje dialog = new FrmKilometraje(new javax.swing.JDialog(), true, dato );
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAceptar;
    private javax.swing.JTextField TxtKilometraje;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtid;
    // End of variables declaration//GEN-END:variables
}
