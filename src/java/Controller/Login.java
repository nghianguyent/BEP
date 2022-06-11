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
            RequestDispatcher home = req.getRequestDispatcher("/HomePage/Home.jsp");
            RequestDispatcher route = req.getRequestDispatcher("/Route");
            RequestDispatcher loginFail = req.getRequestDispatcher("/Login/Loginfail.jsp");

            String username = req.getParameter("username");
            String password = req.getParameter("password");

            User user = new User(username, password);

            // Check user 
            if (user.isExistedAccount()) {
                Cookie cookie = new Cookie("username", username);
                cookie.setMaxAge(-1);
                cookie.setPath("/");
                cookie.setHttpOnly(true);
                resp.addCookie(cookie);
                HttpSession session = req.getSession();
                session.setAttribute("username", username);
                home.forward(req, resp);
                return;
            }
            
            loginFail.forward(req, resp);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
