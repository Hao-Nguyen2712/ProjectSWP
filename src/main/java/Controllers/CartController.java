/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import DAOs.AccountDAO;
import DAOs.CartDAO;
import DAOs.KeyboardDAO;
import DAOs.ProductDAO;
import DAOs.UserDAO;
import Models.Account;
import Models.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author nguye
 */
public class CartController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CartController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CartController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        String path = request.getRequestURI();
        HttpSession session = (HttpSession) request.getSession();
        if (path.endsWith("/CartController/Cart")) {
            request.getRequestDispatcher("/View/Main/cart.jsp").forward(request, response);
        } else if (path.startsWith("/CartController/Delete/")) {
            String[] s = path.split("/");
            try {
                int pro_id = Integer.parseInt(s[s.length - 1]);
                CartDAO cDAO = new CartDAO();
                Account acc = (Account) session.getAttribute("account");
                AccountDAO accDAO = new AccountDAO();
                UserDAO userDAO = new UserDAO();
                int user_id = userDAO.getUserIDWithAccID(accDAO.getAccIDWithGmail(acc.getEmail()));
                int test = cDAO.DeleteProductInCart(user_id, pro_id);
                if (test == 0) {
                    throw new Exception("");
                }
                response.sendRedirect("/CartController/Cart");
            } catch (Exception ex) {
                response.sendRedirect("/View/Main/error.jsp");
            }
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
        int userId = Integer.parseInt(request.getParameter("userId"));
        int productId = Integer.parseInt(request.getParameter("productId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        // Thực hiện cập nhật trong cơ sở dữ liệu
        CartDAO cDAO = new CartDAO();
        cDAO.updateQuantityProductInCartPage(quantity, productId, userId);
        KeyboardDAO kDAO = new KeyboardDAO();
        ProductDAO pDAO = new ProductDAO();
        Product pro = pDAO.getProductByID(productId);
        response.setContentType("text/plain");
        String money = kDAO.converterNumber(Integer.parseInt(pro.getPro_price()) * quantity);
        response.getWriter().write(money);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
