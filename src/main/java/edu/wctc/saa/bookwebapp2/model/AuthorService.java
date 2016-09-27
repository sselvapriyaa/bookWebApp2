/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.saa.bookwebapp2.model;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ArrayList;
import javax.swing.text.DateFormatter;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Gladwin
 */
public class AuthorService {
     private AuthorDaoStrategy dao;
    //private ArrayList<Author> authors;
    public AuthorService(AuthorDaoStrategy dao) {
        this.dao = dao;
       
    }

    public AuthorService() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
    
    public List<Author> getAuthorList() throws ClassNotFoundException, SQLException{
       return dao.getAuthorList();
    }
     
  
    
    
    public void deleteAuthorId(String tableName, String columnName, String value) throws Exception{
    dao.deleteRecordById( tableName, columnName, value);
    }
//     public static void main(String[] args) throws Exception { 
//        AuthorService service = new AuthorService(new AuthorDao(new MySqlDbStrategy(),"com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/book", "root", "admin"));
//      
//        for(Author b: service.getAuthorList()){
//            System.out.println(b);
//        }
         public static void main(String[] args) throws ClassNotFoundException, SQLException {
        AuthorDaoStrategy dao = new AuthorDao(
                (DbStrategy) new MySqlDbStrategy(),
                "com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/book?useSSL=false","root", "admin");
        AuthorService authorService = new AuthorService(dao);
        List<Author> authors = authorService.getAuthorList();
        System.out.println(authors);
    }
    
    //private ArrayList<Author> authors;
    
//    public AuthorService(){
//        authors=new ArrayList<Author>();
//        authors.add(new Author("Antonio Goncalves",1,new Date()));
//        authors.add(new Author("Tonny Gaddis",2,new Date()));
//        authors.add(new Author("Freeman & Robson",3,new Date()));
//    }
    
//    public ArrayList getAllAuthors(){
//        return authors;
//    }
//    
//    public void addAuthor(Author a){
//        authors.add(a);
//    }

    public ArrayList getAllAuthors() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

