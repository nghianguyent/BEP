/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Service.Singleton;
import Utils.Queries;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author tram nguyen
 */
public class User {

    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" + "username=" + username + ", password=" + password + '}';
    }

    public boolean isExistedAccount() {

        try {
            Connection conn = Singleton.getInstance();
            String sql = Queries.selectUser;
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                if (rs.getString("username").trim().equals(username) && rs.getString("password").trim().equals(password)) {
                    return true;
                }
            }

            return false;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
