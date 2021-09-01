package javaJdbcMulesoft;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateMoviedata {
   static final String DB_URL = "jdbc:mysql://localhost/bookmyshow";
   static final String USER = "root";
   static final String PASS = "Sairam2468@";
   static final String QUERY = "SELECT id,movieName,Actor,Actress,Director,YearOfRelease from movies";

   public static void main(String[] args) {
      // Open a connection
      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = conn.createStatement();
      ) {		      
         String sql = "UPDATE Movies " +
            "SET YearOfRelease = 2015 WHERE id in (5)";
         stmt.executeUpdate(sql);
         ResultSet rs = stmt.executeQuery(QUERY);
         while(rs.next()){
            //Display values
            System.out.print("ID: " + rs.getInt("id"));
            System.out.println(" MovieName: " + rs.getString("movieName"));
            System.out.print(" Actor: " + rs.getString("Actor"));
            System.out.print(" Actress: " + rs.getString("Actress"));
            System.out.println(" Director: " + rs.getString("Director"));
            System.out.println(" YearOfRelease: " + rs.getString("YearOfRelease"));
         }
         rs.close();
      } catch (SQLException e) {
         e.printStackTrace();
      } 
   }
}