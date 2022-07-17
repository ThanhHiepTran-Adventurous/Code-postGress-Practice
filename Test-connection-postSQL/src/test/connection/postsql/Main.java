/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test.connection.postsql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<Actor> listOfActors;

    private static void getAllFullname() {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM actor";
            conn = DatabaseConnection.getConnection();
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("actor_id"); 
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String lastUpdate = rs.getTimestamp("last_update").toString();
                Actor actor = new Actor(id, firstName, lastName, lastUpdate);
            //    String fullName = firstName + " " + lastName + " " + lastUpdate;
                listOfActors.add(actor);
             
            }
        } catch (Exception e) {
            return;
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (stm != null) {
                    stm.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        listOfActors = new ArrayList<>();
        getAllFullname();
        for (Actor actor : listOfActors) {
            System.out.println(actor);
        }
    }
}
