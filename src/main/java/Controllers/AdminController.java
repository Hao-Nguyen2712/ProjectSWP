/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import DAOs.ProductDAO;
import Models.Earphone;
import Models.Keyboard;
import Models.Keycap;
import Models.Kit;
import Models.Mouse;
import Models.Product;
import Models.Switch;
import MyUtils.Excel;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.File;
import java.util.Date;
import java.util.Collection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author nguye
 */
@MultipartConfig
public class AdminController extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AdminController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminController at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        String path = request.getRequestURI();
        if (path.endsWith("/AdminController/ListProduct")) {
            request.getRequestDispatcher("/View/Main/listProduct.jsp").forward(request, response);
        } else if (path.startsWith("/AdminController/ListProduct/Create")) {
            request.getRequestDispatcher("/View/Main/addProduct.jsp").forward(request, response);
        }else if (path.startsWith("/AdminController/Thanks")) {
            request.getRequestDispatcher("/View/Main/thanks.jsp").forward(request, response);
        }  
        else if (path.startsWith("/AdminController/ListProduct/Delete")) {
            String[] s = path.split("/");
            try {
                int id = Integer.parseInt(s[s.length - 1]);
                ProductDAO pDAO = new ProductDAO();
                pDAO.deleteProduct(id);
                response.sendRedirect("/AdminController/ListProduct");
            } catch (Exception ex) {
                response.sendRedirect("/ErrorController");
            }
        } else if (path.startsWith("/AdminController/ListProduct/Edit")) {
            String[] s = path.split("/");
            try {
                int id = Integer.parseInt(s[s.length - 1]);
                ProductDAO pDAO = new ProductDAO();
                Product pro = pDAO.getProductByID(id);
                if (pro == null) {
                    response.sendRedirect("/AdminController/ListProduct");
                } else {
                    session.setAttribute("pro", pro);
                    switch (pro.getPro_category()) {
                        case "Keyboard":
                            Keyboard keyboard = pDAO.getKeyboardDetails(id);
                            if (keyboard == null) {
                                response.sendRedirect("/AdminController/ListProduct");
                            } else {
                                session.setAttribute("keyboard", keyboard);
                            }
                            break;
                        case "Keycap":
                            Keycap keycap = pDAO.getKeycapDetails(id);
                            if (keycap == null) {
                                response.sendRedirect("/AdminController/ListProduct");
                            } else {
                                session.setAttribute("keycap", keycap);
                            }
                            break;
                        case "Kit":
                            Kit kit = pDAO.getKitDetails(id);
                            if (kit == null) {
                                response.sendRedirect("/AdminController/ListProduct");
                            } else {
                                session.setAttribute("kit", kit);
                            }
                            break;

                        case "Switch":
                            Switch switchs = pDAO.getSwitchDetails(id);
                            if (switchs == null) {
                                response.sendRedirect("/AdminController/ListProduct");
                            } else {
                                session.setAttribute("switch", switchs);
                            }
                            break;

                        case "Mouse":
                            Mouse mouse = pDAO.getMouseDetails(id);
                            if (mouse == null) {
                                response.sendRedirect("/AdminController/ListProduct");
                            } else {
                                session.setAttribute("mouse", mouse);
                            }
                            break;

                        case "Earphone":
                            Earphone earphone = pDAO.getEarphoneDetails(id);
                            if (earphone == null) {
                                response.sendRedirect("/AdminController/ListProduct");
                            } else {
                                session.setAttribute("earphone", earphone);
                            }
                            break;

                    }

                }
            } catch (Exception ex) {
                response.sendRedirect("/AdminController/ListProduct");
            }
            request.getRequestDispatcher("/View/Main/editProduct.jsp").forward(request, response);
        } else if (path.endsWith("/AdminController/StatisticsDay")) {
            request.getRequestDispatcher("/View/Main/statisticDay.jsp").forward(request, response);
        } else if (path.endsWith("/AdminController/StatisticsMonth")) {
            request.getRequestDispatcher("/View/Main/statisticMonth.jsp").forward(request, response);
        } else if (path.endsWith("/AdminController/StatisticsYear")) {
            request.getRequestDispatcher("/View/Main/statisticYear.jsp").forward(request, response);
        } else if (path.endsWith("/AdminController/Export")) {
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setHeader("Content-Disposition", "attachment;filename=List.xlsx");
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("List");
            ArrayList<Excel> list = new ArrayList<>();

            ResultSet rs = (ResultSet) session.getAttribute("Result2");
            Excel excel = new Excel();
            try {
                while (rs.next()) {
                    excel = new Excel(rs.getInt("user_id"), rs.getString("user_fullname"), rs.getString("pro_name"), rs.getInt("od_quantity"), rs.getInt("order_totalMoney"), rs.getDate("order_date").toString());
                    list.add(excel);
                }
            } catch (SQLException ex) {
                Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
            int rowNo = 0;
            Row row = sheet.createRow(rowNo++);
            int cellNum = 0;
            Cell cell = row.createCell(cellNum++);
            cell.setCellValue("ID");

            cell = row.createCell(cellNum++);
            cell.setCellValue("Name");

            cell = row.createCell(cellNum++);
            cell.setCellValue("Product");

            cell = row.createCell(cellNum++);
            cell.setCellValue("Quantity");

            cell = row.createCell(cellNum++);
            cell.setCellValue("Total Money");

            cell = row.createCell(cellNum++);
            cell.setCellValue("Date");

            for (Excel e : list) {
                cellNum = 0;
                row = sheet.createRow(rowNo++);
                cell = row.createCell(cellNum++);
                cell.setCellValue(e.getUser_Id());

                cell = row.createCell(cellNum++);
                cell.setCellValue(e.getUser_Fullname());

                cell = row.createCell(cellNum++);
                cell.setCellValue(e.getPro_name());

                cell = row.createCell(cellNum++);
                cell.setCellValue(e.getOd_quantity());

                cell = row.createCell(cellNum++);
                cell.setCellValue(e.getOrder_totalMoney());

                cell = row.createCell(cellNum++);
                cell.setCellValue(e.getOrder_Date());

            }
            workbook.write(response.getOutputStream());
            workbook.close();

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
        if (request.getParameter("btnAddNew") != null) {
            String uploadPath = "C:\\Users\\thinh\\Downloads";
            // upload hinh vao thu muc
            Collection<Part> parts = request.getParts();
            String pic = "";
            for (Part part : parts) {
                String fileName = part.getSubmittedFileName();
                if (fileName != null && !fileName.isEmpty()) {
                    part.write(uploadPath + File.separator + fileName);
                    pic += "/Front/assets/image/keyboardPic/" + fileName + "&";

                } else {
                    fileName = "";
                }
            }
            String name = request.getParameter("txtName");
            String price = request.getParameter("txtPrice");
            int quantity = Integer.parseInt(request.getParameter("txtQuantity"));
            String des = request.getParameter("txtDescription");
            String discount = request.getParameter("txtDiscount");
            Date date = new Date();
            String category = request.getParameter("txtCateName");
            String brand = request.getParameter("txtBrand");
            String origin = request.getParameter("txtOrigin");
            Product newpro = new Product(0, name, quantity, price, pic, des, discount, date, category, brand, origin);
            ProductDAO pDAO = new ProductDAO();
            Product pro = pDAO.addNew(newpro);
            if (pro == null) {
                response.sendRedirect("/AdminController/ListProduct");
            } else {
                switch (category) {
                    case "Keyboard":
                        String keyboard_led = request.getParameter("led_keyboard");
                        String keyboard_mode = request.getParameter("mode_keyboard");
                        String keyboard_switch = request.getParameter("switchType_keyboard");
                        String keyboard_keycap = request.getParameter("keycapType_keyboard");
                        String keyboard_plate = request.getParameter("plate_keyboard");
                        String keyboard_case = request.getParameter("case_keyboard");
                        Keyboard newKeyboard = new Keyboard(0, keyboard_led, keyboard_mode, keyboard_switch, keyboard_keycap, keyboard_plate, keyboard_case, pDAO.getLatestPro_id());
                        Keyboard keyboard = pDAO.addNewKeyBoard(newKeyboard);
                        if (keyboard == null) {
                            response.sendRedirect("/AdminController/ListProduct");
                            pDAO.deletePro(pDAO.getLatestPro_id());
                        } else {
                            response.sendRedirect("/AdminController/ListProduct");
                        }
                        break;
                    case "Kit":
                        String kit_layout = request.getParameter("layout_kit");
                        String kit_circuit = request.getParameter("circuit_kit");
                        String kit_plate = request.getParameter("plate_kit");
                        String kit_mode = request.getParameter("mode_kit");
                        String kit_case = request.getParameter("case_kit");
                        Kit newKit = new Kit(0, kit_layout, kit_circuit, kit_plate, kit_mode, kit_case, pDAO.getLatestPro_id());
                        Kit kit = pDAO.addNewKit(newKit);
                        if (kit == null) {
                            response.sendRedirect("/AdminController/ListProduct");
                            pDAO.deletePro(pDAO.getLatestPro_id());
                        } else {
                            response.sendRedirect("/AdminController/ListProduct");
                        }
                        break;
                    case "Keycap":
                        String keycap_material = request.getParameter("material_key_cap");
                        String keycap_layout = request.getParameter("layout_keycap");
                        String keycap_thickness = request.getParameter("thickness_keycap");
                        String keycap_durability = request.getParameter("durability_keycap");
                        Keycap newKeycap = new Keycap(0, keycap_material, keycap_layout, keycap_thickness, keycap_durability, pDAO.getLatestPro_id());
                        Keycap keycap = pDAO.addNewKeycap(newKeycap);
                        if (keycap == null) {
                            response.sendRedirect("/AdminController/ListProduct");
                            pDAO.deletePro(pDAO.getLatestPro_id());
                        } else {
                            response.sendRedirect("/AdminController/ListProduct");
                        }
                        break;
                    case "Switch":
                        String switch_pin = request.getParameter("pin_switch");
                        String switch_type = request.getParameter("type_switch");
                        String switch_complexity = (request.getParameter("complexity_switch"));
                        String switch_durability = (request.getParameter("durability_switch"));
                        String switch_travel = (request.getParameter("travel_switch"));
                        Switch newSwitch = new Switch(0, switch_pin, switch_type, switch_complexity, switch_durability, switch_travel, pDAO.getLatestPro_id());
                        Switch switchs = pDAO.addNewSwitch(newSwitch);
                        if (switchs == null) {
                            response.sendRedirect("/AdminController/ListProduct");
                            pDAO.deletePro(pDAO.getLatestPro_id());
                        } else {
                            response.sendRedirect("/AdminController/ListProduct");
                        }
                        break;
                    case "Mouse":
                        String mouse_dpi = request.getParameter("dpi_mouse");
                        String mouse_wirelength = request.getParameter("wirelength_mouse");
                        String mouse_led = request.getParameter("led_mouse");
                        String mouse_typebattery = request.getParameter("typebattery_mouse");
                        String mouse_weight = request.getParameter("weight_mouse");
                        String mouse_compatibility = request.getParameter("compatibility_mouse");
                        Mouse newMouse = new Mouse(0, mouse_dpi, mouse_wirelength, mouse_led, mouse_typebattery, mouse_weight, mouse_compatibility, pDAO.getLatestPro_id());
                        Mouse mouses = pDAO.addNewMouse(newMouse);
                        if (mouses == null) {
                            response.sendRedirect("/AdminController/ListProduct");
                            pDAO.deletePro(pDAO.getLatestPro_id());
                        } else {
                            response.sendRedirect("/AdminController/ListProduct");
                        }
                        break;
                    case "Earphone":
                        String earphone_type = request.getParameter("type_earphone");
                        String earphone_plug = request.getParameter("plug_earphone");
                        String earphone_compatibility = request.getParameter("compatibility_earphone");
                        String earphone_wirelength = request.getParameter("wirelength_earphone");
                        String earphone_utility = request.getParameter("utility_earphone");
                        String earphone_connect = request.getParameter("connect_earphone");
                        String earphone_control = request.getParameter("control_earphone");
                        String earphone_chargingport = request.getParameter("chargingport_earphone");
                        String earphone_connecttech = request.getParameter("connecttech_earphone");
                        Earphone newEarphone = new Earphone(0, earphone_type, earphone_plug, earphone_compatibility, earphone_wirelength, earphone_utility, earphone_connect, earphone_control, earphone_chargingport, earphone_connecttech, pDAO.getLatestPro_id());
                        Earphone earphones = pDAO.addNewEarPhone(newEarphone);
                        if (earphones == null) {
                            response.sendRedirect("/AdminController/ListProduct");
                            pDAO.deletePro(pDAO.getLatestPro_id());
                        } else {
                            response.sendRedirect("/AdminController/ListProduct");
                        }
                        break;
                }
            }
        }

        if (request.getParameter("btnUpdate") != null) {
            String uploadPath = "D:\\Thinh\\ProjectSWP\\src\\main\\webapp\\Root\\Images\\Product";
            // upload hinh vao thu muc
            Collection<Part> parts = request.getParts();
            String pic = "";
            for (Part part : parts) {
                String fileName = part.getSubmittedFileName();
                if (fileName != null && !fileName.isEmpty()) {
                    part.write(uploadPath + File.separator + fileName);
                    pic +=  fileName + "&";
                } else {
                    fileName = "";
                }
            }
            if (pic.equals("")) {
                pic = request.getParameter("txtPicture2");
            }
            int pro_id = Integer.parseInt(request.getParameter("hiddenID"));
            String name = request.getParameter("txtName");
            String price = request.getParameter("txtPrice");
            int quantity = Integer.parseInt(request.getParameter("txtQuantity"));
            String des = request.getParameter("txtDescription");
            String discount = request.getParameter("txtDiscount");
            Date date = new Date();
            String category = request.getParameter("hiddenSelect");
            String brand = request.getParameter("txtBrand");
            String origin = request.getParameter("txtOrigin");
            Product newpro = new Product(0, name, quantity, price, pic, des, discount, date, category, brand, origin);
            ProductDAO pDAO = new ProductDAO();
            Product pro = pDAO.update(pro_id, newpro);
            if (pro == null) {
                Product oldInfo = pDAO.getProductByID(pro_id);
                HttpSession session = request.getSession();
                session.setAttribute("pro", oldInfo);
                response.sendRedirect("/ListProduct/Edit/" + pro_id);
            } else {
                switch (category) {
                    case "Keyboard":
                        String keyboard_led = request.getParameter("led_keyboard");
                        String keyboard_mode = request.getParameter("mode_keyboard");
                        String keyboard_switch = request.getParameter("switchType_keyboard");
                        String keyboard_keycap = request.getParameter("keycapType_keyboard");
                        String keyboard_plate = request.getParameter("plate_keyboard");
                        String keyboard_case = request.getParameter("case_keyboard");
                        Keyboard newKeyboard = new Keyboard(0, keyboard_led, keyboard_mode, keyboard_switch, keyboard_keycap, keyboard_plate, keyboard_case, pDAO.getLatestPro_id());
                        Keyboard keyboard = pDAO.updateKeyboard(pro_id, newKeyboard);
                        if (keyboard == null) {
                            Keyboard oldInfoKeyboard = pDAO.getKeyboardDetails(pro_id);
                            HttpSession session = request.getSession();
                            session.setAttribute("keyboard", oldInfoKeyboard);
                            response.sendRedirect("/AdminController/ListProduct/Edit/" + pro_id);
                        } else {
                            response.sendRedirect("/AdminController/ListProduct");
                        }
                        break;
                    case "Kit":
                        String kit_layout = request.getParameter("layout_kit");
                        String kit_circuit = request.getParameter("circuit_kit");
                        String kit_plate = request.getParameter("plate_kit");
                        String kit_mode = request.getParameter("mode_kit");
                        String kit_case = request.getParameter("case_kit");
                        Kit newKit = new Kit(0, kit_layout, kit_circuit, kit_plate, kit_mode, kit_case, pDAO.getLatestPro_id());
                        Kit kit = pDAO.updateKit(pro_id, newKit);
                        if (kit == null) {
                            Kit oldInfoKit = pDAO.getKitDetails(pro_id);
                            HttpSession session = request.getSession();
                            session.setAttribute("kit", oldInfoKit);
                            response.sendRedirect("/AdminController/ListProduct/Edit/" + pro_id);
                        } else {
                            response.sendRedirect("/AdminController/ListProduct");
                        }
                        break;
                    case "Keycap":
                        String keycap_material = request.getParameter("material_key_cap");
                        String keycap_layout = request.getParameter("layout_keycap");
                        String keycap_thickness = request.getParameter("thickness_keycap");
                        String keycap_durability = request.getParameter("durability_keycap");
                        Keycap newKeycap = new Keycap(0, keycap_material, keycap_layout, keycap_thickness, keycap_durability, pDAO.getLatestPro_id());
                        Keycap keycap = pDAO.updateKeycap(pro_id, newKeycap);
                        if (keycap == null) {
                            Keycap oldInfoKeycap = pDAO.getKeycapDetails(pro_id);
                            HttpSession session = request.getSession();
                            session.setAttribute("keycap", oldInfoKeycap);
                            response.sendRedirect("/AdminController/ListProduct/Edit/" + pro_id);
                        } else {
                            response.sendRedirect("/AdminController/ListProduct");
                        }
                        break;
                    case "Switch":
                        String switch_pin = request.getParameter("pin_switch");
                        String switch_type = request.getParameter("type_switch");
                        String switch_complexity = (request.getParameter("complexity_switch"));
                        String switch_durability = (request.getParameter("durability_switch"));
                        String switch_travel = (request.getParameter("travel_switch"));
                        Switch newSwitch = new Switch(0, switch_pin, switch_type, switch_complexity, switch_durability, switch_travel, pDAO.getLatestPro_id());
                        Switch switchs = pDAO.updateSwitch(pro_id, newSwitch);
                        if (switchs == null) {
                            Switch oldInfoSwitch = pDAO.getSwitchDetails(pro_id);
                            HttpSession session = request.getSession();
                            session.setAttribute("keycap", oldInfoSwitch);
                            response.sendRedirect("/AdminController/ListProduct/Edit/" + pro_id);
                        } else {
                            response.sendRedirect("/AdminController/ListProduct");
                        }
                        break;
                    case "Mouse":
                        String mouse_dpi = request.getParameter("dpi_mouse");
                        String mouse_wirelength = request.getParameter("wirelength_mouse");
                        String mouse_led = request.getParameter("led_mouse");
                        String mouse_typebattery = request.getParameter("typebattery_mouse");
                        String mouse_weight = request.getParameter("weight_mouse");
                        String mouse_compatibility = request.getParameter("compatibility_mouse");
                        Mouse newMouse = new Mouse(0, mouse_dpi, mouse_wirelength, mouse_led, mouse_typebattery, mouse_weight, mouse_compatibility, pDAO.getLatestPro_id());
                        Mouse mouses = pDAO.updateMouse(pro_id, newMouse);
                        if (mouses == null) {
                            Mouse oldInfoMouse = pDAO.getMouseDetails(pro_id);
                            HttpSession session = request.getSession();
                            session.setAttribute("keycap", oldInfoMouse);
                            response.sendRedirect("/AdminController/ListProduct/Edit/" + pro_id);
                        } else {
                            response.sendRedirect("/AdminController/ListProduct");
                        }
                        break;
                    case "Earphone":
                        String earphone_type = request.getParameter("type_earphone");
                        String earphone_plug = request.getParameter("plug_earphone");
                        String earphone_compatibility = request.getParameter("compatibility_earphone");
                        String earphone_wirelength = request.getParameter("wirelength_earphone");
                        String earphone_utility = request.getParameter("utility_earphone");
                        String earphone_connect = request.getParameter("connect_earphone");
                        String earphone_control = request.getParameter("control_earphone");
                        String earphone_chargingport = request.getParameter("chargingport_earphone");
                        String earphone_connecttech = request.getParameter("connecttech_earphone");
                        Earphone newEarphone = new Earphone(0, earphone_type, earphone_plug, earphone_compatibility, earphone_wirelength, earphone_utility, earphone_connect, earphone_control, earphone_chargingport, earphone_connecttech, pDAO.getLatestPro_id());
                        Earphone earphones = pDAO.updateEarphone(pro_id, newEarphone);
                        if (earphones == null) {
                            response.sendRedirect("/AdminController/ListProduct");
                            pDAO.deletePro(pDAO.getLatestPro_id());
                        } else {
                            response.sendRedirect("/AdminController/ListProduct");
                        }
                        break;
                }
            }
        }
        if (request.getParameter("btnSubmitForDay") != null) {
            String date = request.getParameter("dates");
            ProductDAO cDaos = new ProductDAO();
            ResultSet rs = cDaos.getProductToStatics(date);
            ResultSet rs2 = cDaos.getProductToStatics(date);
            HttpSession session = request.getSession();
            session.setAttribute("Result", rs);
            session.setAttribute("Result2", rs2);
            response.sendRedirect("/AdminController/StatisticsDay");
        }
        if (request.getParameter("btnSubmitForMonth") != null) {
            String month = request.getParameter("month");
            ProductDAO cDaos = new ProductDAO();
            ResultSet rs = cDaos.getProductToStaticsForMonth(month);
            ResultSet rs2 = cDaos.getProductToStaticsForMonth(month);
            HttpSession session = request.getSession();
            session.setAttribute("ResultMonth", rs);
            session.setAttribute("Result2", rs2);
            response.sendRedirect("/AdminController/StatisticsMonth");
        }
        if (request.getParameter("btnSubmitForYear") != null) {
            String year = request.getParameter("year");
            ProductDAO cDaos = new ProductDAO();
            ResultSet rs = cDaos.getProductToStaticsForYear(year);
            ResultSet rs2 = cDaos.getProductToStaticsForYear(year);
            HttpSession session = request.getSession();
            session.setAttribute("ResultYear", rs);
            session.setAttribute("Result2", rs2);
            response.sendRedirect("/AdminController/StatisticsYear");
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
