/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Forms.TransactionOperations;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public abstract class TransactionFunctions {
      
   DBconn conn = new DBconn();
    TransactionOperations transactionOperations = null;
    
    public void setTransactionFunctions(TransactionOperations transactionOperations2){
        transactionOperations = transactionOperations2;
    }
    
    public void populateTransaction(){
        conn.con = null;
        conn.rs = null;
        conn.pst = null;
        conn.stm = null;
        conn.Connect();
        transactionOperations.startDate.setDateFormatString("yyyy-MM-dd");
        Date startDate = transactionOperations.startDate.getDate();
        String d1 = new SimpleDateFormat("yyyy-MM-dd").format(startDate);
        transactionOperations.endDate.setDateFormatString("yyyy-MM-dd");
        Date endDate = transactionOperations.endDate.getDate();
        String d2 = new SimpleDateFormat("yyyy-MM-dd").format(endDate);
        try{
             String sql = "Select * From trans where transactiondate between CONVERT(DATETIME,'"+d1+"') and CONVERT(DATETIME,'"+d2+"')";
            conn.pst = conn.con.prepareStatement(sql);
            conn.rs = conn.pst.executeQuery();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void totalTransaction(){
        conn.con = null;
        conn.rs = null;
        conn.pst = null;
        conn.stm = null;
        conn.Connect();
        transactionOperations.startDate.setDateFormatString("yyyy-MM-dd");
        Date startDate = transactionOperations.startDate.getDate();
        String d1 = new SimpleDateFormat("yyyy-MM-dd").format(startDate);
        transactionOperations.endDate.setDateFormatString("yyyy-MM-dd");
        Date endDate = transactionOperations.endDate.getDate();
        String d2 = new SimpleDateFormat("yyyy-MM-dd").format(endDate);
        try {
           
            conn.pst =  conn.con.prepareStatement("Select sum(transactionamount) as sum From trans where transactiondate between CONVERT(DATETIME,'"+d1+"') and CONVERT(DATETIME,'"+d2+"')");
     conn.rs = conn.pst.executeQuery();
     conn.rs.next();
     String sum = conn.rs.getString(1);
           
      transactionOperations.totalTransaction.setText(sum);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
