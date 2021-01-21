/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Forms.AddCompany;
import Forms.DeleteCompany;
import Forms.ViewCompany;
import Forms.SearchUpdateCompany;
import javax.swing.JOptionPane;
/**
 *
 * @author Farhan
 */
public class CompanyFunctions {
    
     DBconn conn = new DBconn();
    AddCompany addCompany = null;
    DeleteCompany deleteCompany = null;
    ViewCompany viewCompany = null;
    SearchUpdateCompany searchUpdateCompany = null;
    
    public void setCompanyFunctions(AddCompany addCompany2, DeleteCompany deleteCompany2, ViewCompany viewCompany2, SearchUpdateCompany searchUpdateCompany2){
      addCompany = addCompany2;
      deleteCompany = deleteCompany2;
      viewCompany = viewCompany2;
      searchUpdateCompany = searchUpdateCompany2;
    }
    
    public void populateCompany(){
        conn.con = null;
        conn.rs = null;
        conn.pst = null;
        conn.stm = null;
        conn.Connect();
        try{
            String querry = "Select * From company";
            conn.pst = conn.con.prepareStatement(querry);
            conn.rs = conn.pst.executeQuery();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error in Populating Table");
        }
    }
    
    public void addCompany(){
        conn.con = null;
        conn.rs = null;
        conn.pst = null;
        conn.stm = null;
        conn.Connect();
        String query ="INSERT INTO company (companyid, companyname) VALUES ('"+addCompany.companyIdField.getText()+"','"+addCompany.companyNameField.getText()+"')";        
        //String query ="INSERT INTO tax (StartDate, EndDate, Province, Tax) VALUES ('"+tax.startDate.getDateFormatString()+"','"+tax.endDate.getDateFormatString()+"','"+tax.province.getSelectedItem()+"','"+tax.taxTextField.getText()+"')";
        try {
            conn.stm = conn.con.createStatement();
            conn.stm.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Saved Sucessfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error in saving data");
        }
    }
    
    public void deleteCompany(){
        conn.con = null;
        conn.pst = null;
        conn.rs = null;
        conn.stm = null;
        conn.Connect();
        try {
            conn.pst = conn.con.prepareStatement("DELETE  FROM company WHERE companyid='"+deleteCompany.companyDeleteIdField.getSelectedItem()+"'");
            //conn.pst = conn.con.prepareStatement("DELETE  FROM company WHERE companyid=1");
            conn.pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data deleted Sucessfully");
            conn.con.close();
            conn.pst.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error in deleting data");
        }
        deleteCompany.companyDeleteIdField.setSelectedItem(null);
    }
    
    public void searchCompany(){
        conn.con = null;
        conn.pst = null;
        conn.rs = null;
        conn.stm = null;
        conn.Connect();
        try {
            conn.pst = conn.con.prepareStatement("SELECT * FROM company WHERE companyid='"+searchUpdateCompany.companySearchIdField.getSelectedItem()+"'");
            conn.rs = conn.pst.executeQuery();
            while(conn.rs.next()){
                searchUpdateCompany.companySearchNameField.setText(conn.rs.getString("companyname"));
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error in searching");
        }
    }
    
    public void updateCompany(){
        conn.con = null;
        conn.pst = null;
        conn.rs = null;
        conn.stm = null;
        conn.Connect();
        //String query ="UPDATE company SET companyname=? WHERE companyid=?";
        String query ="UPDATE company SET companyname='"+searchUpdateCompany.companySearchNameField.getText()+"' WHERE companyid='"+searchUpdateCompany.companySearchIdField.getSelectedItem()+"'";
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
    
    public void companyDeleteBox(){
        conn.con = null;
        conn.rs = null;
        conn.pst = null;
        conn.stm = null;
        conn.Connect();
        try {
            conn.stm = conn.con.createStatement();
            String s = "select companyid from company";
            conn.rs = conn.stm.executeQuery(s);
            while(conn.rs.next()){
                deleteCompany.companyDeleteIdField.addItem(conn.rs.getString(1));
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error in Retrieving");
        }
    }
    
    public void companySearchBox(){
        conn.con = null;
        conn.rs = null;
        conn.pst = null;
        conn.stm = null;
        conn.Connect();
        try {
            conn.stm = conn.con.createStatement();
            String s = "select companyid from company";
            conn.rs = conn.stm.executeQuery(s);
            while(conn.rs.next()){
                searchUpdateCompany.companySearchIdField.addItem(conn.rs.getString(1));
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error in Retrieving");
        }
    }
}
