/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import Classes.AdminFunctions;
import java.awt.event.KeyEvent;
/**
 *
 * @author Farhan
 */
public class LoginAdmin extends javax.swing.JFrame {
    AdminFunctions adminFunctions = new AdminFunctions();
    
    /**
     * Creates new form LoginAdmin
     */
    public LoginAdmin() {
        this.setResizable(false);
        adminFunctions.setAdminFunctions(this);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        back = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        adminPasswordField = new javax.swing.JPasswordField();
        login = new javax.swing.JButton();
        adminIdField = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login Admin");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(82, 91, 86));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(19, 34, 38));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(82, 91, 86));
        jLabel1.setFont(new java.awt.Font("Century Gothic", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Login Admin");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 160, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Admin_100px.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 100, 100));

        jSeparator3.setForeground(new java.awt.Color(240, 240, 240));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, 100, 10));

        jSeparator5.setForeground(new java.awt.Color(240, 240, 240));
        jPanel2.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 80, 10));

        back.setBackground(new java.awt.Color(153, 153, 153));
        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Undo_32px.png"))); // NOI18N
        back.setBorder(null);
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        back.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                backKeyPressed(evt);
            }
        });
        jPanel2.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 40, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 470));

        jLabel5.setBackground(new java.awt.Color(82, 91, 86));
        jLabel5.setFont(new java.awt.Font("Century Gothic", 2, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Please enter your details:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 310, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ID");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, -1, 30));

        jSeparator4.setForeground(new java.awt.Color(240, 240, 240));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 220, 290, 10));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 250, -1, 30));

        jSeparator2.setForeground(new java.awt.Color(240, 240, 240));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 320, 290, 10));

        adminPasswordField.setBackground(new java.awt.Color(82, 91, 86));
        adminPasswordField.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        adminPasswordField.setForeground(new java.awt.Color(255, 255, 255));
        adminPasswordField.setText("123");
        adminPasswordField.setBorder(null);
        adminPasswordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                adminPasswordFieldFocusGained(evt);
            }
        });
        adminPasswordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                adminPasswordFieldKeyPressed(evt);
            }
        });
        jPanel1.add(adminPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 290, 290, 30));

        login.setBackground(new java.awt.Color(153, 153, 153));
        login.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        login.setForeground(new java.awt.Color(51, 51, 51));
        login.setText("Login");
        login.setBorder(null);
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        login.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                loginKeyPressed(evt);
            }
        });
        jPanel1.add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 380, 110, 40));

        adminIdField.setBackground(new java.awt.Color(82, 91, 86));
        adminIdField.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        adminIdField.setForeground(new java.awt.Color(82, 91, 86));
        adminIdField.setBorder(null);
        adminIdField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                adminIdFieldFocusGained(evt);
            }
        });
        jPanel1.add(adminIdField, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, 290, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void adminPasswordFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_adminPasswordFieldFocusGained
        adminPasswordField.setText("");
    }//GEN-LAST:event_adminPasswordFieldFocusGained

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        adminFunctions.adminLoginCheck();
    }//GEN-LAST:event_loginActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        Welcome welcome = new Welcome();
        welcome.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backActionPerformed

    private void backKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_backKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_ESCAPE ){
            Welcome welcome = new Welcome();
            welcome.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_backKeyPressed

    private void adminPasswordFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_adminPasswordFieldKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            adminFunctions.adminLoginCheck();
        }
    }//GEN-LAST:event_adminPasswordFieldKeyPressed

    private void loginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loginKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            adminFunctions.adminLoginCheck();
        }
    }//GEN-LAST:event_loginKeyPressed

    private void adminIdFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_adminIdFieldFocusGained
        adminFunctions.populateAdminId();
    }//GEN-LAST:event_adminIdFieldFocusGained

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
            java.util.logging.Logger.getLogger(LoginAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<String> adminIdField;
    public javax.swing.JPasswordField adminPasswordField;
    private javax.swing.JButton back;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JButton login;
    // End of variables declaration//GEN-END:variables
}
