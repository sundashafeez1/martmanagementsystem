/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Forms.Cashier;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Farhan
 */
public class CashierSubmitFunctions extends TransactionFunctions {
    
    DBconn conn = new DBconn();
    Cashier cashier = null;
    
    public void setCashierSubmitFunctions(Cashier cashier2){
      cashier = cashier2;
    }
    
    public void productIdBox(){
        conn.con = null;
        conn.rs = null;
        conn.pst = null;
        conn.stm = null;
        conn.Connect();
        try {
            conn.stm = conn.con.createStatement();
            String s = "select productid from product";
            conn.rs = conn.stm.executeQuery(s);
            while(conn.rs.next()){
                cashier.productIdField.addItem(conn.rs.getString(1));
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error in Retrieving");
        }
    }
    
    public void customerIdBox(){
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
                cashier.customerIdField.addItem(conn.rs.getString(1));
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error in Retrieving");
        }
    }
    
    public void populateCashierName(){
        conn.con = null;
        conn.rs = null;
        conn.pst = null;
        conn.stm = null;
        conn.Connect();
        try {
            conn.stm = conn.con.createStatement();
            String s = "Select cashiername FROM cashier WHERE cashierid='"+cashier.cashierId.getText()+"' ";
            conn.rs = conn.stm.executeQuery(s);
            while(conn.rs.next()){
            cashier.cashierNameField.setText(conn.rs.getString("cashiername"));
            }            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error in Retrieving");
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
            String s = "Select customername FROM customer WHERE customerid='"+cashier.customerIdField.getSelectedItem()+"' ";
            conn.rs = conn.stm.executeQuery(s);
            while(conn.rs.next()){
            cashier.customerNameField.setText(conn.rs.getString("customername"));
            }            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error in Retrieving");
        }
    }
    
    public void populateProductName(){
        conn.con = null;
        conn.rs = null;
        conn.pst = null;
        conn.stm = null;
        conn.Connect();
        try {
            conn.stm = conn.con.createStatement();
            String s = "Select productname FROM product WHERE productid='"+cashier.productIdField.getSelectedItem()+"' ";
            conn.rs = conn.stm.executeQuery(s);
            while(conn.rs.next()){
            cashier.productNameField.setText(conn.rs.getString("productname"));
            }            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error in Retrieving");
        }
    }
    
    public void populateProductPrice(){
        conn.con = null;
        conn.rs = null;
        conn.pst = null;
        conn.stm = null;
        conn.Connect();
        try {
            conn.stm = conn.con.createStatement();
            String s = "Select productprice FROM product WHERE productid='"+cashier.productIdField.getSelectedItem()+"' ";
            conn.rs = conn.stm.executeQuery(s);
            while(conn.rs.next()){
            cashier.productPriceField.setText(conn.rs.getString("productprice"));
            }            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error in Retrieving");
        }
    }
    
    public void addInCart(){
        DefaultTableModel model = (DefaultTableModel) cashier.cartDetailTable.getModel();
        model.addRow(new Object[]{cashier.transactionIdField.getText(),cashier.productIdField.getSelectedItem(),cashier.productPriceField.getText(),cashier.productQuantityField.getText(),cashier.totalPricePerProductField.getText()});
        cashier.productIdField.setSelectedItem(null);
        cashier.productNameField.setText("");
        cashier.productPriceField.setText("");
        cashier.productQuantityField.setText("");
        cashier.totalPricePerProductField.setText("");
    }
    
    public void clearTable(){
         cashier.cartDetailTable.setModel(new DefaultTableModel(null,new Object[]{cashier.transactionIdField,cashier.productIdField,cashier.productPriceField,cashier.productQuantityField,cashier.totalPricePerProductField}));
    }
    
    public void saleAmountCashier(){
        int sum = 0;
        for(int i = 0; i < cashier.cartDetailTable.getRowCount(); i++){
            sum = Integer.parseInt(cashier.cartDetailTable.getValueAt(i, 4).toString()) + sum;//the 4 here indicates that sum the values of 4th coloum starting from 0
        }
        cashier.transactionTotalField.setText(Integer.toString(sum));
    }
    
