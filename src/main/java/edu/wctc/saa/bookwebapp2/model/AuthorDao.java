package edu.wctc.saa.bookwebapp2.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import edu.wctc.saa.bookwebapp2.model.Author;
import edu.wctc.saa.bookwebapp2.model.MySqlDbStrategy;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gladwin
 */
public class AuthorDao implements AuthorDaoStrategy {

    private DbStrategy db;
    private String driverClass;
    private String url;
    private String userName;
    private String password;

    public AuthorDao(DbStrategy db, String driverClass, String url, String userName, String password) {
        this.db = db;
        this.driverClass = driverClass;
        this.url = url;
        this.userName = userName;
        this.password = password;
    }

    @Override
    public List<Author> getAuthorList() throws ClassNotFoundException, SQLException {
       
            db.openConnection(driverClass, url, userName, password);
        } 
        
        List<Map<String, Object>> records = db.findAllRecords("author",500);
        List<Author> authors = new ArrayList<>();
        for (Map<String, Object> rec : records) {
            Author author = new Author();
            Integer id = Integer.parseInt(rec.get("author_id").toString());
            author.setAuthorId(id);
            String name = rec.get("author_name").toString();
            author.setAuthorName(name != null ? name : "");
            Date date = (Date) rec.get("date_added");
            author.setDateAdded(date);
            authors.add(author);
                                  

        }

        db.closeConnection();
        return authors;

    @Override
    public void deleteRecordById(String tableName, String column, Object value) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }
    public List<Author> deleteByPrimaryKeyPrepareStatement(String tableName, String primaryKey, Object primaryKeyValue) throws Exception{
        db.openConnection(driverClass, url, userName, password);
        db.deleteByPrimaryKeyPrepareStatement(tableName, primaryKey, primaryKeyValue);
        List<Author> authors = getAuthorList();
        db.closeConnection();
        return authors;
    }
    
//    public List<Author> updateByPrimaryKeyPrepareStatement(String tableName, String primaryKey, Object primaryKeyValue, List updateRecordCols, List updateRecordValues) throws Exception{
//        db.openConnection(driverClass, url, userName, password);
//        db.updateByPrimaryKey(tableName, primaryKey, primaryKeyValue, updateRecordCols, updateRecordValues);
//        List<Author> authors = getAuthorList();
//        db.closeConnection();
//        return authors;
//    }
    public List<Author> createRecordPrepareStatement(String tableName, List newRecordCols, List newRecordValues) throws Exception{
        db.openConnection(driverClass, url, userName, password);
        db.createRecordPrepareStatement(tableName, newRecordCols, newRecordValues);
        List<Author> authors = getAuthorList();
        db.closeConnection();
        return authors;
    }

//    public DbStrategy getDb() {
//        return db;
//    }
//
    public void setDb(DbStrategy db) {
        this.db = db;
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        AuthorDaoStrategy dao = new AuthorDao(
        new MySqlDbStrategy(),"com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/book?useSSL=false","root", "admin");
        
        List<Author> authors = dao.getAuthorList();
        System.out.println(authors);
    }


  
}
