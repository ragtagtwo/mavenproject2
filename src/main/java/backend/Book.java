/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author rayen
 */
import java.sql.ResultSet;
import java.util.Scanner;
import java.sql.Statement;
import java.sql.SQLException;

public class Book extends Author{
    private String name,genre;
    int book_id;
    Author author=new Author();
    int qty;
    public Book(){}; //constructor without parametres
    public Book(int book_id){ //construction with book_id only for (deletion....
        this.book_id=book_id;
    }
    public Book(String name,Author author,int book_id){
        this.name=name;
        this.author=author;
        this.book_id=book_id;
    }
    public Book(int id,String name,String author,String genre,int qty) { //constructor to add a whole new book to the database
        this.name = name;
        this.aut_name=author;
        this.qty = qty;
        this.book_id = id;
    }
    public String get_name(){
        return this.name;
    }
    public Author get_author(){
        return this.author;
    }
    public String toString(){

        String qtystring=Integer.toString(this.qty);
        String auth=this.author.toString();
        return "Book[name=" + this.name + "," + auth + ",qty=" + qtystring + "]" ;
    }
    public void save_book(String tablename) throws SQLException , ClassNotFoundException {
        String qry="insert into "+tablename+" values("+book_id+",'"+name+"','"+aut_name+"','"+genre+"',"+qty+")";
        dbconnection dbc=new dbconnection();
        dbc.st=dbc.con.createStatement();
        dbc.st.executeUpdate(qry);

        // execute statement , the variable st has been declared as static in the main
        // function which should execute statements to the prepared connection in the main function

    }
    public void book_deletion(String tablename)throws SQLException,ClassNotFoundException{
        String qry="delete * from "+tablename+" where book_id="+book_id+";";
         dbconnection dbc=new dbconnection();
         dbc.st=dbc.con.createStatement();
        dbc.st.executeUpdate(qry);
        
    }
    public boolean verify_availability(String tablename) throws SQLException , ClassNotFoundException{ //verify availaibility using book_id
        String qry="select qty from books where book_id="+book_id+" ;";
         dbconnection dbc=new dbconnection();
        dbc.st=dbc.con.createStatement();
        ResultSet rs=dbc.st.executeQuery(qry);
        int qty1=0;
        while(rs.next()){
        qty1 =rs.getInt("qty");}
        dbc.st.close();
        dbc.con.close();
        
        if( qty1 >0 ){
            return true;
        }else{
            return false;
        }
        
    }
    
       
    
    
    
    
    
    
    
}
 class Author {
    String aut_name,mail;
    int id_author;
    
    public Author() {} ;
    public Author(String name,String mail,int id_author){
        this.aut_name=name;
        this.id_author=id_author;
        this.mail=mail;

    }
    

}
