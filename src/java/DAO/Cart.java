/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.CartList;
import Service.Singleton;
import Utils.Queries;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

/**
 *
 * @author tram nguyen
 */
public class Cart {

    public static boolean updateCart(String userId, DTO.Product product, int volumn) throws Exception {
        Connection conn = Singleton.getInstance();
        String sql = Queries.updateProductCartVolumn;
        PreparedStatement stm = conn.prepareStatement(sql);
        double price = ((double) volumn * product.getPrice());
        stm.setInt(1, volumn);
        stm.setDouble(2, price);
        stm.setString(3, userId);
        stm.setString(4, product.getId());
        stm.executeUpdate();
        return true;
    }

    public static boolean deleteCard(String userId, String productId) throws Exception {
        String sql = Queries.deleteCart;
        DBExecuter.executeDb("update", sql, userId, productId);
        return true;
    }

    public static boolean createCart(String userId, DTO.Product product, int volumn) throws Exception {
        Connection conn = Singleton.getInstance();
        String sql = Queries.createCart;
        PreparedStatement stm = conn.prepareStatement(sql);
        double price = ((double) volumn * product.getPrice());
        stm.setString(1, userId);
        stm.setString(2, product.getId());
        stm.setString(3, userId + product.getId());
        stm.setInt(4, volumn);
        stm.setDouble(5, price);
        stm.executeUpdate();
        return true;
    }

    public static DTO.Cart getCart(String userId, String productId) throws Exception {
        Connection conn = Singleton.getInstance();
        String sql = Queries.getCart;
        DTO.Cart cart = null;
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setString(1, userId);
        stm.setString(2, productId);
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            cart = new DTO.Cart();
            cart.setUserId(rs.getString("user_id"));
            cart.setProductId(rs.getString("product_id"));
            cart.setPrice(rs.getDouble("price"));
            cart.setVolumn(rs.getInt("volumn"));
            cart.setBillCode(rs.getString("bill_code"));
        }
        return cart;
    }

    public static DTO.CartList getAllCarts(String userId) throws Exception {

        ResultSet rs = DBExecuter.executeDb("query", Queries.getAllCarts, userId);
        DTO.CartList result = new CartList();
        while (rs.next()) {
            DTO.Cart cart = new DTO.Cart();
            cart.setUserId(rs.getString("user_id"));
            cart.setProductId(rs.getString("product_id"));
            cart.setPrice(rs.getDouble("price"));
            cart.setVolumn(rs.getInt("volumn"));
            cart.setBillCode(rs.getString("bill_code"));
            result.add(cart);
        }
        return result;
    }

    public static boolean deleteAllCarts(String userId) throws Exception {
        String sql = Queries.deleteAllCarts;
        DBExecuter.executeDb("update", sql, userId);
        return true;
    }

}
