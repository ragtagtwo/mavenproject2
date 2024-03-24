/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author rayen
 */
import java.sql.*;

public class member {
    
    

    String name,mail;
    int id;
    String password;
    public member(){
        
        
    };
    public member(String name,String mail,int id,String password){
        
        this.name=name;
        this.mail=mail;
        this.id=id;
        this.password=password;
       
        
    }
    public member(int id,String password)throws SQLException, ClassNotFoundException{
        
        this.id=id;
        this.password=password;
    }
    public void set_mail(String mail){
        this.mail=mail;
    }
    public String toString(){
        return "name= "+this.name+",id= "+this.id+",mail= "+this.mail;
    }



    // login function
    

    public boolean login (String tablename) throws SQLException,ClassNotFoundException {
       try {
           String qry = "select id ,password from " + tablename + " where id=" + this.id + " ;";
           dbconnection dbc=new dbconnection();
           dbc.st=dbc.con.createStatement();
           ResultSet res = dbc.st.executeQuery(qry);
           if (res.next()) {
               String password_verif=res.getString("password");
               if(password_verif.equals(this.password)){
                   return true;
               }else{
                   return false;
               }


           } else {
               return false;
           }

           }
       catch (SQLException e){
           e.printStackTrace();

       }
    return false;
    }
// sign up function
    public boolean sign_up(String tablename) throws SQLException,ClassNotFoundException { // function that checks if the id exists already or not in the database
        // if it does it returns false if it doesn't it executes the insert query then returns true
        try {
            String qry = "select id from " + tablename + " where id=" + this.id + ";";
            dbconnection dbc=new dbconnection();
            
            dbc.st=dbc.con.createStatement();
            dbc.st2=dbc.con.createStatement();
            ResultSet res = dbc.st.executeQuery(qry);
            if(res.next()){
                return false;
            }else{
                String qry2="insert into "+tablename+" values("+this.id+",'"+this.name+"','"+this.password+"','"+this.mail+"');";
                dbc.st2.executeUpdate(qry2);
                return true;
            }


        }catch (SQLException e){
            e.printStackTrace();
        } return false;
    }


}