
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author aide
 */
public class FrmConsulta extends javax.swing.JDialog {
//aumentar el combustible si se ha recorrido y si se dimunuye restar al total pero registrar tambien en el combustible gastado

    /**
     * Creates new form FrmConsulta
     */
    public FrmConsulta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        lblid.setVisible(false);
        lblc.setVisible(false); 
    }
    //   int ID=0;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JtVehiculos = new javax.swing.JTable();
        CBMarca = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        CBModelo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        CMBAnyo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        BtnBuscar = new javax.swing.JButton();
        BtnModificar = new javax.swing.JButton();
        BtnKilometraje = new javax.swing.JButton();
        BtnRegresar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        BtnCombustible = new javax.swing.JButton();
        lblid = new javax.swing.JLabel();
        lblc = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jLabel2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jLabel2FocusGained(evt);
            }
        });

        JtVehiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "MARCA", "MODELO", "AÑO", "KILOMETRAJE INICIAL", "KILOMETRAJE RECORIDO", "COMBUSTIBLE ", "DESC EXTRA"
            }
        ));
        JtVehiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JtVehiculosMouseClicked(evt);
            }
        });
        JtVehiculos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JtVehiculosKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(JtVehiculos);

        CBMarca.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N

        CBMarca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Marca" }));
        CBMarca.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CBMarcaItemStateChanged(evt);
            }
        });
        CBMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBMarcaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel1.setText("BÚSQUEDA");

        jLabel3.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel3.setText("MARCA");


        CBModelo.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N

        CBModelo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Modelo" }));

        jLabel4.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel4.setText("MODELO");


        CMBAnyo.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N

        CMBAnyo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Año" }));

        jLabel5.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel5.setText("AÑO");

        BtnBuscar.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        BtnBuscar.setText("BUSCAR");
        BtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarActionPerformed(evt);
            }
        });

        BtnModificar.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        BtnModificar.setText("MODIFICAR");
        BtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarActionPerformed(evt);
            }
        });
        BtnModificar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnModificarKeyPressed(evt);
            }
        });

        BtnKilometraje.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        BtnKilometraje.setText("REGISTRAR KILOMETRAJE");
        BtnKilometraje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnKilometrajeActionPerformed(evt);
            }
        });
        BtnKilometraje.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnKilometrajeKeyPressed(evt);
            }
        });

        BtnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/regresa_1.png"))); // NOI18N
        BtnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegresarActionPerformed(evt);
            }
        });
        BtnRegresar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnRegresarKeyPressed(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo b.png"))); // NOI18N
        jLabel8.setText("jLabel8");

        BtnCombustible.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        BtnCombustible.setText("COMBUSTIBLE");
        BtnCombustible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCombustibleActionPerformed(evt);
            }
        });
        BtnCombustible.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnCombustibleKeyPressed(evt);
            }
        });

        lblid.setText("id");

        lblc.setText("combustible");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addComponent(jLabel3)
                                        .addGap(68, 68, 68)
                                        .addComponent(jLabel4))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(CBMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(CBModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(33, 33, 33)
                                        .addComponent(CMBAnyo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(53, 53, 53)
                                        .addComponent(BtnBuscar)
                                        .addGap(18, 18, 18)
                                        .addComponent(BtnKilometraje)
                                        .addGap(30, 30, 30)
                                        .addComponent(BtnCombustible)
                                        .addGap(18, 18, 18)
                                        .addComponent(BtnModificar))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(479, 479, 479)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(721, 721, 721)
                .addComponent(lblid)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblid, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblc, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 37, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(CBMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CBModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CMBAnyo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BtnBuscar)
                                    .addComponent(BtnKilometraje)
                                    .addComponent(BtnCombustible)
                                    .addComponent(BtnModificar)))
                            .addComponent(BtnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 22, Short.MAX_VALUE)))
                .addGap(56, 56, 56)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnKilometrajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnKilometrajeActionPerformed
        //    new (this,true).setVisible(true);
  //      new FrmKilometraje(this, true).setVisible(true);

    }//GEN-LAST:event_BtnKilometrajeActionPerformed

    private void BtnRegresarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnRegresarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.setVisible(false);

        }
    }//GEN-LAST:event_BtnRegresarKeyPressed

    private void BtnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegresarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_BtnRegresarActionPerformed

    private void BtnKilometrajeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnKilometrajeKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
          //  new FrmKilometraje(this, true).setVisible(true);
        }
    }//GEN-LAST:event_BtnKilometrajeKeyPressed

    private void BtnCombustibleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnCombustibleKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String id = lblid.getText();
        int dato = Integer.valueOf(id);
        String c = lblc.getText();
        float co = Float.valueOf(c);
            new FrmCombustible(this, true, dato, co).setVisible(true);
            lblid.setText("");

        }
    }//GEN-LAST:event_BtnCombustibleKeyPressed

    private void BtnCombustibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCombustibleActionPerformed
        String id = lblid.getText();
        int dato = Integer.valueOf(id);
        String c = lblc.getText();
        float co = Float.valueOf(c);
        new FrmCombustible(this, true, dato, co).setVisible(true);

        lblid.setText("");

