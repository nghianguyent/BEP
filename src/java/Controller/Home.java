package Controller;

import DTO.Product;
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
@WebServlet(name = "Home", urlPatterns = {"/Home"})
public class Home extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            RequestDispatcher home = request.getRequestDispatcher("/HomePage/Home.jsp");
            RequestDispatcher adminPage = request.getRequestDispatcher("/HomePage/AdminPage.jsp");
            RequestDispatcher cart = request.getRequestDispatcher("/Cart");
            System.out.println("Home");
            Cookie[] cookies = request.getCookies();
            if (Route.isLogedIn(cookies) == 0) {
                response.sendRedirect("/");
                return;
            }
            // load product to request
            DTO.ProductList list = DAO.Product.getAllProducts();
            request.setAttribute("productList", list);
            HttpSession session = request.getSession();
            session.setAttribute("productList", list);
//            cart.include(request, response);
            if (Route.isLogedIn(cookies) == 1) {
                home.forward(request, response);
            } else {
                adminPage.forward(request, response);
            }

            /* TODO output your page here. You may use following sample code. */
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "home page";
    }// </editor-fold>

}
