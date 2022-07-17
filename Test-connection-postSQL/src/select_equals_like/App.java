/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package select_equals_like;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import test.connection.postsql.DatabaseConnection;

public class App {

    private static Scanner in = new Scanner(System.in);
    private static List<Actor> listOfActors;

    public static void findActorBySelect(String value) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int count = 0;
        try {
            //dùng de noi chuoi
            StringBuilder sql = new StringBuilder("SELECT * FROM actor ");
            sql.append("WHERE first_name = ?");
            conn = DatabaseConnection.getConnection();
            stm = conn.prepareStatement(sql.toString());
            stm.setString(1, value);
            rs = stm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("actor_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String lastUpdate = rs.getTimestamp("last_update").toString();
                Actor actor = new Actor(id, firstName, lastName, lastUpdate);
                listOfActors.add(actor);
                count++;
            }
            if(count == 0) {
                System.out.println("Ko co ten ban can tim");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        listOfActors = new ArrayList<>();
        System.out.print("Enter search value: ");
        String value = in.nextLine();
        findActorBySelect(value);
        for (Actor actor : listOfActors) {
            System.out.println(actor.toString());
        }
    }

}