// TODO add your handling code here:
    }//GEN-LAST:event_BtnCombustibleActionPerformed

    private void jLabel2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jLabel2FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2FocusGained
    public void llenarCmb_Marca(){
        try {
            BD mBD = new BD();
            mBD.Conectar();
            ResultSet resultado = mBD.ConsultarMarcas();
            CBMarca.removeAllItems();
            CBMarca.addItem("Marca");
            while(resultado.next()){
                CBMarca.addItem(resultado.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrmConsulta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(FrmConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void llenarCmb_Modelo(){
        try {
            BD mBD = new BD();
            mBD.Conectar();
            ResultSet resultado = mBD.ConsultarModelos();
            CBModelo.removeAllItems();
            CBModelo.addItem("Modelo");
            while(resultado.next()){
                CBModelo.addItem(resultado.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrmConsulta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(FrmConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void llenarCmb_Anio(){
        try {
            BD mBD = new BD();
            mBD.Conectar();
            ResultSet resultado = mBD.ConsultarAnios();
            CMBAnyo.removeAllItems();
            CMBAnyo.addItem("Año");
            while(resultado.next()){
                CMBAnyo.addItem(resultado.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrmConsulta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(FrmConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void LLenarTabla(List<vehiculo> ListaVehiculos){
        if(ListaVehiculos != null){
            Object[] encabezado = {"ID", "Marca", "Modelo", "Año", "Km Actual",
                "Km Recorrido", "Combustible", "Desc Extra"};
            DefaultTableModel modelo = new DefaultTableModel(null, encabezado);
            for (vehiculo mvehiculo : ListaVehiculos) {
                Object[] fila = {mvehiculo.getIdentificador(), mvehiculo.getMarca(), mvehiculo.getModelo(), mvehiculo.getAnio(),
                    mvehiculo.getKm_actual(), mvehiculo.getKm_recorr(), mvehiculo.getComb_actual(), mvehiculo.getDesc_Extra()};
                modelo.addRow(fila);
            }
            JtVehiculos.setModel(modelo);
        }
    }
    
    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        // TODO add your handling code here:
        try {
            BD mBD = new BD();
            mBD.Conectar();
            List<vehiculo> ListaVehiculos = mBD.ConsultaGeneral();
            LLenarTabla(ListaVehiculos);
            llenarCmb_Marca();
            llenarCmb_Modelo();
            llenarCmb_Anio();
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_formWindowGainedFocus


    private void CBMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CBMarcaActionPerformed

    private void CBMarcaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CBMarcaItemStateChanged

    }//GEN-LAST:event_CBMarcaItemStateChanged

    private void BtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarActionPerformed
        try {
            BD mBD = new BD();
            mBD.Conectar();
            
            vehiculo mvehiculo = new vehiculo();
            List<vehiculo> ListaVehiculos = null;
            //Buscar por Marca
            if (CBMarca.getSelectedItem().toString() != "Marca" & CBModelo.getSelectedItem().toString() == "Modelo"
                    & CMBAnyo.getSelectedItem().toString() == "Año") {

                mvehiculo.setMarca(CBMarca.getSelectedItem().toString());
                ListaVehiculos = mBD.ConsultaPorMarca(mvehiculo);
                
             //Buscar por Modelo
            }else if(CBMarca.getSelectedItem().toString() == "Marca" & CBModelo.getSelectedItem().toString() != "Modelo"
                    & CMBAnyo.getSelectedItem().toString() == "Año"){
                
                mvehiculo.setModelo(CBModelo.getSelectedItem().toString());
                ListaVehiculos = mBD.ConsultaPorModelo(mvehiculo);
            //Buscar por Año    
            }else if(CBMarca.getSelectedItem().toString() == "Marca" & CBModelo.getSelectedItem().toString() == "Modelo"
                    & CMBAnyo.getSelectedItem().toString() != "Año"){
                
                mvehiculo.setAnio(Integer.parseInt(CMBAnyo.getSelectedItem().toString()));
                ListaVehiculos = mBD.ConsultaPorAnio(mvehiculo);
              
            //Buscar por Marca, Modelo Y Año.    
            }else if(CBMarca.getSelectedItem().toString() != "Marca" & CBModelo.getSelectedItem().toString() != "Modelo"
                    & CMBAnyo.getSelectedItem().toString() != "Año"){
                
                mvehiculo.setMarca(CBMarca.getSelectedItem().toString());
                mvehiculo.setModelo(CBModelo.getSelectedItem().toString());
                mvehiculo.setAnio(Integer.parseInt(CMBAnyo.getSelectedItem().toString()));
                ListaVehiculos = mBD.ConsultaMixta(mvehiculo);
            
            //Buscar Por Marca y Modelo
            }else if(CBMarca.getSelectedItem().toString() != "Marca" & CBModelo.getSelectedItem().toString() != "Modelo"
                    & CMBAnyo.getSelectedItem().toString() == "Año"){
                
                mvehiculo.setMarca(CBMarca.getSelectedItem().toString());
                mvehiculo.setModelo(CBModelo.getSelectedItem().toString());
                ListaVehiculos = mBD.ConsultaMarcaModelo(mvehiculo);
                
            //Buscar Marca y Año
            }else if(CBMarca.getSelectedItem().toString() != "Marca" & CBModelo.getSelectedItem().toString() == "Modelo"
                    & CMBAnyo.getSelectedItem().toString() != "Año"){
                
                mvehiculo.setMarca(CBMarca.getSelectedItem().toString());
                mvehiculo.setAnio(Integer.parseInt(CMBAnyo.getSelectedItem().toString()));
                ListaVehiculos = mBD.ConsultaMarcaAnio(mvehiculo);
                
            //Buscar Modelo y Año
            }else if(CBMarca.getSelectedItem().toString() == "Marca" & CBModelo.getSelectedItem().toString() != "Modelo"
                    & CMBAnyo.getSelectedItem().toString() != "Año"){
                
                mvehiculo.setModelo(CBModelo.getSelectedItem().toString());
                mvehiculo.setAnio(Integer.parseInt(CMBAnyo.getSelectedItem().toString()));
                ListaVehiculos = mBD.ConsultaModeloAnio(mvehiculo);
                
            }else {
                JOptionPane.showMessageDialog(rootPane, "No se encontro el vehículo");
            }
            
            if(ListaVehiculos == null || ListaVehiculos.size() > 0){
                LLenarTabla(ListaVehiculos);
            }else{
                JOptionPane.showMessageDialog(rootPane, "No se encontro el vehículo");
            }

        } catch (Exception ex) {
            Logger.getLogger(FrmConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtnBuscarActionPerformed

    private void JtVehiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtVehiculosMouseClicked
        try {
            //identificar el ID del  productor a modificar
            int fila = JtVehiculos.getSelectedRow();
            if (fila >= 0) {
                int ID = (int) JtVehiculos.getValueAt(fila, 0);

                lblid.setText(String.valueOf(ID));
                float Co = (float) JtVehiculos.getValueAt(fila, 6);
                lblc.setText(String.valueOf(Co));
            }

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_JtVehiculosMouseClicked

    private void JtVehiculosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtVehiculosKeyReleased
        try {
            //identificar el ID del  productor a modificar
            int fila = JtVehiculos.getSelectedRow();
            if (fila >= 0) {
                int ID = (int) JtVehiculos.getValueAt(fila, 0);

                lblid.setText(String.valueOf(ID));
                float Co = (float) JtVehiculos.getValueAt(fila, 6);
                lblc.setText(String.valueOf(Co));
                // JOptionPane.showMessageDialog(this, "ID SELECCIONADO"+ID);
            }

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_JtVehiculosKeyReleased

    private void BtnModificarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnModificarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnModificarKeyPressed

    private void BtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarActionPerformed
        try{
            int fila = JtVehiculos.getSelectedRow();
            if (fila >= 0){
                int ID = (int) JtVehiculos.getValueAt(fila, 0);
                String Marc = JtVehiculos.getValueAt(fila, 1).toString();
                String Mod = JtVehiculos.getValueAt(fila, 2).toString();
                String A = JtVehiculos.getValueAt(fila, 3).toString();
                String Desc = JtVehiculos.getValueAt(fila, 7).toString();                
                new FrmModificar(this,true, ID, Marc, Mod, A, Desc).setVisible(true);
            }            
        }catch (Exception ex) {
            System.out.println(ex.toString());
        }        
    }//GEN-LAST:event_BtnModificarActionPerformed


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
            java.util.logging.Logger.getLogger(FrmConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmConsulta dialog = new FrmConsulta(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton BtnBuscar;
    private javax.swing.JButton BtnCombustible;
    private javax.swing.JButton BtnKilometraje;
    private javax.swing.JButton BtnModificar;
    private javax.swing.JButton BtnRegresar;
    private javax.swing.JComboBox<String> CBMarca;
    private javax.swing.JComboBox<String> CBModelo;
    private javax.swing.JComboBox<String> CMBAnyo;
    private javax.swing.JTable JtVehiculos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblc;
    private javax.swing.JLabel lblid;
    // End of variables declaration//GEN-END:variables
}
