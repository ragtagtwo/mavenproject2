/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;
import java.sql.*;
/**
 *
 * @author rayen
 */
public class dbconnection {
    public String dbname="root";
    public String dbpass="123578951rayen";
    public String url="jdbc:mysql://localhost:3306/librarymanagement";
    public Connection con=null;
    public Statement st=null;
    public Statement st2=null;
    
    
    
    
    
    
    public dbconnection()throws ClassNotFoundException , SQLException {   // constructor to initiate connection
        Class.forName("com.mysql.cj.jdbc.Driver");
        con=DriverManager.getConnection(url,dbname,dbpass);
        
        
    }
    
    
}
