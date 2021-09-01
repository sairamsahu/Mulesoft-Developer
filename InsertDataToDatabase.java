package javaJdbcMulesoft;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDataToDatabase {
   static final String DB_URL = "jdbc:mysql://localhost/bookmyshow";
   static final String USER = "root";
   static final String PASS = "Sairam2468@";

   public static void main(String[] args) {
      // Open a connection
      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = conn.createStatement();
      ) {		      
         // Execute a query
         System.out.println("Inserting records into the table...");          
         String sql = "INSERT INTO movies VALUES (6, 'Jathiratnalu', 'Naveen', 'kajal','pradeep',2020)";
         stmt.executeUpdate(sql);
         sql = "INSERT INTO movies VALUES (7, 'RRR', 'Ramcharan', 'Alia','Rajmouli',2022)";
         stmt.executeUpdate(sql);
         System.out.println("Inserted records into the table...");   	  
      } catch (SQLException e) {
         e.printStackTrace();
      } 
   }
}