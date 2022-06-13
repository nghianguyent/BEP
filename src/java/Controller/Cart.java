package Controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tram nguyen
 */
@WebServlet(name = "Cart", urlPatterns = {"/Cart"})
public class Cart extends HttpServlet {

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            RequestDispatcher home = req.getRequestDispatcher("/HomePage/Home");

            Cookie[] cookies = req.getCookies();
            String userId = "";
            String producId = req.getParameter("productId");
            int volumn = Integer.parseInt(req.getParameter("volumn"));
            for (Cookie cookie : cookies) {
                if (cookie.getName().compareTo("userId") == 0) {
                    userId = cookie.getValue();
                }
            }
            // check if the product is added to cart
            DTO.CartList carts = DAO.Cart.getCart(userId, producId);
            for (DTO.Cart cart : carts) {
                if (cart.getProductId().compareTo(producId) == 0 && cart.getUserId().compareTo(userId) == 0) {
                    volumn += cart.getVolumn();
                    cart.setVolumn(volumn);
                    DAO.Cart.updateCart(userId, producId, volumn);
                }
            }
            HttpSession session = req.getSession();
            req.setAttribute("message", "Added to cart");
            req.setAttribute("addedProduct", producId);
            session.setAttribute("message", "Added to cart");
            session.setAttribute("addedProduct", producId);
            resp.sendRedirect("/Home");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
