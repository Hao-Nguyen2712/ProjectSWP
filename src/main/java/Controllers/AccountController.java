/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import DAOs.AccountDAO;
import DAOs.UserDAO;
import Models.Account;
import Models.User;
import MyUtils.MD5;
import MyUtils.SendEmail;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Random;

/**
 *
 * @author nguye
 */
public class AccountController extends HttpServlet {

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
            out.println("<title>Servlet AccountController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AccountController at " + request.getContextPath() + "</h1>");
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
        if (part.endsWith("Restpassword")) {
            request.getRequestDispatcher("/View/Main/resetPassword.jsp").forward(request, response);
        } else if (part.endsWith("rePassword")) {
            request.getRequestDispatcher("/View/Main/enterPassword.jsp").forward(request, response);
        } else if (part.endsWith("ChangePassword")) {
            request.getRequestDispatcher("/View/Main/changePassword.jsp").forward(request, response);
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
        UserDAO uDAO = new UserDAO();

        if (request.getParameter("btnEmail") != null) {
            String email = request.getParameter("email");
            Account account = aDAO.getAccount(email);
            if (account != null) {
                User user = uDAO.getUser(email);
                Random random = new Random();
                int ranNumber = random.nextInt(999999 - 100000 + 1) + 100000;
                SendEmail mail = new SendEmail();
                String formEmail = mail.formVerifyEmail(ranNumber, user.getUser_fullName());
                SendEmail.sendEmail(email, "Verify email", formEmail);
                session.setAttribute("account", account);
                session.setAttribute("user", user);
                session.setAttribute("code", ranNumber);
                session.setAttribute("action", "AccountController");
                request.getRequestDispatcher("/View/Main/confirm.jsp").forward(request, response);
            } else {
                session.setAttribute("status", "error");
                response.sendRedirect("/AccountController/Restpassword");
            }
        }

        if (request.getParameter("btnConfirm") != null) {
            int code = (int) session.getAttribute("code");
            int codeConfirm = Integer.parseInt(request.getParameter("code"));

            String check = request.getParameter("check");
            if (check.equals("rePassword")) {
                if (code == codeConfirm) {
                    response.sendRedirect("/AccountController/rePassword");
                } else {
                    session.setAttribute("status", "error");
                    response.sendRedirect("/AccountController/Confirm");
                }
            } else {
                if (code == codeConfirm) {
                    session.setAttribute("status", "success");
                    response.sendRedirect("/HomeController/User");
                } else {
                    session.setAttribute("status", "error");
                    response.sendRedirect("/AccountController/Confirm");
                }
            }

        }

        if (request.getParameter("btnPassword") != null) {
            Account account = (Account) session.getAttribute("account");
            String password = request.getParameter("rePassword");
            String pass_hash = MyUtils.MD5.getMd5(password);
            Account acc = aDAO.updateAccount(account, pass_hash);
            if (acc != null) {
                session.setAttribute("status", "success");
                response.sendRedirect("/LoginController/login");
            } else {
                response.sendRedirect("/AccountController/rePassword");
            }
        }

        if (request.getParameter("btnChangePassword") != null) {
            Account acc = (Account) session.getAttribute("account");
            String password = request.getParameter("oldPassword");
            String pass_hash = MD5.getMd5(password);

            if (pass_hash.endsWith(acc.getPassword())) {
                User user = uDAO.getUser(acc.getEmail());
                Random random = new Random();
                int ranNumber = random.nextInt(999999 - 100000 + 1) + 100000;
                SendEmail mail = new SendEmail();
                String formEmail = mail.formVerifyEmail(ranNumber, user.getUser_fullName());
                SendEmail.sendEmail(acc.getEmail(), "Verify email", formEmail);
                session.setAttribute("code", ranNumber);
                session.setAttribute("action", "AccountController");
                request.getRequestDispatcher("/View/Main/confirm.jsp").forward(request, response);
            } else {
                session.setAttribute("status", "error");
                response.sendRedirect("/AccountController/ChangePassword");
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
