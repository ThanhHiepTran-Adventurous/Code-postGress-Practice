/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.connection.postsql;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public static String url = "jdbc:postgresql://localhost:5432/dvdrental";
    public static String username = "postgres";
    public static String password = "0105";
    
    
    public static Connection getConnection(){
        Connection cnt = null;
        try {
            cnt = DriverManager.getConnection(url, username, password);
          //  System.out.println("Connection to PostgresSQL");   
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return cnt;
    }
}

