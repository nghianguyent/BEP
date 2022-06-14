/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ProductList;
import Service.Singleton;
import Utils.Queries;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author tram nguyen
 */
public class Product {

    private static Connection conn = Singleton.getInstance();

    private String id;
    private String name;
    private String description;
    private int volumn;
    private double price;

    public Product(String id, String name, String description, int volumn, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.volumn = volumn;
        this.price = price;
    }

    public Product() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getVolumn() {
        return volumn;
    }

    public void setVolumn(int volumn) {
        this.volumn = volumn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductList{" + "id=" + id + ", name=" + name + ", description=" + description + ", volumn=" + volumn + ", price=" + price + '}';
    }

    public static DTO.ProductList getAllProducts() throws Exception {
        String sql = Queries.getAllProduct;
        PreparedStatement stm = conn.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        DTO.ProductList result = new ProductList();
        while (rs.next()) {
            DTO.Product product = new DTO.Product();
            product.setId(rs.getString("id"));
            product.setName(rs.getString("name"));
            product.setPrice(rs.getDouble("price"));
            product.setVolumn(rs.getInt("volumn"));
            product.setDescription(rs.getNString("description"));
            product.setImgLink(rs.getString("img_link"));
            result.add(product);
        }
        return result;
    }

    public static DTO.Product getAllProductsByid(String id) throws Exception {
        String sql = Queries.getAllProduct + " WHERE id = ?";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setString(1, id);
        ResultSet rs = stm.executeQuery();
        DTO.Product result = new DTO.Product();
        while (rs.next()) {
            result.setId(rs.getString("id"));
            result.setName(rs.getString("name"));
            result.setPrice(rs.getDouble("price"));
            result.setVolumn(rs.getInt("volumn"));
            result.setDescription(rs.getNString("description"));
            result.setImgLink(rs.getString("img_link"));
            break;
        }
        return result;
    }

    public static boolean updateProduct(String id, int volumn) throws Exception {
        String sql = Queries.updateProductVolumn;
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setInt(1, volumn);
        stm.setString(2, id);
        stm.executeUpdate();
        return true;
    }
}
