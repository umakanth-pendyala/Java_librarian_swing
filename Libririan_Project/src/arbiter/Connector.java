/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbiter;
import java.sql.*;
/**
 *
 * @author UMAKANTH
 */
public class Connector {
    static Statement sp;
    public static Boolean getConnection () {
        try {
            String url = "jdbc:mysql://localhost:3306/librarian";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "root");
            Statement sp1 = con.createStatement();
            sp = sp1;
        } catch(Exception e) {
            return false;
        }
        return true;
    }
    
    
    public static Statement returnStatement() {
        return sp;
    }
    
    
    public static ResultSet getMaxIndexFromLoginDataBase() {
        try {
            ResultSet rs = sp.executeQuery("SELECT MAX( Indexes ) AS max_index FROM LoginDataBase");
            return rs;   
        } catch (Exception e) {
            return null;
        }

    } 
    
    public static Boolean insertIntoLoginDataBase(String emailId, String password, String name, String gender,int index) {
        try {
            int i = sp.executeUpdate("INSERT INTO LoginDataBase VALUES('"+emailId+"','"+password+"','"+name+"', '"+gender+"',"+index+")");
            if (i > 0) return true;
            else return false;
            
        } catch (Exception e) {
            return false;
        }
    }
         
    public static Boolean createShelfTableWithName(String tableIndex) {
        String shelfTable = "shelf_" + tableIndex;
        try {
            sp.execute("CREATE TABLE " +shelfTable+ " (Books_Present varchar(50))");
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public static Boolean createCustomerTableWithName(String tableIndex) {
        String customerTable = "recipants_" + tableIndex;
        try {
            sp.execute("CREATE TABLE " +customerTable+ " (User_Id varchar(50), Book_Given varchar(50))");
            return true;
        } catch (Exception e) {
            return false;
        }
    }
            
}
