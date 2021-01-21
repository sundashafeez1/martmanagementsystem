/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Forms.LoginCashier;
import Forms.Cashier;
import Forms.AddCashier;
import Forms.DeleteCashier;
import Forms.ViewCashier;
import Forms.SearchUpdateCashier;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.sql.*;

public class CashierFunctions {
    
    DBconn conn = new DBconn();
    LoginCashier loginCashier = null;
    AddCashier addCashier = null;
    DeleteCashier deleteCashier = null;
    ViewCashier viewCashier = null;
    SearchUpdateCashier searchUpdateCashier = null;
    
    public void setCashierFunctions(LoginCashier loginCashier2, AddCashier addCashier2, DeleteCashier deleteCashier2, ViewCashier viewCashier2, SearchUpdateCashier searchUpdateCashier2){
      loginCashier = loginCashier2;
      addCashier = addCashier2;
      deleteCashier = deleteCashier2;
      viewCashier = viewCashier2;
      searchUpdateCashier = searchUpdateCashier2;
    }
    
    public void cashierLoginCheck(){
        
        conn.rs = null;
        conn.pst = null;
        conn.stm = null;
        conn.Connect();
        String query = "Select cashierid, cashierpassword FROM cashier WHERE cashierid='"+loginCashier.cashierIdField.getSelectedItem()+"' AND cashierpassword='"+loginCashier.cashierPasswordField.getText()+"' ";
        try {
            conn.pst = conn.con.prepareStatement(query);
            conn.rs = conn.pst.executeQuery();
            if(conn.rs.next()){
                String userCashier = loginCashier.cashierIdField.getSelectedItem().toString();
                Cashier cashier = new Cashier();
                cashier.usernameCashier(userCashier);
                cashier.setVisible(true);
                loginCashier.dispose();
            }
            else{
                JOptionPane.showMessageDialog(null, "Please enter valid ID and Password");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error in Login");
        }
    }
    
    public void populateCashierId(){
        conn.con = null;
        conn.rs = null;
        conn.pst = null;
        conn.stm = null;
        conn.Connect();
        try {
            conn.stm = conn.con.createStatement();
            String s = "select cashierid from cashier";
            conn.rs = conn.stm.executeQuery(s);
            while(conn.rs.next()){
                loginCashier.cashierIdField.addItem(conn.rs.getString(1));
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error in Retrieving");
        }
    }
    
    public void populateCashier(){
        conn.con = null;
        conn.rs = null;
        conn.pst = null;
        conn.stm = null;
        conn.Connect();
        try{
            String querry = "select * from cashier";
            conn.pst = conn.con.prepareStatement(querry);
            conn.rs = conn.pst.executeQuery();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error in reterving Data");
        }
    }
    
    public void addCashier(){
        conn.con = null;
        conn.rs = null;
        conn.pst = null;
        conn.stm = null;
        conn.Connect();
       // addCashier.cashierDateField.setDateFormatString("yyyy-MM-dd");
       // Date startDate = addCashier.cashierDateField.getDate();
       // String d1 = new SimpleDateFormat("yyyy-MM-dd").format(startDate);
//        String query ="INSERT INTO Cashier (cashierid, cashierpassword, cashiername, cashiersalary, cashierhiredate) VALUES ('"+addCashier.cashierIdField.getText()+"','"+addCashier.cashierPasswordField.getText()+"','"+addCashier.cashierNameField.getText()+"','"+addCashier.cashierSalaryField.getText()+"','"+d1+")";
        //String query ="INSERT INTO cashier (cashierid, cashierpassword, cashiername, cashiersalary) VALUES ('"+addCashier.cashierIdField.getText()+"','"+addCashier.cashierPasswordField.getText()+"','"+addCashier.cashierNameField.getText()+"','"+addCashier.cashierSalaryField.getText()+"')";
        String query = "INSERT INTO Cashier (cashierid, cashierpassword, cashiername, cashiersalary, cashierhiredate) "
                + "VALUES (?,?,?,?,?)";
        
        try {
            // create a sql date object so we can use it in our INSERT statement
      Calendar calendar = Calendar.getInstance();
      java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
           // conn.stm = conn.con.createStatement();
            //conn.stm.executeUpdate(query);
            
            
            // create the mysql insert preparedstatement
      conn.pst = conn.con.prepareStatement(query);
       conn.pst.setInt (1, Integer.parseInt(addCashier.cashierIdField.getText()));
       conn.pst.setString (2,addCashier.cashierPasswordField.getText());
       conn.pst.setString (3,addCashier.cashierNameField.getText());
       conn.pst.setInt (4,Integer.parseInt(addCashier.cashierSalaryField.getText()));
       conn.pst.setDate (5, startDate);

      // execute the preparedstatement
       conn.pst.execute();
      
            JOptionPane.showMessageDialog(null, "Data Saved Sucessfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"error in saving data");
        }
        addCashier.cashierIdField.setText("");
        addCashier.cashierPasswordField.setText("");
        addCashier.cashierNameField.setText("");
        addCashier.cashierSalaryField.setText("");
    }
    
    public void deleteCashier(){
        conn.con = null;
        conn.pst = null;
        conn.rs = null;
        conn.stm = null;
        conn.Connect();
        try {
            conn.pst = conn.con.prepareStatement("DELETE  FROM cashier WHERE cashierid='"+deleteCashier.cashierDeleteIdField.getSelectedItem()+"'");
            //conn.pst = conn.con.prepareStatement("DELETE  FROM company WHERE companyid=1");
            conn.pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data deleted Sucessfully");
            conn.con.close();
            conn.pst.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error in deleting data");
        }
        deleteCashier.cashierDeleteIdField.setSelectedItem(null);
    }
    
    public void searchCashier(){
        conn.con = null;
        conn.pst = null;
        conn.rs = null;
        conn.stm = null;
        conn.Connect();
        try {
            conn.pst = conn.con.prepareStatement("SELECT * FROM cashier WHERE cashierid='"+searchUpdateCashier.cashierSearchIdField.getSelectedItem()+"'");
            conn.rs = conn.pst.executeQuery();
            while(conn.rs.next()){
                searchUpdateCashier.cashierSearchPasswordField.setText(conn.rs.getString("cashierpassword"));
                searchUpdateCashier.cashierSearchNameField.setText(conn.rs.getString("cashiername"));
                searchUpdateCashier.cashierSearchSalaryField.setText(conn.rs.getString("cashiersalary"));
                ((JTextField)searchUpdateCashier.cashierSearchDateField.getDateEditor().getUiComponent()).setText(conn.rs.getString("cashierhiredate"));
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error in searching");
        }
    }
    
    public void updateCashier(){
        conn.con = null;
        conn.pst = null;
        conn.rs = null;
        conn.stm = null;
        conn.Connect();
        /*addCashier.cashierDateField.setDateFormatString("yyyy-MM-dd");
        Date startDate = addCashier.cashierDateField.getDate();
        String d1 = new SimpleDateFormat("yyyy-MM-dd").format(startDate);*/
        //String query ="UPDATE cashier SET cashierpassword='"+searchUpdateCashier.cashierSearchPasswordField.getText()+"' , cashiername='"+searchUpdateCashier.cashierSearchNameField.getText()+"' , cashiersalary='"+searchUpdateCashier.cashierSearchSalaryField.getText()+"' , cashierhiredate= '"+d1+"' WHERE cashierid='"+searchUpdateCashier.cashierSearchIdField.getSelectedItem()+"'";
        //String query ="UPDATE cashier SET cashierpassword='"+searchUpdateCashier.cashierSearchPasswordField.getText()+"' , cashiername='"+searchUpdateCashier.cashierSearchNameField.getText()+"' , cashiersalary='"+searchUpdateCashier.cashierSearchSalaryField.getText()+"' , cashierhiredate= to_date('"+d1+"','yyyy/mm/dd') WHERE cashierid='"+searchUpdateCashier.cashierSearchIdField.getSelectedItem()+"'";
        String query ="UPDATE cashier SET cashierpassword='"+searchUpdateCashier.cashierSearchPasswordField.getText()+"' , cashiername='"+searchUpdateCashier.cashierSearchNameField.getText()+"' , cashiersalary='"+searchUpdateCashier.cashierSearchSalaryField.getText()+"' WHERE cashierid='"+searchUpdateCashier.cashierSearchIdField.getSelectedItem()+"'";
        try {
            conn.pst = conn.con.prepareStatement(query);
            //conn.pst.setString(1,searchUpdateCompany.companySearchNameTextField.getText());
            //conn.pst.setString(2,searchUpdateCompany.companySearchIdTextField.getText() );
            conn.pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Updated Sucessfully");
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error in updating");
        }
    }
    
    public void cashierDeleteBox(){
        conn.con = null;
        conn.rs = null;
        conn.pst = null;
        conn.stm = null;
        conn.Connect();
        try {
            conn.stm = conn.con.createStatement();
            String s = "select cashierid from cashier";
            conn.rs = conn.stm.executeQuery(s);
            while(conn.rs.next()){
                deleteCashier.cashierDeleteIdField.addItem(conn.rs.getString(1));
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error in Retrieving");
        }
    }
    
    public void cashierSearchBox(){
        conn.con = null;
        conn.rs = null;
        conn.pst = null;
        conn.stm = null;
        conn.Connect();
        try {
            conn.stm = conn.con.createStatement();
            String s = "select cashierid from cashier";
            conn.rs = conn.stm.executeQuery(s);
            while(conn.rs.next()){
                searchUpdateCashier.cashierSearchIdField.addItem(conn.rs.getString(1));
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error in Retrieving");
        }
    }
}
