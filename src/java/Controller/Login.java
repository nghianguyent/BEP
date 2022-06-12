/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tram nguyen
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try (PrintWriter out = resp.getWriter()) {
            RequestDispatcher loginFail = req.getRequestDispatcher("/Login/Loginfail.jsp");

            String username = req.getParameter("username");
            String password = req.getParameter("password");
            System.out.println("login");
            User userAccount = new User(username, password);
            DTO.User userInfor;
            // Check user 
            if (userAccount.getUser() != null) {
                userInfor = userAccount.getUser();
                System.out.println(userInfor);
                Cookie userCookie = new Cookie("username", userInfor.getUsername());
                userCookie.setMaxAge(-1);
                userCookie.setPath("/");
                userCookie.setHttpOnly(true);
                Cookie roleCookie = new Cookie("role", userInfor.getRole());
                roleCookie.setMaxAge(-1);
                roleCookie.setPath("/");
                roleCookie.setHttpOnly(true);
                resp.addCookie(userCookie);
                resp.addCookie(roleCookie);
                HttpSession session = req.getSession();
                session.setAttribute("username", username);
                resp.sendRedirect("/Home");
                return;
            }

            loginFail.forward(req, resp);
        } catch (Exception e) {
            System.out.println(e);
            resp.sendError(500, "Database connection fail");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("Login");
        Cookie[] cookies = request.getCookies();
        if (Route.isLogedIn(cookies) == 0) {
            response.sendRedirect("/");
            return;
        }

        response.sendRedirect("/Home");
    }

}
