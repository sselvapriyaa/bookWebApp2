/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.saa.bookwebapp2.model;

import edu.wctc.saa.bookwebapp2.model.Author;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Gladwin
 */
public interface AuthorDaoStrategy {

    List<Author> getAuthorList() throws ClassNotFoundException, SQLException;
  void deleteRecordById(String tableName, String column, Object value) throws Exception;
  
   
}
