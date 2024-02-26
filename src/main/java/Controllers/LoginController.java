/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import DAOs.AccountDAO;
import DAOs.UserDAO;
import Models.Account;
import Models.User;
import MyUtils.SendEmail;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Random;

/**
 *
 * @author nguye
 */
public class LoginController extends HttpServlet {

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
            out.println("<title>Servlet LoginController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginController at " + request.getContextPath() + "</h1>");
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
        String part = request.getRequestURI();
        if (part.endsWith("login")) {
            request.getRequestDispatcher("/View/Main/login.jsp").forward(request, response);
        } else if (part.endsWith("Signup")) {
            request.getRequestDispatcher("/View/Main/signup.jsp").forward(request, response);
        } else if (part.endsWith("Confirm")) {
            request.getRequestDispatcher("/View/Main/confirm.jsp").forward(request, response);
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
        HttpSession session = request.getSession();
        AccountDAO aDAO = new AccountDAO();
        
        if (request.getParameter("btnLogin") != null) {
            String gmail = request.getParameter("gmail");
            String password = request.getParameter("password");
            Account acc = aDAO.checkLogin(gmail, password);
            if (acc != null) {
                Cookie cookie = new Cookie("login", gmail);
                cookie.setMaxAge(3 * 24 * 60 * 60);
                cookie.setPath("/");
                response.addCookie(cookie);
                
                session.setAttribute("account", acc);
                response.sendRedirect("/");
            } else {
                session.setAttribute("status", "ErrorLogin");
                response.sendRedirect("/LoginController/login");
            }
        }
        
        if (request.getParameter("btnSignUP") != null) {
            String email = request.getParameter("email");
            String password = request.getAttribute("password").toString();
            String fulName = request.getParameter("fullName");
            String address = request.getParameter("address");
            String phone = request.getParameter("phone");
            
            boolean flag = aDAO.checkSignIn(email);
            if (!flag) {
                session.setAttribute("status", "ErrorSignIn");
                response.sendRedirect("/LoginController/Signup");
            } else {
                
                Account account = new Account(0, email, password);
                User user = new User(0, fulName, phone, address, 0);
                
                Random random = new Random();
                int ranNumber = random.nextInt(999999 - 100000 + 1) + 100000;
                SendEmail mail = new SendEmail();
                String formEmail = mail.formVerifyEmail(ranNumber, fulName);
                SendEmail.sendEmail(email, "Verify email", formEmail);
                session.setAttribute("account", account);
                session.setAttribute("user", user);
                session.setAttribute("code", ranNumber);
                session.setAttribute("status", "success");
                request.getRequestDispatcher("/View/Main/confirm.jsp").forward(request, response);
                
            }
        }
        
        if (request.getParameter("btnConfirm") != null) {
            Account acc = (Account) session.getAttribute("account");
            User user = (User) session.getAttribute("user");
            
            int code = (int) session.getAttribute("code");
            int codeConfirm = Integer.parseInt(request.getParameter("code"));
            if (code == codeConfirm) {
                Account accAdd = aDAO.addAccount(acc);
                if (accAdd != null) {
                    // add user in sql server
                    UserDAO uDAO = new UserDAO();
                    User users = uDAO.addUser(user);
                    if (users != null) {
                        // messages susscess
                session.setAttribute("status", "success");
                response.sendRedirect("/LoginController/login");
                    } else {
                        // messages error 
                        session.setAttribute("status", "error");
                        response.sendRedirect("/LoginController/Signup");
                    }
                } else {
                    // messages error 
                    session.setAttribute("status", "error");
                    response.sendRedirect("/LoginController/Signup");
                }
            } else {
                session.setAttribute("status", "error");
                response.sendRedirect("/LoginController/Confirm");
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
