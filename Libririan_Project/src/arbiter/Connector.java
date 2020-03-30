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
    static String userPassword;
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
    
    public static Boolean checkAccountInLoginDataBase(String mail, String password) {
        try {
            ResultSet rs = sp.executeQuery("SELECT * FROM LoginDataBase WHERE Email_Id = '"+mail+"' AND Password = '"+password+"'");
            rs.beforeFirst();
            if (rs.next()) return true;
            else return false;
        }catch (Exception e) {
            return false;
        }
    }
    
    public static void setPassword(String password) {
        userPassword = password;
    }
    
    public static String getPassword() {
        return userPassword;
    }
    
    
    public static int getIndexCorrespondingToPassword() {
        int indexes;
        try {
            ResultSet rs = sp.executeQuery("SELECT * FROM LoginDataBase WHERE Password = '"+getPassword()+"'");
            if (rs.next()) {
                indexes = rs.getInt("Indexes");
                return indexes;
            }
            else {
                return -1;
            }
        } catch (Exception e) {
            return -1;
        }
    }
    
    
    public static Boolean insertIntoShelfTable (String tableName, String bookName) {
        try {
        int i = sp.executeUpdate("INSERT INTO " + tableName + " VALUES('"+bookName+"')");
        if (i > 0) return true;
        else return false;
        } catch (Exception e) {
            return false;
        }
    }
    
    
    public static ResultSet getShelf (String tableName) {
        try {
            ResultSet rs = sp.executeQuery("SELECT * FROM "+ tableName);
            return rs;
        } catch (Exception e) {
            return null;
        }
    }
    
    public static ResultSet getRecipantTable (String tableName) {
        try {
            ResultSet rs = sp.executeQuery("SELECT * FROM " + tableName);
            return rs;
        } catch (Exception e) {
            return null;
        }
    }
    
    public static Boolean deleteFromShelfTable (String shelfName,String bookName) {
        try {
            int i = sp.executeUpdate("DELETE FROM " + shelfName + " WHERE Books_Present = '"+bookName+"' LIMIT 1");
            if (i > 0) return true;
            else return false;
        } catch (Exception e) {
            return false;
        }
    }
    
    public static Boolean insertBookIntoRecipantTable(String recipantTable, String userId, String bookName) {
        try {
            int i = sp.executeUpdate("INSERT INTO "+ recipantTable + " VALUES ('"+userId+"', '"+bookName+"')");
            if (i > 0) return true;
            else return false;
        } catch (Exception e) {
            return false ;
        }
    }
    
    public static Boolean deleteFromRecipantTable(String tableName, String bookName, String userId) {
        try {
            int i = sp.executeUpdate("DELETE FROM " + tableName + " WHERE Book_Given = '"+bookName+"' AND User_Id = '"+userId+"' LIMIT 1");
            if (i > 0) return true;
            else return false;
        } catch (Exception e) {
            return false;
        }
    }
    
    public static Boolean checkAdmin(String emailId, String password) {
        try {
            ResultSet rs = sp.executeQuery("SELECT * FROM admindatabase WHERE Email_id = '"+emailId+"' AND Password = '"+password+"'");
            if (rs.next()) {
                return true;
            }
            else return false;
        } catch (Exception e) {
            return false;
        }
    }
    
    public static ResultSet getLibrariansTable() {
        try {
            ResultSet rs = sp.executeQuery("SELECT * FROM logindatabase");
            return rs;
        } catch (Exception e) {
            return null;
        }
    }
    
    public static Boolean removeLibrarian(String emailId) {
        int index;
        String shelfName = "";
        String recipantTable = "";
        String bookName = "";
        int j = 0;
        String[] bookNames = new String[50];
        try {
            ResultSet rs = sp.executeQuery("SELECT * FROM logindatabase WHERE Email_Id = '"+emailId+"'");
            if (rs.next()) {
                index = rs.getInt("Indexes");
                shelfName = "shelf_" + Integer.toString(index);
                recipantTable = "recipants_" + Integer.toString(index);
                
                rs = sp.executeQuery("SELECT * FROM " +recipantTable);
                rs.beforeFirst();
                while (rs.next()) {
                    bookNames[j] = rs.getString("Book_Given");
                    j++;
                }
                
                for(int t = 0; t < bookNames.length; t++) {
                    int i;
                    try {
                        if (!bookNames[t].equals(null))
                        i = sp.executeUpdate("INSERT INTO " + shelfName + " VALUES('"+bookNames[t]+"')");  
                        
                    } catch (Exception e) {
                        break;
                    }
                }
                sp.execute("DELETE FROM logindatabase WHERE Email_Id = '"+emailId+"'");
                sp.execute("DROP TABLE " + recipantTable);
                
                return true;
            }
            else {
                return false;
            }
            
        } catch (Exception e) {
            return false;
        }
       
    }
    
    public static int getEmptyRecipantTableId () {
        String shelfName = "";
        String racipantTableName = "welcome";
        int maxIndex, temp = -1;
        try {
            try {
                ResultSet rs = getMaxIndexFromLoginDataBase();
                if (rs.next()) {
                    maxIndex = rs.getInt("max_index");
                }
                else {
                    maxIndex = 0;
                }
            } catch (Exception e) {
                maxIndex = 1;
                return -1;
            }
            
            for (int t = 1; t <= maxIndex; t++ ) {
                temp = t;
                ResultSet rs = sp.executeQuery("SELECT * FROM logindatabase WHERE Indexes = "+t+"");
                if (!rs.next()) {
                    throw new Exception();
                }
            }
            return -1;
        } catch (Exception e) {
            return temp;
        }
    }
            
}
