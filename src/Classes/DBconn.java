package Classes;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconn {
    
  

        Connection con=null; 
        Statement stm;
        ResultSet rs;
        PreparedStatement pst;

public void Connect(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Mart;user=Sadia;password=maria_1803");  
            String ConnectionURL=  "jdbc:sqlserver://localhost:1433;databaseName=Mart;user=Sadia;password=maria_1803";
            System.out.println("Connection "
                    + "successful");
                //con.close();
        } catch (Exception e) {
        System.out.println("Error in connection with database");
        }
    }


}


