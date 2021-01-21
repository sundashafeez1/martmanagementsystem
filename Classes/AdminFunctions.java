/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Forms.LoginAdmin;
import Forms.Admin;
import javax.swing.JOptionPane;

/**
 *
 * @author Farhan
 */
public class AdminFunctions {
    
     DBconn conn = new DBconn();
    LoginAdmin loginAdmin = null;
    
  
    
    public void setAdminFunctions(LoginAdmin loginAdmin2){
      loginAdmin = loginAdmin2;
    }
        
    public void adminLoginCheck(){
        conn.con = null;
        conn.rs = null;
        conn.pst = null;
        conn.stm = null;
        conn.Connect();
        String query = "Select adminid, adminpassword FROM admin WHERE adminid='"+loginAdmin.adminIdField.getSelectedItem()+"' AND adminpassword='"+loginAdmin.adminPasswordField.getText()+"' ";
        try {
            conn.pst = conn.con.prepareStatement(query);
            conn.rs = conn.pst.executeQuery();
            if(conn.rs.next()){
                /*String userAdmin = adminIdField.getSelectedItem().toString();
                Admin admin = new Admin();
                admin.usernameAdmin(userAdmin);*/
                String userAdmin = loginAdmin.adminIdField.getSelectedItem().toString();
                Admin admin = new Admin();
                admin.usernameAdmin(userAdmin);
                admin.setVisible(true);
                loginAdmin.dispose();
            }
            else{
                JOptionPane.showMessageDialog(null, "Please enter valid ID and Password");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error in Login");
        }
    }
    
    public void populateAdminId(){
        conn.con = null;
        conn.rs = null;
        conn.pst = null;
        conn.stm = null;
        conn.Connect();
        try {
            conn.stm = conn.con.createStatement();
            String s = "select adminid from admin";
            conn.rs = conn.stm.executeQuery(s);
            while(conn.rs.next()){
                loginAdmin.adminIdField.addItem(conn.rs.getString(1));
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error in Retrieving");
        }
    }

    
}


