    public void totalPricePerProduct(){
        int price = Integer.parseInt(cashier.productPriceField.getText());
        int quantity = Integer.parseInt(cashier.productQuantityField.getText());
        int totalPerProduct = price * quantity;
        cashier.totalPricePerProductField.setText(""+totalPerProduct);
    }
    
    public void submitTransaction(){
        conn.con = null;
        conn.rs = null;
        conn.pst = null;
        conn.stm = null;
        conn.Connect();
        cashier.cashierDateField.setDateFormatString("yyyy-MM-dd");
        Date startDate = cashier.cashierDateField.getDate();
        String d1 = new SimpleDateFormat("yyyy-MM-dd").format(startDate);
        String query ="INSERT INTO [trans] (transactionid, transactionamount, transactiondate, transactioncashierid, transactioncustomerid) "
                + "VALUES ('"+cashier.transactionIdField.getText()+"' , '"+cashier.transactionTotalField.getText()+"', CONVERT(DATETIME,'"+d1+"') , '"+cashier.cashierId.getText()+"','"+cashier.customerIdField.getSelectedItem()+"')";
        try {
            conn.stm = conn.con.createStatement();
            conn.stm.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Saved Sucessfully in Transaction Table");
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Error in saving data in Transaction Table");
             JOptionPane.showMessageDialog(null,e);
        }
        cashier.customerIdField.setSelectedItem(null);
        cashier.customerNameField.setText("");
        cashier.transactionIdField.setText("");
        cashier.productIdField.setSelectedItem(null);
        cashier.productNameField.setText("");
        cashier.productPriceField.setText("");
        cashier.productQuantityField.setText("");
        cashier.totalPricePerProductField.setText("");
        cashier.transactionTotalField.setText("");
        //cashier.cartDetailTable.setModel(new DefaultTableModel(null,new Object[]{cashier.transactionIdField.getText(),cashier.productIdField.getSelectedItem(),cashier.productPriceField.getText(),cashier.productQuantityField.getText(),cashier.totalPricePerProductField.getText()}));
        //model.addRow(new Object[]{cashier.transactionIdField.getText(),cashier.productIdField.getSelectedItem(),cashier.productPriceField.getText(),cashier.productQuantityField.getText(),cashier.totalPricePerProductField.getText()});
    }
    
    public void submitDetail(){
        conn.con = null;
        conn.rs = null;
        conn.pst = null;
        conn.stm = null;
        conn.Connect();
        try{
        int rows = cashier.cartDetailTable.getRowCount();
        for(int row = 0; row < rows; row++){   
        int detailTransactionId = Integer.parseInt(cashier.cartDetailTable.getValueAt(row, 0).toString());
        int detailProductId = Integer.parseInt(cashier.cartDetailTable.getValueAt(row, 1).toString());
        int detailAmount = Integer.parseInt(cashier.cartDetailTable.getValueAt(row, 2).toString());
        int productQuantity = Integer.parseInt(cashier.cartDetailTable.getValueAt(row, 3).toString());
        String queryco = "Insert into DETAIL(DETAILTRANSACTIONID, DETAILPRODUCTID, DETAILAMOUNT, PRODUCTQUANTITY) values ('"+detailTransactionId+"','"+detailProductId+"','"+detailAmount+"','"+productQuantity+"')";
        conn.pst = conn.con.prepareStatement(queryco);
        conn.pst.execute();
        }
        JOptionPane.showMessageDialog(null, "Data Saved Sucessfully in Detail Table");
        }
        catch (Exception e) {
           // JOptionPane.showMessageDialog(null, "Error in saving data in Detail Table");
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        cashier.cartDetailTable.setModel(new DefaultTableModel(null,new Object[]{cashier.transactionIdField,cashier.productIdField,cashier.productPriceField,cashier.productQuantityField,cashier.totalPricePerProductField}));
        
    }
}
        
  