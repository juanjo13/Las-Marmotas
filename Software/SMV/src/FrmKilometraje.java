import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    double kmSF = 0;
    double kmN = 0;
    double kmA = 0;
    double kmC = 0;
    float kmi = 0;
    public FrmKilometraje(javax.swing.JDialog parent, boolean modal, int ID, float kmi) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
         txtid.setText(String.valueOf(ID));
         txtid.setVisible(false);
         this.kmi = (kmi);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        BtnAceptar = new javax.swing.JButton();
        TxtKilometraje = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        setBackground(new java.awt.Color(255, 255, 255));

        BtnAceptar.setBackground(new java.awt.Color(255, 255, 255));
        BtnAceptar.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        BtnAceptar.setForeground(new java.awt.Color(102, 0, 0));
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
        jLabel1.setText("REGISTRO KILOMETRAJE RECORRIDO");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BORDE.png"))); // NOI18N
        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(BtnAceptar)
                .addGap(115, 115, 115)
                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(TxtKilometraje, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TxtKilometraje, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtnAceptar, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>                        
    public void VerificarKilometraje(){
         try {
            BD mBD = new BD();
            vehiculo mV = new vehiculo();
            mBD.Conectar();
            mV.setIdentificador(Integer.valueOf(txtid.getText()));
            
            ResultSet resultA = mBD.ConskmAfinacion(mV);
            while(resultA.next()){
                kmA = resultA.getDouble(1);
            }
            
            ResultSet result = mBD.ConskmFrenos(mV);
            while(result.next()){
                kmSF = result.getDouble(1);
            }
            
            mV.setIdentificador(Integer.valueOf(txtid.getText()));
            ResultSet result1 = mBD.ConskmNeumaticos(mV);
            while(result1.next()){
                kmN = result1.getDouble(1);
            }
            
            ResultSet resultC = mBD.ConskmCarroceria(mV);
            while(resultC.next()){
                kmC = resultC.getDouble(1);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(FrmKilometraje.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void BtnAceptarActionPerformed(java.awt.event.ActionEvent evt) {                                           
             if (TxtKilometraje.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Llene el campo");
        } else {
              vehiculo mvehiculo = new vehiculo();
            mvehiculo.setKm_recorr(Float.valueOf(TxtKilometraje.getText()));
            mvehiculo.setIdentificador(Integer.valueOf(txtid.getText()));
            try {
                BD mBD = new BD();
                if (mBD.Conectar()) {
                    mBD.agregarKilometraje(mvehiculo);
                    VerificarKilometraje();   
                    
                    if(kmC >= 50000 && kmA >= 5000 && kmSF >= 10000 && kmN >= 10000) {
                        int n = JOptionPane.showConfirmDialog(rootPane, 
                                "Mantenimientos Necesarios:\n "
                                        + "*Carroceria\n "
                                        + "*Afinacion\n"
                                        + "*Suspension y Frenos\n"
                                        + "*Neumáticos\nDesea Realizarlo Ahora?",
                                "Aviso",JOptionPane.YES_NO_OPTION);
                        if (n == 0){
                            new FrmRegistroMantenimiento(this, true, 
                                    Integer.valueOf(txtid.getText()), 
                                    Float.valueOf(TxtKilometraje.getText()), kmi).setVisible(true);
                        }
                    }else if(kmC >= 50000 && kmA >= 5000 && kmSF >=10000) {
                        int n = JOptionPane.showConfirmDialog(rootPane, 
                                "Mantenimientos Necesarios:\n "
                                        + "*Carroceria\n "
                                        + "*Afinacion\n"
                                        + "*Suspension y Frenos\nRealizarlo Ahora?",
                                "Aviso",JOptionPane.YES_NO_OPTION);
                        if (n == 0){
                            new FrmRegistroMantenimiento(this, true, 
                                    Integer.valueOf(txtid.getText()), 
                                    Float.valueOf(TxtKilometraje.getText()), kmi).setVisible(true);
                        }
                    }else if(kmC >= 50000 && kmA >= 5000 && kmN >=10000) {
                        int n = JOptionPane.showConfirmDialog(rootPane, 
                                "Mantenimientos Necesarios:\n "
                                        + "*Carroceria\n "
                                        + "*Afinacion\n"
                                        + "*Neumaticos\nRealizarlo Ahora?",
                                "Aviso",JOptionPane.YES_NO_OPTION);
                        if (n == 0){
                            new FrmRegistroMantenimiento(this, true, 
                                    Integer.valueOf(txtid.getText()), 
                                    Float.valueOf(TxtKilometraje.getText()), kmi).setVisible(true);
                        }
                    }else if(kmC >= 50000 && kmN >= 10000 && kmSF >=10000) {
                        int n = JOptionPane.showConfirmDialog(rootPane, 
                                "Mantenimientos Necesarios:\n "
                                        + "*Carroceria\n "
                                        + "*Neumaticos\n"
                                        + "*Suspension y Frenos\nRealizarlo Ahora?",
                                "Aviso",JOptionPane.YES_NO_OPTION);
                        if (n == 0){
                            new FrmRegistroMantenimiento(this, true, 
                                    Integer.valueOf(txtid.getText()), 
                                    Float.valueOf(TxtKilometraje.getText()), kmi).setVisible(true);
                        }
                    }else if(kmN >= 10000 && kmA >= 5000 && kmSF >=10000) {
                        int n = JOptionPane.showConfirmDialog(rootPane, 
                                "Mantenimientos Necesarios:\n "
                                        + "*Neumaticos\n "
                                        + "*Afinacion\n"
                                        + "*Suspension y Frenos\nRealizarlo Ahora?",
                                "Aviso",JOptionPane.YES_NO_OPTION);
                        if (n == 0){
                            new FrmRegistroMantenimiento(this, true, 
                                    Integer.valueOf(txtid.getText()), 
                                    Float.valueOf(TxtKilometraje.getText()), kmi).setVisible(true);
                        }
                    }else if(kmC >= 50000 && kmA >= 5000 ) {
                        int n = JOptionPane.showConfirmDialog(rootPane, 
                                "Mantenimientos Necesarios:\n "
                                        + "*Carroceria\n "
                                        + "*Afinacion\nRealizarlo Ahora?",
                                "Aviso",JOptionPane.YES_NO_OPTION);
                        if (n == 0){
                            new FrmRegistroMantenimiento(this, true, 
                                    Integer.valueOf(txtid.getText()), 
                                    Float.valueOf(TxtKilometraje.getText()), kmi).setVisible(true);
                        }
                    }else if(kmSF >= 10000 && kmN >= 10000){
                        int n = JOptionPane.showConfirmDialog(rootPane, 
                                "Mantenimientos Necesarios:\n"
                                        +"*Suspension Y Frenos\n"
                                        +"*Neumaticos\nRealizarlos Ahora?",
                               "Aviso",JOptionPane.YES_NO_OPTION);
                      if (n == 0){
                          new FrmRegistroMantenimiento(this, true,Integer.valueOf(txtid.getText()),Float.valueOf(TxtKilometraje.getText()), kmi).setVisible(true);
                       }
                    }else if(kmSF >= 10000 && kmC >= 50000){
                        int n = JOptionPane.showConfirmDialog(rootPane, 
                                "Mantenimientos Necesarios:\n"
                                        +"*Suspension Y Frenos\n"
                                        +"*Carroceria\nRealizarlos Ahora?",
                               "Aviso",JOptionPane.YES_NO_OPTION);
                      if (n == 0){
                          new FrmRegistroMantenimiento(this, true,Integer.valueOf(txtid.getText()),Float.valueOf(TxtKilometraje.getText()), kmi).setVisible(true);
                       }
                    }else if(kmSF >= 10000 && kmA >= 5000){
                        int n = JOptionPane.showConfirmDialog(rootPane, 
                                "Mantenimientos Necesarios:\n"
                                        +"*Suspension Y Frenos\n"
                                        +"*Afinación\nRealizarlos Ahora?",
                               "Aviso",JOptionPane.YES_NO_OPTION);
                      if (n == 0){
                          new FrmRegistroMantenimiento(this, true,Integer.valueOf(txtid.getText()),Float.valueOf(TxtKilometraje.getText()), kmi).setVisible(true);
                       }
                    }else if(kmC >= 50000 && kmN >= 10000){
                        int n = JOptionPane.showConfirmDialog(rootPane, 
                                "Mantenimientos Necesarios:\n"
                                        +"*Carroceria\n"
                                        +"*Neumaticos\nRealizarlos Ahora?",
                               "Aviso",JOptionPane.YES_NO_OPTION);
                      if (n == 0){
                          new FrmRegistroMantenimiento(this, true,Integer.valueOf(txtid.getText()),Float.valueOf(TxtKilometraje.getText()), kmi).setVisible(true);
                       }
                    }else if(kmA >= 5000 && kmN >= 10000){
                        int n = JOptionPane.showConfirmDialog(rootPane, 
                                "Mantenimientos Necesarios:\n"
                                        +"*Afinación\n"
                                        +"*Neumaticos\nRealizarlos Ahora?",
                               "Aviso",JOptionPane.YES_NO_OPTION);
                      if (n == 0){
                          new FrmRegistroMantenimiento(this, true,Integer.valueOf(txtid.getText()),Float.valueOf(TxtKilometraje.getText()), kmi).setVisible(true);
                       }
                    }else if(kmSF >= 10000){
                       int n = JOptionPane.showConfirmDialog(rootPane, "Mantenimiento de Suspension Y Frenos Necesario\n"+
                               "Realizarlo Ahora?",
                               "Aviso",JOptionPane.YES_NO_OPTION);
                      if (n == 0){
                          new FrmRegistroMantenimiento(this, true,Integer.valueOf(txtid.getText()),Float.valueOf(TxtKilometraje.getText()), kmi).setVisible(true);
                       }
                    }else if(kmN >= 10000){
                       int n = JOptionPane.showConfirmDialog(rootPane, "Mantenimiento de Neumaticos Necesario\n"
                               +"Realizarlo Ahora?",
                               "Aviso",JOptionPane.YES_NO_OPTION);
                      if (n == 0){
                          new FrmRegistroMantenimiento(this, true,Integer.valueOf(txtid.getText()),Float.valueOf(TxtKilometraje.getText()), kmi).setVisible(true);
                       }
                    } else if(kmC >= 50000) {
                        int n = JOptionPane.showConfirmDialog(rootPane, 
                                "Mantenimiento de Carroceria Necesaria\nRealizarlo Ahora?",
                                "Aviso",JOptionPane.YES_NO_OPTION);
                        if (n == 0){
                            new FrmRegistroMantenimiento(this, true, 
                                    Integer.valueOf(txtid.getText()), 
                                    Float.valueOf(TxtKilometraje.getText()), kmi).setVisible(true);
                        }//condicion del comentario
                    } else if(kmA >= 5000) {
                        int n = JOptionPane.showConfirmDialog(rootPane, 
                                "Afinacion Necesaria\nRealizarlo Ahora?",
                                "Aviso",JOptionPane.YES_NO_OPTION);
                        if (n == 0){
                            new FrmRegistroMantenimiento(this, true, 
                                    Integer.valueOf(txtid.getText()), 
                                    Float.valueOf(TxtKilometraje.getText()), kmi).setVisible(true);
                        }
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Kilometraje recorrido");
                        this.setVisible(false);
                    }
                }

            } catch (Exception ex) {
                System.out.println(ex.toString());
                JOptionPane.showMessageDialog(rootPane, "Error");
            }
                this.setVisible(false);
             }
    }                                          

    private void BtnAceptarKeyPressed(java.awt.event.KeyEvent evt) {                                      
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
                    VerificarKilometraje();   
                    
                    if(kmC >= 50000 && kmA >= 5000 && kmSF >= 10000 && kmN >= 10000) {
                        int n = JOptionPane.showConfirmDialog(rootPane, 
                                "Mantenimientos Necesarios:\n "
                                        + "*Carroceria\n "
                                        + "*Afinacion\n"
                                        + "*Suspension y Frenos\n"
                                        + "*Neumáticos\nDesea Realizarlo Ahora?",
                                "Aviso",JOptionPane.YES_NO_OPTION);
                        if (n == 0){
                            new FrmRegistroMantenimiento(this, true, 
                                    Integer.valueOf(txtid.getText()), 
                                    Float.valueOf(TxtKilometraje.getText()), kmi).setVisible(true);
                        }
                    }else if(kmC >= 50000 && kmA >= 5000 && kmSF >=10000) {
                        int n = JOptionPane.showConfirmDialog(rootPane, 
                                "Mantenimientos Necesarios:\n "
                                        + "*Carroceria\n "
                                        + "*Afinacion\n"
                                        + "*Suspension y Frenos\nRealizarlo Ahora?",
                                "Aviso",JOptionPane.YES_NO_OPTION);
                        if (n == 0){
                            new FrmRegistroMantenimiento(this, true, 
                                    Integer.valueOf(txtid.getText()), 
                                    Float.valueOf(TxtKilometraje.getText()), kmi).setVisible(true);
                        }
                    }else if(kmC >= 50000 && kmA >= 5000 && kmN >=10000) {
                        int n = JOptionPane.showConfirmDialog(rootPane, 
                                "Mantenimientos Necesarios:\n "
                                        + "*Carroceria\n "
                                        + "*Afinacion\n"
                                        + "*Neumaticos\nRealizarlo Ahora?",
                                "Aviso",JOptionPane.YES_NO_OPTION);
                        if (n == 0){
                            new FrmRegistroMantenimiento(this, true, 
                                    Integer.valueOf(txtid.getText()), 
                                    Float.valueOf(TxtKilometraje.getText()), kmi).setVisible(true);
                        }
                    }else if(kmC >= 50000 && kmN >= 10000 && kmSF >=10000) {
                        int n = JOptionPane.showConfirmDialog(rootPane, 
                                "Mantenimientos Necesarios:\n "
                                        + "*Carroceria\n "
                                        + "*Neumaticos\n"
                                        + "*Suspension y Frenos\nRealizarlo Ahora?",
                                "Aviso",JOptionPane.YES_NO_OPTION);
                        if (n == 0){
                            new FrmRegistroMantenimiento(this, true, 
                                    Integer.valueOf(txtid.getText()), 
                                    Float.valueOf(TxtKilometraje.getText()), kmi).setVisible(true);
                        }
                    }else if(kmN >= 10000 && kmA >= 5000 && kmSF >=10000) {
                        int n = JOptionPane.showConfirmDialog(rootPane, 
                                "Mantenimientos Necesarios:\n "
                                        + "*Neumaticos\n "
                                        + "*Afinacion\n"
                                        + "*Suspension y Frenos\nRealizarlo Ahora?",
                                "Aviso",JOptionPane.YES_NO_OPTION);
                        if (n == 0){
                            new FrmRegistroMantenimiento(this, true, 
                                    Integer.valueOf(txtid.getText()), 
                                    Float.valueOf(TxtKilometraje.getText()), kmi).setVisible(true);
                        }
                    }else if(kmC >= 50000 && kmA >= 5000 ) {
                        int n = JOptionPane.showConfirmDialog(rootPane, 
                                "Mantenimientos Necesarios:\n "
                                        + "*Carroceria\n "
                                        + "*Afinacion\nRealizarlo Ahora?",
                                "Aviso",JOptionPane.YES_NO_OPTION);
                        if (n == 0){
                            new FrmRegistroMantenimiento(this, true, 
                                    Integer.valueOf(txtid.getText()), 
                                    Float.valueOf(TxtKilometraje.getText()), kmi).setVisible(true);
                        }
                    }else if(kmSF >= 10000 && kmN >= 10000){
                        int n = JOptionPane.showConfirmDialog(rootPane, 
                                "Mantenimientos Necesarios:\n"
                                        +"*Suspension Y Frenos\n"
                                        +"*Neumaticos\nRealizarlos Ahora?",
                               "Aviso",JOptionPane.YES_NO_OPTION);
                      if (n == 0){
                          new FrmRegistroMantenimiento(this, true,Integer.valueOf(txtid.getText()),Float.valueOf(TxtKilometraje.getText()), kmi).setVisible(true);
                       }
                    }else if(kmSF >= 10000 && kmC >= 50000){
                        int n = JOptionPane.showConfirmDialog(rootPane, 
                                "Mantenimientos Necesarios:\n"
                                        +"*Suspension Y Frenos\n"
                                        +"*Carroceria\nRealizarlos Ahora?",
                               "Aviso",JOptionPane.YES_NO_OPTION);
                      if (n == 0){
                          new FrmRegistroMantenimiento(this, true,Integer.valueOf(txtid.getText()),Float.valueOf(TxtKilometraje.getText()), kmi).setVisible(true);
                       }
                    }else if(kmSF >= 10000 && kmA >= 5000){
                        int n = JOptionPane.showConfirmDialog(rootPane, 
                                "Mantenimientos Necesarios:\n"
                                        +"*Suspension Y Frenos\n"
                                        +"*Afinación\nRealizarlos Ahora?",
                               "Aviso",JOptionPane.YES_NO_OPTION);
                      if (n == 0){
                          new FrmRegistroMantenimiento(this, true,Integer.valueOf(txtid.getText()),Float.valueOf(TxtKilometraje.getText()), kmi).setVisible(true);
                       }
                    }else if(kmC >= 50000 && kmN >= 10000){
                        int n = JOptionPane.showConfirmDialog(rootPane, 
                                "Mantenimientos Necesarios:\n"
                                        +"*Carroceria\n"
                                        +"*Neumaticos\nRealizarlos Ahora?",
                               "Aviso",JOptionPane.YES_NO_OPTION);
                      if (n == 0){
                          new FrmRegistroMantenimiento(this, true,Integer.valueOf(txtid.getText()),Float.valueOf(TxtKilometraje.getText()), kmi).setVisible(true);
                       }
                    }else if(kmA >= 5000 && kmN >= 10000){
                        int n = JOptionPane.showConfirmDialog(rootPane, 
                                "Mantenimientos Necesarios:\n"
                                        +"*Afinación\n"
                                        +"*Neumaticos\nRealizarlos Ahora?",
                               "Aviso",JOptionPane.YES_NO_OPTION);
                      if (n == 0){
                          new FrmRegistroMantenimiento(this, true,Integer.valueOf(txtid.getText()),Float.valueOf(TxtKilometraje.getText()), kmi).setVisible(true);
                       }
                    }else if(kmSF >= 10000){
                       int n = JOptionPane.showConfirmDialog(rootPane, "Mantenimiento de Suspension Y Frenos Necesario\n"+
                               "Realizarlo Ahora?",
                               "Aviso",JOptionPane.YES_NO_OPTION);
                      if (n == 0){
                          new FrmRegistroMantenimiento(this, true,Integer.valueOf(txtid.getText()),Float.valueOf(TxtKilometraje.getText()), kmi).setVisible(true);
                       }
                    }else if(kmN >= 10000){
                       int n = JOptionPane.showConfirmDialog(rootPane, "Mantenimiento de Neumaticos Necesario\n"
                               +"Realizarlo Ahora?",
                               "Aviso",JOptionPane.YES_NO_OPTION);
                      if (n == 0){
                          new FrmRegistroMantenimiento(this, true,Integer.valueOf(txtid.getText()),Float.valueOf(TxtKilometraje.getText()), kmi).setVisible(true);
                       }
                    } else if(kmC >= 50000) {
                        int n = JOptionPane.showConfirmDialog(rootPane, 
                                "Mantenimiento de Carroceria Necesaria\nRealizarlo Ahora?",
                                "Aviso",JOptionPane.YES_NO_OPTION);
                        if (n == 0){
                            new FrmRegistroMantenimiento(this, true, 
                                    Integer.valueOf(txtid.getText()), 
                                    Float.valueOf(TxtKilometraje.getText()), kmi).setVisible(true);
                        }//condicion del comentario
                    } else if(kmA >= 5000) {
                        int n = JOptionPane.showConfirmDialog(rootPane, 
                                "Afinacion Necesaria\nRealizarlo Ahora?",
                                "Aviso",JOptionPane.YES_NO_OPTION);
                        if (n == 0){
                            new FrmRegistroMantenimiento(this, true, 
                                    Integer.valueOf(txtid.getText()), 
                                    Float.valueOf(TxtKilometraje.getText()), kmi).setVisible(true);
                        }
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Kilometraje recorrido");
                        this.setVisible(false);
                    }
                }

            } catch (Exception ex) {
                System.out.println(ex.toString());
                JOptionPane.showMessageDialog(rootPane, "Error");
            }
                this.setVisible(false);
             }
          }
          
    }                                     

    private void TxtKilometrajeKeyTyped(java.awt.event.KeyEvent evt) {                                        
         char caracter = evt.getKeyChar();
        if (((caracter < '0') || (caracter > '9')) && (caracter != KeyEvent.VK_BACK_SPACE)
            && (caracter != '.')) {
            /* lo que deseo colocar aqui es si ya se pulso el caracter (.) el mismo no se pueda repetir*/
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingresar Solo Números");
        }
    }                                       

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {                                       
       
    }                                      

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
                float kmi = 0;
                FrmKilometraje dialog = new FrmKilometraje(new javax.swing.JDialog(), true, dato, kmi );
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

    // Variables declaration - do not modify                     
    private javax.swing.JButton BtnAceptar;
    private javax.swing.JTextField TxtKilometraje;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtid;
    // End of variables declaration                   
}
