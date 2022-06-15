/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Service.Singleton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

/**
 *
 * @author tram nguyen
 */
public class DBExecuter {

    private static Connection conn;
    private static PreparedStatement statement;
    private static ResultSet resultSet;

    public static Vector<String> executeDb(String type, String query, String... params) throws Exception{
        conn = Singleton.getInstance();
        Vector<String> result = new Vector<String>();

            statement = conn.prepareStatement(query);
            for (int i = 0; i < params.length; i++) {
                statement.setString(i + 1, params[i]);
            }
            if (type.equals("update")) {
                statement.executeUpdate();
                return null;
            } else {
                resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    result.add(resultSet.getString(1));
                }
            }
        return result;
    }
}
