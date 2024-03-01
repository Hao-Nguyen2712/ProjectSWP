/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import DAOs.AccountDAO;
import DAOs.CartDAO;
import DAOs.OrderDAO;
import DAOs.Orders_detailsDAO;
import DAOs.ProductDAO;
import DAOs.UserDAO;
import Models.Account;
import Models.Order;
import Models.Orders_details;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nguye
 */
public class OrderController extends HttpServlet {

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
            out.println("<title>Servlet OrderController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet OrderController at " + request.getContextPath() + "</h1>");
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
        if (path.endsWith("/OrderController/Order")) {
            request.getRequestDispatcher("/View/Main/order.jsp").forward(request, response);
        } else if (path.endsWith("/OrderController/Order-History")) {
            request.getRequestDispatcher("/View/Main/order_history.jsp").forward(request, response);
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
        HttpSession session = (HttpSession) request.getSession();
        if (request.getParameter("btnOrder") != null) {
            String name = request.getParameter("txtName");
            String phone = request.getParameter("txtPhone");
            String email = request.getParameter("txtEmail");
            String address = request.getParameter("txtAddress");
            Account acc = (Account) session.getAttribute("account");
            AccountDAO accDAO = new AccountDAO();
            UserDAO userDAO = new UserDAO();
            int user_id = userDAO.getUserIDWithAccID(accDAO.getAccIDWithGmail(acc.getEmail()));
            CartDAO cDAO = new CartDAO();
            int total = cDAO.getTotalMoney(user_id);
            long millis = System.currentTimeMillis();
            java.sql.Date date = new java.sql.Date(millis);
            Order order = new Order(0, user_id, null, "Waiting Accept", name, total, phone, email, address);
            OrderDAO oDAO = new OrderDAO();
            Order o = oDAO.addOrder(order, user_id);
            if (o == null) {

            } else {
                int order_id = oDAO.getOrderID(user_id);
                Orders_detailsDAO odDAO = new Orders_detailsDAO();
                Orders_details oDetails = null;
                ResultSet rs = cDAO.getProductInCart(user_id);
                ProductDAO pDAO = new ProductDAO();
                int totalDetail = 0;
                try {
                    while (rs.next()) {
                        totalDetail = 0;
                        totalDetail = rs.getInt("cart_quantity") * rs.getInt("pro_price");
                        oDetails = new Orders_details(0, order_id, rs.getInt("pro_id"), rs.getString("pro_price"), rs.getInt("cart_quantity"), totalDetail + "");
                        Orders_details od = odDAO.addOrderDetails(oDetails);
                        int newQuantity = pDAO.updateQuantityProduct(rs.getInt("cart_quantity"), rs.getInt("pro_id"));
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
                }
                cDAO.deleteCart(user_id);
                response.sendRedirect("/");
            }

        }
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
