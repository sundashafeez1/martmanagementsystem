/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import java.awt.event.KeyEvent;

/**
 *
 * @author Farhan
 */
public class ProductOperations extends javax.swing.JFrame {

    /**
     * Creates new form ProductOperations
     */
    public ProductOperations() {
        this.setResizable(false);
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
        jLabel2 = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        addProduct = new javax.swing.JButton();
        deleteProduct = new javax.swing.JButton();
        viewProduct = new javax.swing.JButton();
        searchUpdate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Product Operations");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(82, 91, 86));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(19, 34, 38));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(82, 91, 86));
        jLabel2.setFont(new java.awt.Font("Century Gothic", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Product...");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 120, 40));

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
        jPanel2.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 40, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Product_100px.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 120));

        addProduct.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        addProduct.setForeground(new java.awt.Color(19, 34, 38));
        addProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Add_100px.png"))); // NOI18N
        addProduct.setText("Add");
        addProduct.setBorder(null);
        addProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProductActionPerformed(evt);
            }
        });
        addProduct.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                addProductKeyPressed(evt);
            }
        });
        jPanel1.add(addProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 210, 120));

        deleteProduct.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        deleteProduct.setForeground(new java.awt.Color(19, 34, 38));
        deleteProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Delete_100px.png"))); // NOI18N
        deleteProduct.setText("Delete");
        deleteProduct.setBorder(null);
        deleteProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteProductActionPerformed(evt);
            }
        });
        deleteProduct.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                deleteProductKeyPressed(evt);
            }
        });
        jPanel1.add(deleteProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, 210, 120));

        viewProduct.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        viewProduct.setForeground(new java.awt.Color(19, 34, 38));
        viewProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/View_100px.png"))); // NOI18N
        viewProduct.setText("View");
        viewProduct.setBorder(null);
        viewProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewProductActionPerformed(evt);
            }
        });
        viewProduct.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                viewProductKeyPressed(evt);
            }
        });
        jPanel1.add(viewProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 210, 120));

        searchUpdate.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        searchUpdate.setForeground(new java.awt.Color(19, 34, 38));
        searchUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Search_and_Update_100px.png"))); // NOI18N
        searchUpdate.setText("Search Update");
        searchUpdate.setBorder(null);
        searchUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchUpdateActionPerformed(evt);
            }
        });
        searchUpdate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchUpdateKeyPressed(evt);
            }
        });
        jPanel1.add(searchUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 290, 210, 120));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        Admin admin = new Admin();
        admin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backActionPerformed

    private void backKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_backKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_ESCAPE ){
            Admin admin = new Admin();
        admin.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_backKeyPressed

    private void addProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProductActionPerformed
        AddProduct AddProduct = new AddProduct();
            AddProduct.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_addProductActionPerformed

    private void addProductKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addProductKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            AddProduct AddProduct = new AddProduct();
            AddProduct.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_addProductKeyPressed

    private void deleteProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteProductActionPerformed
        DeleteProduct DeleteProduct = new DeleteProduct();
        DeleteProduct.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_deleteProductActionPerformed

    private void deleteProductKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_deleteProductKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            DeleteProduct DeleteProduct = new DeleteProduct();
        DeleteProduct.setVisible(true);
        this.dispose();
        }
    }//GEN-LAST:event_deleteProductKeyPressed

    private void viewProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewProductActionPerformed
        ViewProduct ViewProduct = new ViewProduct();
        ViewProduct.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_viewProductActionPerformed

    private void viewProductKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_viewProductKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            ViewProduct ViewProduct = new ViewProduct();
        ViewProduct.setVisible(true);
        this.dispose();
        }
    }//GEN-LAST:event_viewProductKeyPressed

    private void searchUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchUpdateActionPerformed
        SearchUpdateProduct searchAndUpdate = new SearchUpdateProduct();
        searchAndUpdate.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_searchUpdateActionPerformed

    private void searchUpdateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchUpdateKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        SearchUpdateProduct searchAndUpdate = new SearchUpdateProduct();
        searchAndUpdate.setVisible(true);
        this.dispose();
        }
    }//GEN-LAST:event_searchUpdateKeyPressed

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
            java.util.logging.Logger.getLogger(ProductOperations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductOperations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductOperations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductOperations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductOperations().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addProduct;
    private javax.swing.JButton back;
    private javax.swing.JButton deleteProduct;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton searchUpdate;
    private javax.swing.JButton viewProduct;
    // End of variables declaration//GEN-END:variables
}
