/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author tram nguyen
 */
public class User {

    private String Id;
    private String name;
    private String username;
    private String address;
    private String phone;
    private String role;

    public User(String Id, String name, String username, String address, String phone, String role) {
        this.Id = Id;
        this.name = name;
        this.username = username;
        this.address = address;
        this.phone = phone;
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" + "Id=" + Id + ", name=" + name + ", username=" + username + ", address=" + address + ", phone=" + phone + ", role=" + role + '}';
    }

    public User() {
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
