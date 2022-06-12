/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tram nguyen
 */
@WebServlet(name = "route", urlPatterns = {"/"})
public class Route extends HttpServlet {

    public static int isLogedIn(Cookie[] cookies) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().compareTo("role") == 0) {
                if (cookie.getValue().compareTo("user") == 0) {
                    return 1;
                } else {
                    return 2;
                }
            }
        }
        return 0;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (PrintWriter out = resp.getWriter()) {
            RequestDispatcher login = req.getRequestDispatcher("./Login.jsp");
            RequestDispatcher home = req.getRequestDispatcher("./HomePage/Home.jsp");
            RequestDispatcher adminPage = req.getRequestDispatcher("./HomePage/adminPage.jsp");

            Cookie[] cookies = req.getCookies();
            if (cookies != null) {
                if (isLogedIn(cookies) == 1) {
                    home.forward(req, resp);
                    return;
                } else {
                    adminPage.forward(req, resp);
                    return;
                }
            }

            login.include(req, resp);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
