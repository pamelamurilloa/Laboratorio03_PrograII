package UserInterfaces;

import Bussiness.UserManager;
import Objects.User;


public class UserCRUD extends javax.swing.JDialog {

    private String notEnoughData = "Alguno de los datos no ha sido rellenado";
    private String wrongID = "La cedula debe de ir con numeros unicamente";
    private String alreadyExists = "Ya existe un usuario con ese numero de cedula";
    
    UserManager userManager = new UserManager();


    public UserCRUD(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        
        restart();
    }

    private void restart(){
        buttonF.setSelected(true);
        buttonF.setSelected(false);
        lblError.setVisible(false);
        lblSuccess.setVisible(false);
        inputUserID.setText("");
        inputName.setText("");
    }
    
    private boolean insertUser(int id) {
        char gender = 'F';
        if (buttonM.isSelected()) { gender = 'M'; }
        
        User newUser = new User(id, inputName.getText(), gender);
        boolean success = userManager.insertUser(newUser);
        return success;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupGender = new javax.swing.ButtonGroup();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btnConfirm = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblError = new javax.swing.JLabel();
        buttonM = new javax.swing.JRadioButton();
        buttonF = new javax.swing.JRadioButton();
        inputName = new javax.swing.JTextField();
        inputUserID = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        lblSuccess = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        Start = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(0, 148, 148));
        jPanel4.setForeground(new java.awt.Color(0, 51, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Impact", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(245, 245, 245));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("TICKET");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 150, 60));

        jLabel4.setFont(new java.awt.Font("Hiragino Mincho ProN", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(245, 245, 245));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("now");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 50, 30));

        jLabel5.setFont(new java.awt.Font("Hiragino Mincho ProN", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(245, 245, 245));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("my");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 50, 30));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 60));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 900, 10));

        jPanel1.setBackground(new java.awt.Color(240, 240, 240));
        jPanel1.setForeground(new java.awt.Color(240, 240, 240));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Hiragino Mincho ProN", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Insertar Usuarios");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 220, 30));

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 80));

        btnConfirm.setFont(new java.awt.Font("Hiragino Sans", 1, 24)); // NOI18N
        btnConfirm.setText("Confirmar");
        btnConfirm.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });
        jPanel3.add(btnConfirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 370, 170, 60));

        jLabel10.setFont(new java.awt.Font("Hiragino Sans", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Género:");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 130, 30));

        jLabel11.setFont(new java.awt.Font("Hiragino Sans", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Nombre:");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 130, 30));

        lblError.setFont(new java.awt.Font("Hiragino Sans", 1, 24)); // NOI18N
        lblError.setForeground(new java.awt.Color(204, 0, 0));
        lblError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblError.setText("Mensaje de error");
        jPanel3.add(lblError, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 900, 30));

        buttonGroupGender.add(buttonM);
        buttonM.setFont(new java.awt.Font("Hiragino Sans", 0, 18)); // NOI18N
        buttonM.setForeground(new java.awt.Color(0, 0, 0));
        buttonM.setText("M");
        jPanel3.add(buttonM, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 250, -1, -1));

        buttonGroupGender.add(buttonF);
        buttonF.setFont(new java.awt.Font("Hiragino Sans", 0, 18)); // NOI18N
        buttonF.setForeground(new java.awt.Color(0, 0, 0));
        buttonF.setText("F");
        jPanel3.add(buttonF, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, -1, -1));

        inputName.setBackground(new java.awt.Color(240, 240, 240));
        inputName.setFont(new java.awt.Font("Hiragino Sans", 0, 18)); // NOI18N
        inputName.setForeground(new java.awt.Color(0, 0, 0));
        inputName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        inputName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel3.add(inputName, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 190, 40));

        inputUserID.setBackground(new java.awt.Color(240, 240, 240));
        inputUserID.setFont(new java.awt.Font("Hiragino Sans", 0, 18)); // NOI18N
        inputUserID.setForeground(new java.awt.Color(0, 0, 0));
        inputUserID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        inputUserID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        inputUserID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                inputUserIDMousePressed(evt);
            }
        });
        jPanel3.add(inputUserID, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 190, 40));

        jLabel13.setFont(new java.awt.Font("Hiragino Sans", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Cédula:");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 130, 30));

        lblSuccess.setFont(new java.awt.Font("Hiragino Sans", 1, 36)); // NOI18N
        lblSuccess.setForeground(new java.awt.Color(0, 0, 0));
        lblSuccess.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSuccess.setText("Usuario insertado exitosamente");
        jPanel3.add(lblSuccess, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 670, 80));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 900, 460));

        jPanel2.setBackground(new java.awt.Color(0, 181, 181));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Kefa", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Pamela Murillo Anchia");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 10, 160, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, 900, 60));

        Start.setText("Inicio");
        Start.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StartMouseClicked(evt);
            }
        });
        menuBar.add(Start);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        int id = userManager.isNumeric(inputUserID.getText());
        if (id == -1){
            lblError.setVisible(true);
            lblError.setText(wrongID);

        } else {
            if (inputUserID.getText().equals("") || inputName.getText().equals("")) {
                lblError.setVisible(true);
                lblError.setText(notEnoughData);
            } else {
                boolean success = insertUser(id);
                if (success) {
                    lblSuccess.setVisible(true);
                } else {
                    lblError.setVisible(true);
                    lblError.setText(alreadyExists);
                }
            }
        }
        
    }//GEN-LAST:event_btnConfirmActionPerformed

    private void inputUserIDMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inputUserIDMousePressed
        restart();
    }//GEN-LAST:event_inputUserIDMousePressed

    private void StartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StartMouseClicked
        this.dispose();
    }//GEN-LAST:event_StartMouseClicked

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
            java.util.logging.Logger.getLogger(UserCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UserCRUD dialog = new UserCRUD(new javax.swing.JFrame(), true);
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
    private javax.swing.JMenu Start;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JRadioButton buttonF;
    private javax.swing.ButtonGroup buttonGroupGender;
    private javax.swing.JRadioButton buttonM;
    private javax.swing.JTextField inputName;
    private javax.swing.JTextField inputUserID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblSuccess;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables
}
