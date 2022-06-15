/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Service.Singleton;
import Utils.Queries;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author tram nguyen
 */
public class CardProduct {

    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public CardProduct(String userId) {
        this.userId = userId;
    }

    public DTO.CartProductList getAllProductCart() throws Exception {
        ResultSet rs = DBExecuter.executeDb("query", Queries.getAllProductCart, userId);
        DTO.CartProductList result = new DTO.CartProductList();
        while (rs.next()) {
            DTO.CartPoduct cart = new DTO.CartPoduct();
            cart.setUserId(rs.getString("user_id"));
            cart.setProductId(rs.getString("product_id"));
            cart.setPrice(rs.getDouble("price"));
            cart.setVolumn(rs.getInt("volumn"));
            cart.setBillCode(rs.getString("bill_code"));
            cart.setProductName(rs.getNString("name"));
            cart.setProductImgLink(rs.getString("img_link"));
            result.add(cart);
        }
        return result;
    }
}
