/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import DAOs.AccountDAO;
import DAOs.CartDAO;
import DAOs.ProductDAO;
import DAOs.UserDAO;
import Models.Account;
import Models.Earphone;
import Models.Keyboard;
import Models.Keycap;
import Models.Kit;
import Models.Mouse;
import Models.Product;
import Models.Switch;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.ResultSet;

/**
 *
 * @author nguye
 */
public class ProductController extends HttpServlet {

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
            out.println("<title>Servlet ProductController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductController at " + request.getContextPath() + "</h1>");
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
        if (path.endsWith("/ProductController/Kit-ban-phim")) {
            ProductDAO pDAO = new ProductDAO();
            ResultSet rs = pDAO.getProductByCategory("Kit");
            session.setAttribute("All", rs);
            session.setAttribute("Name", "KIT BÀN PHÍM");
            session.setAttribute("NameLower", "Kit-ban-phim");
            if (rs != null) {
                request.getRequestDispatcher("/View/Main/product.jsp").forward(request, response);
            }
        } else if (path.endsWith("/ProductController/Keyboard")) {
            ProductDAO pDAO = new ProductDAO();
            ResultSet rs = pDAO.getProductByCategory("Keyboard");
            session.setAttribute("All", rs);
            session.setAttribute("Name", "KEYBOARD");
            session.setAttribute("NameLower", "Keyboard");
            if (rs != null) {
                request.getRequestDispatcher("/View/Main/product.jsp").forward(request, response);
            }
        } else if (path.endsWith("/ProductController/Key-cap")) {
            ProductDAO pDAO = new ProductDAO();
            ResultSet rs = pDAO.getProductByCategory("Keycap");
            session.setAttribute("All", rs);
            session.setAttribute("Name", "KEYCAP");
            session.setAttribute("NameLower", "Key-cap");

            if (rs != null) {
                request.getRequestDispatcher("/View/Main/product.jsp").forward(request, response);
            }
        } else if (path.endsWith("/ProductController/Switch")) {
            ProductDAO pDAO = new ProductDAO();
            ResultSet rs = pDAO.getProductByCategory("Switch");
            session.setAttribute("All", rs);
            session.setAttribute("Name", "SWITCH");
            session.setAttribute("NameLower", "Switch");

            if (rs != null) {
                request.getRequestDispatcher("/View/Main/product.jsp").forward(request, response);
            }
        } else if (path.endsWith("/ProductController/Mouse")) {
            ProductDAO pDAO = new ProductDAO();
            ResultSet rs = pDAO.getProductByCategory("Mouse");
            session.setAttribute("All", rs);
            session.setAttribute("Name", "MOUSE");
            session.setAttribute("NameLower", "Mouse");

            if (rs != null) {
                request.getRequestDispatcher("/View/Main/product.jsp").forward(request, response);
            }
        } else if (path.endsWith("/ProductController/Earphone")) {
            ProductDAO pDAO = new ProductDAO();
            ResultSet rs = pDAO.getProductByCategory("Earphone");
            session.setAttribute("All", rs);
            session.setAttribute("Name", "Earphone");
            session.setAttribute("NameLower", "Earphone");

            if (rs != null) {
                request.getRequestDispatcher("/View/Main/product.jsp").forward(request, response);
            }
        } else {
            if (path.startsWith("/ProductController/Keyboard/")) {
                String[] s = path.split("/");
                try {
                    int id = Integer.parseInt(s[s.length - 1]);
                    ProductDAO pDAO = new ProductDAO();
                    Keyboard key = pDAO.getKeyboardDetails(id);

                    if (key == null) {
                        response.sendRedirect("/ProductController/Keyboard");
                    } else {
                        Product pro = pDAO.getProductByID(key.getPro_id());
                        String[] listImage = pro.getPro_image().split("&");
                        session.setAttribute("listImage", listImage);
                        session.setAttribute("getProduct", key);
                        session.setAttribute("typeNow", "Keyboard");
                        session.setAttribute("id_product", id);
                    }
                } catch (Exception e) {
                    response.sendRedirect("/");
                }
                request.getRequestDispatcher("/View/Main/productDetails.jsp").forward(request, response);
            } else if (path.startsWith("/ProductController/Kit-ban-phim/")) {
                String[] s = path.split("/");
                try {
                    String type = s[2];
                    int id = Integer.parseInt(s[s.length - 1]);
                    ProductDAO pDAO = new ProductDAO();

                    Kit kit = pDAO.getKitDetails(id);

                    if (kit == null) {
                        response.sendRedirect("/ProductController/Kit-ban-phim");
                    } else {
                        Product pro = pDAO.getProductByID(kit.getPro_id());

                        String[] listImage = pro.getPro_image().split("&");
                        session.setAttribute("listImage", listImage);
                        session.setAttribute("getProduct", kit);
                        session.setAttribute("typeNow", type);
                        session.setAttribute("id_product", id);
                    }
                } catch (Exception e) {
                    response.sendRedirect("/");
                }
                request.getRequestDispatcher("/View/Main/productDetails.jsp").forward(request, response);
            } else if (path.startsWith("/ProductController/Key-cap/")) {
                String[] s = path.split("/");
                try {
                    String type = s[2];
                    int id = Integer.parseInt(s[s.length - 1]);
                    ProductDAO pDAO = new ProductDAO();
                    Keycap key = pDAO.getKeycapDetails(id);
                    if (key == null) {
                        response.sendRedirect("/ProductController/Key-cap");
                    } else {
                        Product pro = pDAO.getProductByID(key.getPro_id());

                        String[] listImage = pro.getPro_image().split("&");
                        session.setAttribute("listImage", listImage);
                        session.setAttribute("getProduct", key);
                        session.setAttribute("typeNow", type);
                        session.setAttribute("id_product", id);
                    }
                } catch (Exception e) {
                    response.sendRedirect("/");
                }
                request.getRequestDispatcher("/View/Main/productDetails.jsp").forward(request, response);
            } else if (path.startsWith("/ProductController/Switch/")) {
                String[] s = path.split("/");
                try {
                    String type = s[2];
                    int id = Integer.parseInt(s[s.length - 1]);
                    ProductDAO pDAO = new ProductDAO();
                    Switch swi = pDAO.getSwitchDetails(id);

                    if (swi == null) {
                        response.sendRedirect("/ProductController/Switch");
                    } else {
                        Product pro = pDAO.getProductByID(swi.getPro_id());

                        String[] listImage = pro.getPro_image().split("&");
                        session.setAttribute("listImage", listImage);
                        session.setAttribute("getProduct", swi);
                        session.setAttribute("typeNow", type);
                        session.setAttribute("id_product", id);
                    }
                } catch (Exception e) {
                    response.sendRedirect("/");
                }
                request.getRequestDispatcher("/View/Main/productDetails.jsp").forward(request, response);
            } else if (path.startsWith("/ProductController/Mouse/")) {
                String[] s = path.split("/");
                try {
                    String type = s[2];
                    int id = Integer.parseInt(s[s.length - 1]);
                    ProductDAO pDAO = new ProductDAO();
                    Mouse mouse = pDAO.getMouseDetails(id);

                    if (mouse == null) {
                        response.sendRedirect("/ProductController/Mouse");
                    } else {
                        Product pro = pDAO.getProductByID(mouse.getPro_id());

                        String[] listImage = pro.getPro_image().split("&");
                        session.setAttribute("listImage", listImage);
                        session.setAttribute("getProduct", mouse);
                        session.setAttribute("typeNow", type);
                        session.setAttribute("id_product", id);
                    }
                } catch (Exception e) {
                    response.sendRedirect("/");
                }
                request.getRequestDispatcher("/View/Main/productDetails.jsp").forward(request, response);
            } else if (path.startsWith("/ProductController/Earphone/")) {
                String[] s = path.split("/");
                try {
                    String type = s[2];
                    int id = Integer.parseInt(s[s.length - 1]);
                    ProductDAO pDAO = new ProductDAO();
                    Earphone earphone = pDAO.getEarphoneDetails(id);

                    if (earphone == null) {
                        response.sendRedirect("/ProductController/Earphone");
                    } else {
                        Product pro = pDAO.getProductByID(earphone.getPro_id());

                        String[] listImage = pro.getPro_image().split("&");
                        session.setAttribute("listImage", listImage);
                        session.setAttribute("getProduct", earphone);
                        session.setAttribute("typeNow", type);
                        session.setAttribute("id_product", id);
                    }
                } catch (Exception e) {
                    response.sendRedirect("/");
                }
                request.getRequestDispatcher("/View/Main/productDetails.jsp").forward(request, response);
            } else {
                response.sendRedirect("/");
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
        AccountDAO accDAO = new AccountDAO();
        ProductDAO proDAO = new ProductDAO();
        UserDAO userDAO = new UserDAO();
        CartDAO cDAO = new CartDAO();
        String path = request.getRequestURI();
        HttpSession session = (HttpSession) request.getSession();
        String[] s = path.split("/");
        int id = (int) session.getAttribute("id_product");
        String type = s[2];
        String username = "";
        Cookie[] cList = request.getCookies();
        for (int i = 0; i < cList.length; i++) {
            if (cList[i].getName().equals("login")) {
                username = cList[i].getValue();
                break;
            }
        }
        if (username.equals("")) {
            session.setAttribute("status", "login");
            response.sendRedirect("/ProductController/" + type + "/" + id);
        } else {
            if (request.getParameter("btnAddCart") != null) {
                int quantity = Integer.parseInt(request.getParameter("txtQuantity"));
                int pro_quantity = proDAO.getProductQuantity(id);
                Account acc = (Account) session.getAttribute("account");
                int acc_id = accDAO.getAccIDWithGmail(acc.getEmail());
                int user_id = userDAO.getUserIDWithAccID(acc_id);
                
                if (quantity > pro_quantity) {
                    session.setAttribute("status", "ErrorAddtoCart");
                    response.sendRedirect("/ProductController/" + type + "/" + id);
                } else {
                    if (!cDAO.checkContainCart(id, user_id)) {
                        if (cDAO.updateQuantityProductInCart(quantity, id, user_id) != 0) {
                            session.setAttribute("status", "success");
                        } else {
                            session.setAttribute("status", "success");
                        }
                        response.sendRedirect("/ProductController/" + type + "/" + id);
                    } else {
                        boolean b = cDAO.addCard(id, quantity, user_id);
                        if (b) {
                            session.setAttribute("status", "success");
                        } else {
                            session.setAttribute("status", "error");
                        }
                        response.sendRedirect("/ProductController/" + type + "/" + id);
                    }

                }
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
