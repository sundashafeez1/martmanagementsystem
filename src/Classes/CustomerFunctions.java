
package Classes;

import Forms.LoginCustomer;
import Forms.SignupCustomer;
import Forms.CustomerOperations;
import Forms.Customer;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class CustomerFunctions {
    
    DBconn conn = new DBconn();
    LoginCustomer loginCustomer = null;
    SignupCustomer signupCustomer = null;
    Customer customer = null;
    CustomerOperations customerOperations = null;
    
    public void setCustomerFunctions(LoginCustomer loginCustomer2, SignupCustomer signupCustomer2, Customer customer2, CustomerOperations customerOperations2){
      loginCustomer = loginCustomer2;
      signupCustomer = signupCustomer2;
      customer = customer2;
      customerOperations = customerOperations2;
    }
    
    public void customerLoginCheck(){
        conn.con = null;
        conn.rs = null;
        conn.pst = null;
        conn.stm = null;
        conn.Connect();
        String query = "Select customerid, customerpassword FROM customer WHERE customerid='"+loginCustomer.customerIdField.getSelectedItem()+"' AND customerpassword='"+loginCustomer.customerPasswordField.getText()+"' ";
        try {
            conn.pst = conn.con.prepareStatement(query);
            conn.rs = conn.pst.executeQuery();
            if(conn.rs.next()){
                String userCustomer = loginCustomer.customerIdField.getSelectedItem().toString();
                Customer customer = new Customer();
                customer.usernameCustomer(userCustomer);
                customer.setVisible(true);
                loginCustomer.dispose();
            }
            else{
                JOptionPane.showMessageDialog(null, "Please enter valid ID and Password");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error in Login");
        }
    }
    
    public void populateCustomerId(){
        conn.con = null;
        conn.rs = null;
        conn.pst = null;
        conn.stm = null;
        conn.Connect();
        try {
            conn.stm = conn.con.createStatement();
            String s = "select customerid from customer";
            conn.rs = conn.stm.executeQuery(s);
            while(conn.rs.next()){
                loginCustomer.customerIdField.addItem(conn.rs.getString(1));
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error in Retrieving");
        }
    }
    
    public void populateCustomerOperations(){
        conn.con = null;
        conn.rs = null;
        conn.pst = null;
        conn.stm = null;
        conn.Connect();
        try{
            String querry = "Select * From customer";
            conn.pst = conn.con.prepareStatement(querry);
            conn.rs = conn.pst.executeQuery();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error in Populating Table");
        }
    }
    
    public void populateCustomerName(){
        conn.con = null;
        conn.rs = null;
        conn.pst = null;
        conn.stm = null;
        conn.Connect();
        try {
            conn.stm = conn.con.createStatement();
            String s = "Select customername FROM customer WHERE customerid='"+customer.customerId.getText()+"' ";
            conn.rs = conn.stm.executeQuery(s);
            while(conn.rs.next()){
            customer.customerNameField.setText(conn.rs.getString("customername"));
            }            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error in Retrieving");
        }
    }
    
    public void populateCustomerDetail(){
        conn.con = null;
        conn.rs = null;
        conn.pst = null;
        conn.stm = null;
        conn.Connect();
        try{
            String querry = "SELECT D.DETAILTRANSACTIONID,D.DETAILPRODUCTID,D.DETAILAMOUNT,D.PRODUCTQUANTITY,T.TRANSACTIONAMOUNT FROM trans T INNER JOIN DETAIL D ON(T.transactionid=D.detailtransactionid) WHERE transactionCUSTOMERid='"+customer.customerId.getText()+"'";
            //String querry = "SELECT T.TRANSACTIONAMOUNT,D.DETAILTRANSACTIONID,D.DETAILPRODUCTID,D.DETAILAMOUNT,D.PRODUCTQUANTITY FROM TRANSACTION T INNER JOIN DETAIL D ON(T.transactionid=D.detailtransactionid) WHERE transactionCUSTOMERid=1";
            conn.pst = conn.con.prepareStatement(querry);
            conn.rs = conn.pst.executeQuery();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error in Populating Table");
        }
    }
    
    public void addCustomer(){
        conn.con = null;
        conn.rs = null;
        conn.pst = null;
        conn.stm = null;
        conn.Connect();
        String query ="INSERT INTO customer (customerid, customerpassword, customername, customergender, customerage, customeraddress, customeremail) VALUES ('"+signupCustomer.signupCustomerIdField.getText()+"','"+signupCustomer.signupCustomerPasswordField.getText()+"','"+signupCustomer.signupCustomerNameField.getText()+"','"+signupCustomer.signupCustomerGenderField.getSelectedItem()+"','"+signupCustomer.signupCustomerAgeField.getText()+"','"+signupCustomer.signupCustomerAddressField.getText()+"','"+signupCustomer.signupCustomerEmailField.getText()+"')";
        try {
            conn.stm = conn.con.createStatement();
            conn.stm.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Saved Sucessfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error in saving data");
        }
        signupCustomer.signupCustomerIdField.setText("");
        signupCustomer.signupCustomerPasswordField.setText("");
        signupCustomer.signupCustomerNameField.setText("");
        signupCustomer.signupCustomerAgeField.setText("");
        signupCustomer.signupCustomerAddressField.setText("");
        signupCustomer.signupCustomerEmailField.setText("");
    }
}
