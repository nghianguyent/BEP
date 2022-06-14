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
public class Cart {

    public static boolean updateCart(String userId, String productId, int volumn) throws Exception {
        Connection conn = Singleton.getInstance();
        String sql = Queries.updateProductCartVolumn;
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setInt(1, volumn);
        stm.setString(2, userId);
        stm.setString(3, productId);
        stm.executeUpdate();
        return true;
    }

    public static boolean createCart(String userId, DTO.Product product, int volumn) throws Exception {
        DTO.Cart cart = new DTO.Cart();
        Connection conn = Singleton.getInstance();
        String sql = Queries.createCart;
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setString(1, userId);
        stm.setString(2, product.getId());
        stm.setString(3, userId + product.getId());
        stm.setInt(4, volumn);
        stm.setDouble(5, (double)volumn * product.getPrice());
        stm.executeUpdate();
        return true;
    }

    public static DTO.CartList getCart(String userId, String productId) throws Exception {
        DTO.CartList result = new DTO.CartList();
        Connection conn = Singleton.getInstance();
        String sql = Queries.getCart;
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setString(1, userId);
        stm.setString(2, productId);
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            DTO.Cart cart = new DTO.Cart();
            cart.setUserId(rs.getString("user_id"));
            cart.setProductId(rs.getString("product_id"));
            cart.setPrice(rs.getDouble("price"));
            cart.setVolumn(rs.getInt("volumn"));
            cart.setBill_code(rs.getString("bill_code"));
            result.add(cart);
        }
        return result;
    }
}
