
import com.sun.glass.events.KeyEvent;
import java.awt.Dimension;
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
public class FrmAlta extends javax.swing.JFrame {

    /**
     * Creates new form FrmAlta
     */
    public FrmAlta() {
        initComponents();

        this.setMinimumSize(new Dimension(700, 500));
        this.setLocationRelativeTo(null);
        //  this.setExtendedState(MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        BtnAtras = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TxtKm = new javax.swing.JTextField();
        TxtMarca = new javax.swing.JTextField();
        TxtModelo = new javax.swing.JTextField();
        TxtAyno = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        BtnAgregar = new javax.swing.JButton();
        TxtDesExtra = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/d13dae216c54aa4fe2ad723969f74b7f-l-neas-rojas.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(null);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("REGISTRO DE VEHÍCULO");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(180, 20, 360, 50);
        getContentPane().add(jPanel1);
        jPanel1.setBounds(560, 250, 10, 10);

        BtnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/FLECHA_1.png"))); // NOI18N
        BtnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAtrasActionPerformed(evt);
            }
        });
        getContentPane().add(BtnAtras);
        BtnAtras.setBounds(590, 410, 60, 30);

        jLabel5.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel5.setText("MARCA");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(90, 100, 110, 30);

        jLabel6.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel6.setText("MODELO");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(90, 150, 110, 30);

        jLabel8.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel8.setText("AÑO");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(90, 190, 100, 30);

        jLabel9.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel9.setText("KILOMETRAJE");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(60, 230, 110, 30);

        jLabel4.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel4.setText("DESCRIPCIÓN EXTRA");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(260, 280, 230, 50);

        TxtKm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtKmKeyTyped(evt);
            }
        });
        getContentPane().add(TxtKm);
        TxtKm.setBounds(170, 240, 140, 30);

        TxtMarca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtMarcaKeyTyped(evt);
            }
        });
        getContentPane().add(TxtMarca);
        TxtMarca.setBounds(170, 100, 140, 30);
        getContentPane().add(TxtModelo);
        TxtModelo.setBounds(170, 150, 140, 30);

        TxtAyno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtAynoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtAynoKeyTyped(evt);
            }
        });
        getContentPane().add(TxtAyno);
        TxtAyno.setBounds(170, 190, 140, 30);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/log.png"))); // NOI18N
        jLabel7.setText("jLabel7");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(250, 50, 400, 240);

        BtnAgregar.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        BtnAgregar.setText("Guardar");
        BtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(BtnAgregar);
        BtnAgregar.setBounds(530, 320, 100, 50);
        getContentPane().add(TxtDesExtra);
        TxtDesExtra.setBounds(150, 320, 350, 40);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/d13dae216c54aa4fe2ad723969f74b7f-l-neas-rojas.png"))); // NOI18N
        jLabel10.setText("jLabel10");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(0, -120, 670, 750);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAtrasActionPerformed
        this.setVisible(false);

    }//GEN-LAST:event_BtnAtrasActionPerformed

    private void TxtAynoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtAynoKeyTyped

        char caracter = evt.getKeyChar();

        // Verificar si la tecla pulsada no es un digito
        if (((caracter < '0')
                || (caracter > '9'))
                && (caracter != '\b' /*corresponde a BACK_SPACE*/)) {
            evt.consume();  // ignorar el evento de teclado
            JOptionPane.showMessageDialog(rootPane, "Ingresar Solo Números");
        }


    }//GEN-LAST:event_TxtAynoKeyTyped

    private void TxtMarcaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtMarcaKeyTyped
        if (!Character.isLetter(evt.getKeyChar())
                != (evt.getKeyChar() == KeyEvent.VK_SPACE)
                != (evt.getKeyChar() == KeyEvent.VK_BACKSPACE)) {
            evt.consume();

        } else {

        }
    }//GEN-LAST:event_TxtMarcaKeyTyped

    private void TxtAynoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtAynoKeyPressed


    }//GEN-LAST:event_TxtAynoKeyPressed

    private void BtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarActionPerformed
        if ((((TxtMarca.getText().equals("")) | (TxtModelo.getText().equals("")) | (TxtAyno.getText().equals("")) | (TxtDesExtra.getText().equals("")) | (TxtKm.getText().equals(""))))) {
            JOptionPane.showMessageDialog(rootPane, "Llene todos los campos");
        } else {
            JOptionPane.showMessageDialog(rootPane, "Vehículo Guardado con Exito");
        }
    }//GEN-LAST:event_BtnAgregarActionPerformed

    private void TxtKmKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtKmKeyTyped
        char caracter = evt.getKeyChar();
        if (((caracter < '0') || (caracter > '9')) && (caracter != KeyEvent.VK_SPACE)
                && (caracter != '.')) {
            /* lo que deseo colocar aqui es si ya se pulso el caracter (.) el mismo no se pueda repetir*/
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingresar Solo Números");
        }
    }//GEN-LAST:event_TxtKmKeyTyped

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
            java.util.logging.Logger.getLogger(FrmAlta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAlta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAlta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAlta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAlta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregar;
    private javax.swing.JButton BtnAtras;
    private javax.swing.JTextField TxtAyno;
    private javax.swing.JTextField TxtDesExtra;
    private javax.swing.JTextField TxtKm;
    private javax.swing.JTextField TxtMarca;
    private javax.swing.JTextField TxtModelo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
