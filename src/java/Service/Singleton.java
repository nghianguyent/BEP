/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author tram nguyen
 */
public class Singleton {

    private static Connection conn;

    private static Connection getConnection(String host, String username, String password) {
        try {
            Connection conn = DriverManager.getConnection(host + "username = " + username + ";password=" + password);
            return conn;
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static Connection getInstance() {
        String host = "jdbc:sqlserver://member-card.database.windows.net;databaseName=project_backend;";
        String username = "fcode_member_card";
        String password = "F-code.tech";

        try {
            if (conn == null) {
                conn = getConnection(host, username, password);
            }
            return conn;
        } catch (Exception e) {
            System.out.println(e.getMessage());
//            System.out.println("Connection false");
            return null;
        }
    }

//    public static void main(String[] args) {
//        try {
////            Class.forName("com.microsoft.sqlserver.jdbc.Driver");
//            Connection conn = DriverManager.getConnection("jdbc:sqlserver://member-card.database.windows.net;databaseName=project_backend;user=fcode_member_card;password=F-code.tech");
//            String sql = "SELECT * FROM [User]";
//            PreparedStatement stm = conn.prepareStatement(sql);
//            ResultSet rs = stm.executeQuery();
//
//            while (rs.next()) {
//                System.out.println(rs.getString("id") + " " + rs.getString("name"));
//            }
//
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
}
