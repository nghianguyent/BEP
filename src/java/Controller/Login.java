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
@WebServlet(name = "Login", urlPatterns = {"/"})
public class Login extends HttpServlet {

    private boolean isLogedIn(Cookie[] cookies) {
        return cookies.length > 1;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (PrintWriter out = resp.getWriter()) {
            RequestDispatcher home = req.getRequestDispatcher("/HomePage/Home.jsp");

            String username = req.getParameter("username");
            String password = req.getParameter("password");

            User user = new User(username, password);

            // check if the user login before 
            Cookie[] cookies = req.getCookies();
            if (isLogedIn(cookies)) {
                home.forward(req, resp);
                return;
            }
            for (Cookie cookie : cookies) {
                if (cookie.getName().compareTo("sessionId") == 1) {

                }
            }

            // Check user 
            if (user.isExistedAccount()) {
                Cookie cookie = new Cookie("username", username);
                cookie.setMaxAge(-1);
                cookie.setPath("/");
                cookie.setHttpOnly(true);
                HttpSession session = req.getSession();
                System.out.println(session.getId());
                resp.addCookie(cookie);
                resp.sendRedirect("/HomePage/Home.jsp");
            }
//             home.forward(req, resp);
//            if (isLogedIn(cookies)) {
//                home.forward(req, resp);
//                return;
//            }
        } catch (Exception e) {
        }
    }

}
