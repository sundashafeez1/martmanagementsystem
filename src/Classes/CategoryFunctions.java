/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Forms.AddCategory;
import Forms.DeleteCategory;
import Forms.ViewCategory;
import Forms.SearchUpdateCategory;
import javax.swing.JOptionPane;
/**
 *
 * @author Farhan
 */
public class CategoryFunctions {
 
     DBconn conn = new DBconn();
    AddCategory addCategory = null;
    DeleteCategory deleteCategory = null;
    ViewCategory viewCategory = null;
    SearchUpdateCategory searchUpdateCategory = null;
    
    public void setCategoryFunctions(AddCategory addCategory2, DeleteCategory deleteCategory2, ViewCategory viewCategory2, SearchUpdateCategory searchUpdateCategory2){
      addCategory = addCategory2;
      deleteCategory = deleteCategory2;
      viewCategory = viewCategory2;
      searchUpdateCategory = searchUpdateCategory2;
    }
    
    public void populateCategory(){
        conn.con = null;
        conn.rs = null;
        conn.pst = null;
        conn.stm = null;
        conn.Connect();
        try{
            String querry = "Select * From category";
            conn.pst = conn.con.prepareStatement(querry);
            conn.rs = conn.pst.executeQuery();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error in Populating Table");
        }
    }
    
    public void addCategory(){
        conn.con = null;
        conn.rs = null;
        conn.pst = null;
        conn.stm = null;
        conn.Connect();
        String query ="INSERT INTO category (categoryid, categoryname) VALUES ('"+addCategory.categoryIdField.getText()+"','"+addCategory.categoryNameField.getText()+"')";        
        //String query ="INSERT INTO tax (StartDate, EndDate, Province, Tax) VALUES ('"+tax.startDate.getDateFormatString()+"','"+tax.endDate.getDateFormatString()+"','"+tax.province.getSelectedItem()+"','"+tax.taxTextField.getText()+"')";
        try {
            conn.stm = conn.con.createStatement();
            conn.stm.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Saved Sucessfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error in saving data");
        }
    }
    
    public void deleteCategory(){
        conn.con = null;
        conn.pst = null;
        conn.rs = null;
        conn.stm = null;
        conn.Connect();
        try {
            conn.pst = conn.con.prepareStatement("DELETE  FROM category WHERE categoryid='"+deleteCategory.categoryDeleteIdField.getSelectedItem()+"'");
            //conn.pst = conn.con.prepareStatement("DELETE  FROM company WHERE companyid=1");
            conn.pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data deleted Sucessfully");
            conn.con.close();
            conn.pst.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error in deleting data");
        }
        deleteCategory.categoryDeleteIdField.setSelectedItem(null);
    }
    
    public void searchCategory(){
        conn.con = null;
        conn.pst = null;
        conn.rs = null;
        conn.stm = null;
        conn.Connect();
        try {
            conn.pst = conn.con.prepareStatement("SELECT * FROM category WHERE categoryid='"+searchUpdateCategory.categorySearchIdField.getSelectedItem()+"'");
            conn.rs = conn.pst.executeQuery();
            while(conn.rs.next()){
                searchUpdateCategory.categorySearchNameField.setText(conn.rs.getString("categoryname"));
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error in searching");
        }
    }
    
    public void updateCategory(){
        conn.con = null;
        conn.pst = null;
        conn.rs = null;
        conn.stm = null;
        conn.Connect();
        //String query ="UPDATE company SET companyname=? WHERE companyid=?";
        String query ="UPDATE category SET categoryname='"+searchUpdateCategory.categorySearchNameField.getText()+"' WHERE categoryid='"+searchUpdateCategory.categorySearchIdField.getSelectedItem()+"'";
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
    
    public void categoryDeleteBox(){
        conn.con = null;
        conn.rs = null;
        conn.pst = null;
        conn.stm = null;
        conn.Connect();
        try {
            conn.stm = conn.con.createStatement();
            String s = "select categoryid from category";
            conn.rs = conn.stm.executeQuery(s);
            while(conn.rs.next()){
                deleteCategory.categoryDeleteIdField.addItem(conn.rs.getString(1));
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error in Retrieving");
        }
    }
    
    public void categorySearchBox(){
        conn.con = null;
        conn.rs = null;
        conn.pst = null;
        conn.stm = null;
        conn.Connect();
        try {
            conn.stm = conn.con.createStatement();
            String s = "select categoryid from category";
            conn.rs = conn.stm.executeQuery(s);
            while(conn.rs.next()){
                searchUpdateCategory.categorySearchIdField.addItem(conn.rs.getString(1));
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error in Retrieving");
        }
    }
}
