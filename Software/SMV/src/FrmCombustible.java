
import java.awt.event.KeyEvent;
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
public class FrmCombustible extends javax.swing.JDialog {

    /**
     * Creates new form FrmCombustible
     */
    public FrmCombustible(javax.swing.JDialog parent, boolean modal, int ID, float c) {
        super(parent, modal);
        //  int dato=ID;
        //   lblid.setText(ID);
        System.out.println("hola" + ID);
        initComponents();
        setLocationRelativeTo(null);
        //  lblid.setText("hola");
        RbCargado.setSelected(true);
        txtid.setText(String.valueOf(ID));
        txtcom.setText(String.valueOf(c));
        int id = ID;
        vehiculo mvehiculo = new vehiculo();
        mvehiculo.setIdentificador(ID);
        txtcom.setVisible(false);
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

        Grupo = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        TxtCombustible = new javax.swing.JTextField();
        BtnAceptar = new javax.swing.JButton();
        RbCargado = new javax.swing.JRadioButton();
        RbGastado = new javax.swing.JRadioButton();
        txtid = new javax.swing.JTextField();
        txtcom = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("COMBUSTIBLE");

        TxtCombustible.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtCombustibleKeyTyped(evt);
            }
        });

        BtnAceptar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                BtnAceptarKeyTyped(evt);
            }
        });

        Grupo.add(RbCargado);
        RbCargado.setText("Cargado");

        Grupo.add(RbGastado);
        RbGastado.setText("Gastado");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(RbCargado)
                                .addGap(52, 52, 52)
                                .addComponent(RbGastado))
                            .addComponent(TxtCombustible, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(57, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(BtnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtcom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RbCargado)
                    .addComponent(RbGastado))
                .addGap(7, 7, 7)
                .addComponent(TxtCombustible, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addComponent(txtcom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtCombustibleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtCombustibleKeyTyped
        char caracter = evt.getKeyChar();
        if (((caracter < '0') || (caracter > '9')) && (caracter != KeyEvent.VK_BACK_SPACE)
                && (caracter != '.')) {
            /* lo que deseo colocar aqui es si ya se pulso el caracter (.) el mismo no se pueda repetir*/
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingresar Solo Números");
        }
    }//GEN-LAST:event_TxtCombustibleKeyTyped

    private void BtnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAceptarActionPerformed

        if (RbGastado.isSelected()) {
            float com = Float.valueOf(txtcom.getText());
            float co = Float.valueOf(TxtCombustible.getText());
            System.out.println(com);
            System.out.println(co);
            if (com >= co) {
                vehiculo mvehiculo = new vehiculo();
                mvehiculo.setComb_gastado(Float.valueOf(TxtCombustible.getText()));
                mvehiculo.setIdentificador(Integer.valueOf(txtid.getText()));
                try {
                    BD mBD = new BD();
                    if (mBD.Conectar()) {
                        mBD.agregarCombustibleGastado(mvehiculo);
                        JOptionPane.showMessageDialog(rootPane, "Combustible gastado registrado con exito");
                        this.setVisible(false);
                    }

                } catch (Exception ex) {
                    System.out.println(ex.toString());
                    JOptionPane.showMessageDialog(rootPane, "ERROR");
                    this.setVisible(false);
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Ingrese combustible menor");
            }

        } else {

            vehiculo mvehiculo = new vehiculo();
            mvehiculo.setComb_gastado(Float.valueOf(TxtCombustible.getText()));
            mvehiculo.setIdentificador(Integer.valueOf(txtid.getText()));
            try {
                BD mBD = new BD();
                if (mBD.Conectar()) {
                    mBD.cargarCombustible(mvehiculo);
                    JOptionPane.showMessageDialog(rootPane, "Combustible cargado con exito");
                    this.setVisible(false);
                }

            } catch (Exception ex) {
                System.out.println(ex.toString());
                JOptionPane.showMessageDialog(rootPane, "Error");
            }

        }

    }//GEN-LAST:event_BtnAceptarActionPerformed

    private void BtnAceptarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnAceptarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (RbGastado.isSelected()) {
            float com = Float.valueOf(txtcom.getText());
            float co = Float.valueOf(TxtCombustible.getText());
            System.out.println(com);
            System.out.println(co);
            if (com >= co) {
                vehiculo mvehiculo = new vehiculo();
                mvehiculo.setComb_gastado(Float.valueOf(TxtCombustible.getText()));
                mvehiculo.setIdentificador(Integer.valueOf(txtid.getText()));
                try {
                    BD mBD = new BD();
                    if (mBD.Conectar()) {
                        mBD.agregarCombustibleGastado(mvehiculo);
                        JOptionPane.showMessageDialog(rootPane, "Combustible gastado registrado con exito");
                        this.setVisible(false);
                    }

                } catch (Exception ex) {
                    System.out.println(ex.toString());
                    JOptionPane.showMessageDialog(rootPane, "ERROR");
                    this.setVisible(false);
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Ingrese combustible menor");
            }

        } else {

            vehiculo mvehiculo = new vehiculo();
            mvehiculo.setComb_gastado(Float.valueOf(TxtCombustible.getText()));
            mvehiculo.setIdentificador(Integer.valueOf(txtid.getText()));
            try {
                BD mBD = new BD();
                if (mBD.Conectar()) {
                    mBD.cargarCombustible(mvehiculo);
                    JOptionPane.showMessageDialog(rootPane, "Combustible cargado con exito");
                    this.setVisible(false);
                }

            } catch (Exception ex) {
                System.out.println(ex.toString());
                JOptionPane.showMessageDialog(rootPane, "Error");
            }

        }
        }
    }//GEN-LAST:event_BtnAceptarKeyPressed

    private void BtnAceptarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnAceptarKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnAceptarKeyTyped

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
            java.util.logging.Logger.getLogger(FrmCombustible.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCombustible.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCombustible.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCombustible.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                int dato = 0;
                float c = 0;
                FrmCombustible dialog = new FrmCombustible(new javax.swing.JDialog(), true, dato, c);
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
    private javax.swing.ButtonGroup Grupo;
    private javax.swing.JRadioButton RbCargado;
    private javax.swing.JRadioButton RbGastado;
    private javax.swing.JTextField TxtCombustible;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtcom;
    private javax.swing.JTextField txtid;
    // End of variables declaration//GEN-END:variables
}
