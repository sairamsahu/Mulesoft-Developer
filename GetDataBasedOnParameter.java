package javaJdbcMulesoft;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetDataBasedOnParameter {
   static final String DB_URL = "jdbc:mysql://localhost/bookmyshow";
   static final String USER = "root";
   static final String PASS = "Sairam2468@";
   static final String QUERY = "SELECT id,movieName,Actor,Actress,Director,YearOfRelease from movies";

   public static void main(String[] args) {
      // Open a connection
      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = conn.createStatement();
      ) {		      
			
    	  String SQL = "select * FROM movies WHERE Actor ='pavan Kalyan'";
    	    // ResultSet
    	    ResultSet rs = stmt.executeQuery(SQL);
         while(rs.next()){
            //Display values
            System.out.print("ID: " + rs.getInt("id"));
            System.out.print(" MovieName: " + rs.getString("movieName"));
            System.out.print(" Actor: " + rs.getString("Actor"));
            System.out.println(" Actress: " + rs.getString("Actress"));
            System.out.println(" Director: " + rs.getString("Director"));
            System.out.println(" YearOfRelease: " + rs.getInt("YearOfRelease"));
         }
         rs.close();
      } catch (SQLException e) {
         e.printStackTrace();
      } 
   }
}