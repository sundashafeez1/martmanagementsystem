/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Forms.AddProduct;
import Forms.DeleteProduct;
import Forms.ViewProduct;
import Forms.SearchUpdateProduct;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
 import java.text.DateFormat;
import java.time.format.DateTimeFormatter;
public class ProductFunctions  {
    
    DBconn conn = new DBconn();
    AddProduct addProduct = null;
    DeleteProduct deleteProduct = null;
    ViewProduct viewProduct = null;
    SearchUpdateProduct searchUpdateProduct = null;
    
    public void setProductFunctions(AddProduct addProduct2, DeleteProduct deleteProduct2, ViewProduct viewProduct2, SearchUpdateProduct searchUpdateProduct2){
      addProduct = addProduct2;
      deleteProduct = deleteProduct2;
      viewProduct = viewProduct2;
      searchUpdateProduct = searchUpdateProduct2;
    }
    
    public void populateProduct(){
        conn.con = null;
        conn.rs = null;
        conn.pst = null;
        conn.stm = null;
        conn.Connect();
        try{
            String querry = "Select * From product";
            conn.pst = conn.con.prepareStatement(querry);
            conn.rs = conn.pst.executeQuery();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error in Populating Table");
        }
    }
    
    public void addProduct(){
        conn.con = null;
        conn.rs = null;
        conn.pst = null;
        conn.stm = null;
        conn.Connect();
        addProduct.productManufactureDateField.setDateFormatString("yyyy-MM-dd");
        Date startDate = addProduct.productManufactureDateField.getDate();
        String d1 = new SimpleDateFormat("yyyy-MM-dd").format(startDate);
        addProduct.productExpireDateField.setDateFormatString("yyyy-MM-dd");
        Date endDate = addProduct.productExpireDateField.getDate();
        String d2 = new SimpleDateFormat("yyyy-MM-dd").format(endDate);
        String query ="INSERT INTO product (productid, productname, productprice, productmanufacturingdate, productexpirydate, productcompanyid, productcategoryid, productquantity) "
                + "VALUES ('"+addProduct.productIdField.getText()+"','"+addProduct.productNameField.getText()+"','"+addProduct.productPriceField.getText()+"', CONVERT(DATETIME,'"+d1+"'), CONVERT(DATETIME,'"+d2+"'),'"+addProduct.productCompanyIdField.getSelectedItem()+"','"+addProduct.productCategoryIdField.getSelectedItem()+"','"+addProduct.productQuantityField.getText()+"')";
       
        try {
           conn.stm = conn.con.createStatement();
           conn.stm.executeUpdate(query);
  
            JOptionPane.showMessageDialog(null, "Data Saved Sucessfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error while saving data!!");
        }
        addProduct.productIdField.setText("");
        addProduct.productNameField.setText("");
        addProduct.productPriceField.setText("");
        addProduct.productQuantityField.setText("");
    }
    
    public void deleteProduct(){
        conn.con = null;
        conn.pst = null;
        conn.rs = null;
        conn.stm = null;
        conn.Connect();
        try {
            conn.pst = conn.con.prepareStatement("DELETE  FROM product WHERE productid='"+deleteProduct.productDeleteIdField.getSelectedItem()+"'");
            //conn.pst = conn.con.prepareStatement("DELETE  FROM company WHERE companyid=1");
            conn.pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data deleted Sucessfully");
            conn.con.close();
            conn.pst.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error in deleting data");
        }
        deleteProduct.productDeleteIdField.setSelectedItem(null);
    }
    
    public void searchProduct(){
        conn.con = null;
        conn.pst = null;
        conn.rs = null;
        conn.stm = null;
        conn.Connect();
        try {
            conn.pst = conn.con.prepareStatement("SELECT * FROM product WHERE productid='"+searchUpdateProduct.productSearchIdField.getSelectedItem()+"'");
            conn.rs = conn.pst.executeQuery();
            while(conn.rs.next()){
                searchUpdateProduct.productSearchNameField.setText(conn.rs.getString("productname"));
                searchUpdateProduct.productSearchPriceField.setText(conn.rs.getString("productprice"));
                ((JTextField)searchUpdateProduct.productSearchManufactureDateField.getDateEditor().getUiComponent()).setText(conn.rs.getString("productmanufacturingdate"));
                ((JTextField)searchUpdateProduct.productSearchExpireDateField.getDateEditor().getUiComponent()).setText(conn.rs.getString("productexpirydate"));
                searchUpdateProduct.productSearchCompanyIdField.setText(conn.rs.getString("productcompanyid"));
                searchUpdateProduct.productSearchCategoryIdField.setText(conn.rs.getString("productcategoryid"));
                searchUpdateProduct.productSearchQuantityField.setText(conn.rs.getString("productquantity"));
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error in searching");
        }
    }
    
    public void updateProduct(){
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
        String query ="UPDATE product SET productname='"+searchUpdateProduct.productSearchNameField.getText()+"' , productprice='"+searchUpdateProduct.productSearchPriceField.getText()+"' , productcompanyid='"+searchUpdateProduct.productSearchCompanyIdField.getText()+"' , productcategoryid='"+searchUpdateProduct.productSearchCategoryIdField.getText()+"' , productquantity='"+searchUpdateProduct.productSearchQuantityField.getText()+"' WHERE productid='"+searchUpdateProduct.productSearchIdField.getSelectedItem()+"'";
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
    
    public void productDeleteBox(){
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
                deleteProduct.productDeleteIdField.addItem(conn.rs.getString(1));
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error in Retrieving");
        }
    }
    
    public void productSearchBox(){
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
                searchUpdateProduct.productSearchIdField.addItem(conn.rs.getString(1));
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error in Retrieving");
        }
    }
    
    public void productCompanyIdBox(){
        conn.con = null;
        conn.rs = null;
        conn.pst = null;
        conn.stm = null;
        conn.Connect();
        try {
            conn.stm = conn.con.createStatement();
            String s = "select companyid, companyname from company";
            conn.rs = conn.stm.executeQuery(s);
            while(conn.rs.next()){
                addProduct.productCompanyIdField.addItem(conn.rs.getString(1));
                addProduct.productCompanyIdField.addItem(conn.rs.getString(2));
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error in Retrieving");
        }
    }
    
    public void productCategoryIdBox(){
        conn.con = null;
        conn.rs = null;
        conn.pst = null;
        conn.stm = null;
        conn.Connect();
        try {
            conn.stm = conn.con.createStatement();
            String s = "select categoryid, categoryname from category";
            conn.rs = conn.stm.executeQuery(s);
            while(conn.rs.next()){
                addProduct.productCategoryIdField.addItem(conn.rs.getString(1));
                addProduct.productCategoryIdField.addItem(conn.rs.getString(2));
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error in Retrieving");
        }
    }
}
