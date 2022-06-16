package Controller;

import DAO.CardProduct;
import DAO.User;
import com.sun.org.apache.bcel.internal.generic.D2F;
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

    protected void checkMaxVolumn(DTO.Product product, int volumn) throws Exception {
        if (volumn > product.getVolumn()) {
            throw new Exception("The volumn is more than the remaining");
        }
        //        product.setVolumn(product.getVolumn() - volumn);
//        DAO.Product.updateProduct(product.getId(), product.getVolumn());
    }

    protected void checkNoVolumn(int volumn) throws Exception {
        if (volumn == 0) {
            throw new Exception("You are not changing anything");
        }
    }

    protected String updateCart(String userId, String productId, int volumn, DTO.CartList carts) throws Exception {
        DTO.Product product = DAO.Product.getProductByid(productId);;
        checkNoVolumn(volumn);
        if (DAO.Cart.getCart(userId, productId) == null) {
            checkMaxVolumn(product, volumn);
            DAO.Cart.createCart(userId, product, volumn);
            System.out.println("success");
        }
        for (DTO.Cart cart : carts) {
            if (cart.getProductId().compareTo(productId) == 0 && cart.getUserId().compareTo(userId) == 0) {
                volumn += cart.getVolumn();
                checkMaxVolumn(product, volumn);
                cart.setVolumn(volumn);
                if (volumn == 0) {
                    DAO.Cart.deleteCard(userId, productId);
                    return "Success: deleted from cart";
                }
                DAO.Cart.updateCart(userId, product, volumn);
                return "Success: Updated to cart, check it out!";
            }
        }
        return "Fail: Something went wrong";
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        try {
            Cookie[] cookies = req.getCookies();

            if (Route.isLogedIn(cookies) == 0) {
                resp.sendRedirect("/");
            }
            DAO.User user = new DAO.User();
            user.getIdFromCookies(cookies);
            DTO.CartList carts = DAO.Cart.getAllCarts(user.getId());

            if (carts.size() == 0) {
                throw new Exception("You have no product to checkout, choose something to do it bro :>");
            }
            DAO.Cart.deleteAllCarts(user.getId());
            for (DTO.Cart cart : carts) {
                DTO.Product product = DAO.Product.getProductByid(cart.getProductId());
                DAO.Product.updateProduct(product.getId(), product.getVolumn() - cart.getVolumn());
            }
            session.setAttribute("message", "Success: We will ship to you on time");
            resp.sendRedirect("/Home");
        } catch (Exception e) {
            System.out.println(e);
            session.setAttribute("message", "Fail: " + e.getMessage());
            resp.sendRedirect("/Home");
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        try {
            Cookie[] cookies = req.getCookies();
            String userId = "";
            String productId = req.getParameter("productId");
            int volumn = Integer.parseInt(req.getParameter("volumn"));
            System.out.println("Cart update");
            for (Cookie cookie : cookies) {
                if (cookie.getName().compareTo("userId") == 0) {
                    userId = cookie.getValue();
                }
            }
            // check if the product is added to cart
            DTO.CartList carts = DAO.Cart.getAllCarts(userId);
            for (DTO.Cart cart : carts) {
                if (cart.getProductId().compareTo(productId) == 0) {
                    volumn -= cart.getVolumn();
                }
            }

            // send the message
            session.setAttribute("message", updateCart(userId, productId, volumn, carts));
            resp.sendRedirect("/Cart");

        } catch (Exception e) {
            System.out.println(e);
            session.setAttribute("message", "Fail: " + e.getMessage());
            resp.sendRedirect("/Cart");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // if user update the cart
        String method = req.getParameter("method");
        if (method != null) {
            if (method.compareTo("PUT") == 0) {
                doPut(req, resp);
                return;
            }
            if (method.compareTo("DELETE") == 0) {
                doDelete(req, resp);
                return;
            }
        }

        HttpSession session = req.getSession();
        try {
            Cookie[] cookies = req.getCookies();
            String userId = "";
            String productId = req.getParameter("productId");
            int volumn = Integer.parseInt(req.getParameter("volumn"));
            for (Cookie cookie : cookies) {
                if (cookie.getName().compareTo("userId") == 0) {
                    userId = cookie.getValue();
                }
            }
            // check if the product is added to cart
            DTO.CartList carts = DAO.Cart.getAllCarts(userId);
            updateCart(userId, productId, volumn, carts);
            // send the message
            session.setAttribute("message", "Success: Added to cart, check it out!");
            resp.sendRedirect("/Home");

        } catch (Exception e) {
            System.out.println(e);
            session.setAttribute("message", "Fail: " + e.getMessage());
            resp.sendRedirect("/Home");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            RequestDispatcher cartPage = req.getRequestDispatcher("/Product/Cart.jsp");
            DAO.User user = new User();

            Cookie[] cookies = req.getCookies();
            if (Route.isLogedIn(cookies) == 0) {
                resp.sendRedirect("/");
            }
            user.getIdFromCookies(cookies);
            DAO.CardProduct userCart = new CardProduct(user.getId());
            DTO.CartProductList carts = userCart.getAllProductCart();
            req.setAttribute("carts", carts);
            cartPage.forward(req, resp);

        } catch (Exception e) {
            System.out.println(e);
            resp.sendError(500, e.getMessage());
        }
    }

}
