/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Models.Earphone;
import Models.Keyboard;
import Models.Keycap;
import Models.Kit;
import Models.Mouse;
import Models.Product;
import Models.Switch;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HIEU
 */
public class ProductDAO {

    Connection conn;

    public ProductDAO() {
        try {
            conn = DB.DBConnection.connect();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet getAllProduct() {
        ResultSet rs = null;

        Statement st;
        try {
            st = conn.createStatement();
            rs = st.executeQuery("select * from Product");
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public ResultSet getProCategory() {
        ResultSet rs = null;

        Statement st;
        try {
            st = conn.createStatement();
            rs = st.executeQuery("select distinct pro_category from Product");
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public void deleteProduct(int pro_id) {
        try {
            PreparedStatement ps = conn.prepareStatement("update product set pro_quantity = 0 where pro_id =?");
            ps.setInt(1, pro_id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getLatestPro_id() {
        ResultSet rs = null;
        int pro_id = 0;
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT top 1 pro_id FROM Product ORDER BY pro_id DESC");
            rs = ps.executeQuery();
            if (rs.next()) {
                pro_id = rs.getInt("pro_id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pro_id;
    }

    public void deletePro(int pro_id) {
        try {
            PreparedStatement ps = conn.prepareStatement("delete from product where pro_id =?");
            ps.setInt(1, pro_id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Product addNew(Product newPro) {
        java.util.Date dateToInsert = new java.util.Date();
        Date sqlDate = new Date(dateToInsert.getTime());
        int count = 0;
        ResultSet rs = null;
        try {
            PreparedStatement ps = conn.prepareStatement("Insert into product values(?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, newPro.getPro_name());
            ps.setInt(2, newPro.getPro_quantity());
            ps.setString(3, newPro.getPro_price());
            ps.setString(4, newPro.getPro_image());
            ps.setString(5, newPro.getPro_description());
            ps.setString(6, newPro.getPro_discount());
            ps.setDate(7, sqlDate);
            ps.setString(8, newPro.getPro_category());
            ps.setString(9, newPro.getPro_brand());
            ps.setString(10, newPro.getPro_origin());

            count = ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (count == 0) ? null : newPro;
    }

    public Keyboard addNewKeyBoard(Keyboard newKeyboard) {
        int count = 0;
        ResultSet rs = null;
        try {
            PreparedStatement ps = conn.prepareStatement("Insert into KeyBoard values(?,?,?,?,?,?,?)");
            ps.setString(1, newKeyboard.getKb_led());
            ps.setString(2, newKeyboard.getKb_mode());
            ps.setString(3, newKeyboard.getKb_switch());
            ps.setString(4, newKeyboard.getKb_keycap());
            ps.setString(5, newKeyboard.getKb_plate());
            ps.setString(6, newKeyboard.getKb_case());
            ps.setInt(7, newKeyboard.getPro_id());
            count = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (count == 0) ? null : newKeyboard;
    }

    public Kit addNewKit(Kit newKit) {
        int count = 0;
        ResultSet rs = null;
        try {
            PreparedStatement ps = conn.prepareStatement("Insert into Kit values(?,?,?,?,?,?)");
            ps.setString(1, newKit.getLayout());
            ps.setString(2, newKit.getCircuit());
            ps.setString(3, newKit.getPlate());
            ps.setString(4, newKit.getMode());
            ps.setString(5, newKit.getKitCase());
            ps.setInt(6, newKit.getPro_id());
            count = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (count == 0) ? null : newKit;
    }

    public Keycap addNewKeycap(Keycap newKeycap) {
        int count = 0;
        ResultSet rs = null;
        try {
            PreparedStatement ps = conn.prepareStatement("Insert into Keycap values(?,?,?,?,?)");
            ps.setString(1, newKeycap.getKc_material());
            ps.setString(2, newKeycap.getKc_layout());
            ps.setString(3, newKeycap.getKc_thicknessl());
            ps.setString(4, newKeycap.getKc_reliability());
            ps.setInt(5, newKeycap.getPro_id());
            count = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (count == 0) ? null : newKeycap;
    }

    public Switch addNewSwitch(Switch newSwitch) {
        int count = 0;
        ResultSet rs = null;
        try {
            PreparedStatement ps = conn.prepareStatement("Insert into Switch values(?,?,?,?,?,?)");
            ps.setString(1, newSwitch.getSw_pin());
            ps.setString(2, newSwitch.getSw_type());
            ps.setString(3, newSwitch.getSw_spring());
            ps.setString(4, newSwitch.getSw_reliability());
            ps.setString(5, newSwitch.getSw_depth());
            ps.setInt(6, newSwitch.getPro_id());
            count = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (count == 0) ? null : newSwitch;
    }

    public Mouse addNewMouse(Mouse newMouse) {
        int count = 0;
        ResultSet rs = null;
        try {
            PreparedStatement ps = conn.prepareStatement("Insert into Mouse values(?,?,?,?,?,?,?)");
            ps.setString(1, newMouse.getMouse_dpi());
            ps.setString(2, newMouse.getMouse_wireLength());
            ps.setString(3, newMouse.getMouse_led());
            ps.setString(4, newMouse.getMouse_typeBattery());
            ps.setString(5, newMouse.getMouse_weight());
            ps.setString(6, newMouse.getMouse_compatibility());
            ps.setInt(7, newMouse.getPro_id());
            count = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (count == 0) ? null : newMouse;
    }

    public Earphone addNewEarPhone(Earphone newEarPhone) {
        int count = 0;
        ResultSet rs = null;
        try {
            PreparedStatement ps = conn.prepareStatement("Insert into Earphone values(?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, newEarPhone.getEar_type());
            ps.setString(2, newEarPhone.getEar_plug());
            ps.setString(3, newEarPhone.getEar_compatibility());
            ps.setString(4, newEarPhone.getEar_wireLength());
            ps.setString(5, newEarPhone.getEar_utility());
            ps.setString(6, newEarPhone.getEar_connect());
            ps.setString(7, newEarPhone.getEar_control());
            ps.setString(8, newEarPhone.getEar_chargingPort());
            ps.setString(9, newEarPhone.getEar_connectTeach());
            ps.setInt(10, newEarPhone.getPro_id());
            count = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (count == 0) ? null : newEarPhone;
    }

    public Product getProductByID(int pro_id) {
        Product pro = null;
        try {
            PreparedStatement ps = conn.prepareStatement("select * from product where pro_id= ?");
            ps.setInt(1, pro_id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pro = new Product(rs.getInt("pro_id"), rs.getString("pro_name"), rs.getInt("pro_quantity"), rs.getString("pro_price"), rs.getString("pro_image"), rs.getString("pro_description"), rs.getString("pro_discount"), rs.getDate("pro_date"), rs.getString("pro_category"), rs.getString("pro_brand"), rs.getString("pro_origin"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pro;
    }

    public Keyboard getKeyboardDetails(int pro_id) {
        ResultSet rs = null;
        Keyboard keyboard = null;
        try {
            PreparedStatement ps = conn.prepareStatement("select * from Keyboard  where pro_id=?");
            ps.setInt(1, pro_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                keyboard = new Keyboard(rs.getInt("kb_id"), rs.getString("kb_led"), rs.getString("kb_mode"), rs.getString("kb_switch"), rs.getString("kb_keycap"), rs.getString("kb_plate"), rs.getString("kb_case"), rs.getInt("pro_id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return keyboard;
    }

    public Keycap getKeycapDetails(int pro_id) {
        ResultSet rs = null;
        Keycap keycap = null;
        try {
            PreparedStatement ps = conn.prepareStatement("select * from Keycap where pro_id=?");
            ps.setInt(1, pro_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                keycap = new Keycap(rs.getInt("kc_id"), rs.getString("kc_material"), rs.getString("kc_layout"), rs.getString("kc_thickness"), rs.getString("kc_reliability"), rs.getInt("pro_id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return keycap;
    }

    public Kit getKitDetails(int pro_id) {
        ResultSet rs = null;
        Kit kit = null;
        try {
            PreparedStatement ps = conn.prepareStatement("select * from Kit where pro_id=?");
            ps.setInt(1, pro_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                kit = new Kit(rs.getInt("kit_id"), rs.getString("kit_layout"), rs.getString("kit_circuit"), rs.getString("kit_plate"), rs.getString("kit_mode"), rs.getString("kit_case"), rs.getInt("pro_id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kit;
    }

    public Switch getSwitchDetails(int pro_id) {
        ResultSet rs = null;
        Switch Switch = null;
        try {
            PreparedStatement ps = conn.prepareStatement("select * from Switch where pro_id=?");
            ps.setInt(1, pro_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Switch = new Switch(rs.getInt("switch_id"), rs.getString("switch_pin"), rs.getString("switch_type"), rs.getString("switch_spring"), rs.getString("switch_reliability"), rs.getString("switch_depth"), rs.getInt("pro_id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Switch;
    }

    public Mouse getMouseDetails(int pro_id) {
        ResultSet rs = null;
        Mouse mouse = null;
        try {
            PreparedStatement ps = conn.prepareStatement("select * from Mouse where pro_id=?");
            ps.setInt(1, pro_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                mouse = new Mouse(rs.getInt("mouse_id"), rs.getString("mouse_dpi"), rs.getString("mouse_wire_length"), rs.getString("mouse_led"), rs.getString("mouse_type_battery"), rs.getString("mouse_weight"), rs.getString("mouse_compatibility"), rs.getInt("pro_id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mouse;
    }

    public Earphone getEarphoneDetails(int pro_id) {
        ResultSet rs = null;
        Earphone earphone = null;
        try {
            PreparedStatement ps = conn.prepareStatement("select * from Earphone where pro_id=?");
            ps.setInt(1, pro_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                earphone = new Earphone(rs.getInt("ear_id"), rs.getString("ear_type"), rs.getString("ear_plug"), rs.getString("ear_compatibility"), rs.getString("ear_wire_length"), rs.getString("ear_utility"), rs.getString("ear_connect"), rs.getString("ear_control"), rs.getString("ear_charging_port"), rs.getString("ear_connect_tech"), rs.getInt("pro_id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return earphone;
    }

    public Product update(int pro_id, Product newinfo) {
        int count = 0;
        try {
            PreparedStatement ps = conn.prepareStatement("update product set pro_name=?, pro_quantity=?, pro_price=?, pro_image=?, pro_description=?, pro_discount=?, pro_category=?, pro_brand=?, pro_origin=? where pro_id=?");
            ps.setString(1, newinfo.getPro_name());
            ps.setInt(2, newinfo.getPro_quantity());
            ps.setString(3, newinfo.getPro_price());
            ps.setString(4, newinfo.getPro_image());
            ps.setString(5, newinfo.getPro_description());
            ps.setString(6, newinfo.getPro_discount());
            ps.setString(7, newinfo.getPro_category());
            ps.setString(8, newinfo.getPro_brand());
            ps.setString(9, newinfo.getPro_origin());
            ps.setInt(10, pro_id);
            count = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (count == 0) ? null : newinfo;
    }

    public Keyboard updateKeyboard(int pro_id, Keyboard newinfoKeyboard) {
        int count = 0;
        try {
            PreparedStatement ps = conn.prepareStatement("update keyboard set kb_led=?, kb_mode=?, kb_switch=?, kb_keycap=?, kb_plate=?, kb_case=?  where pro_id=?");
            ps.setString(1, newinfoKeyboard.getKb_led());
            ps.setString(2, newinfoKeyboard.getKb_mode());
            ps.setString(3, newinfoKeyboard.getKb_switch());
            ps.setString(4, newinfoKeyboard.getKb_keycap());
            ps.setString(5, newinfoKeyboard.getKb_plate());
            ps.setString(6, newinfoKeyboard.getKb_case());
            ps.setInt(7, pro_id);
            count = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (count == 0) ? null : newinfoKeyboard;
    }

    public Kit updateKit(int pro_id, Kit newinfoKit) {
        int count = 0;
        try {
            PreparedStatement ps = conn.prepareStatement("update kit set kit_layout=?, kit_circuit=?, kit_plate=?, kit_mode=?, kit_case=? where pro_id=?");
            ps.setString(1, newinfoKit.getLayout());
            ps.setString(2, newinfoKit.getCircuit());
            ps.setString(3, newinfoKit.getPlate());
            ps.setString(4, newinfoKit.getMode());
            ps.setString(5, newinfoKit.getKitCase());
            ps.setInt(6, pro_id);
            count = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (count == 0) ? null : newinfoKit;
    }

    public Keycap updateKeycap(int pro_id, Keycap newinfoKeycap) {
        int count = 0;
        try {
            PreparedStatement ps = conn.prepareStatement("update keycap set kc_material=?, kc_layout=?, kc_thickness=?, kc_reliability=? where pro_id=?");
            ps.setString(1, newinfoKeycap.getKc_material());
            ps.setString(2, newinfoKeycap.getKc_layout());
            ps.setString(3, newinfoKeycap.getKc_thicknessl());
            ps.setString(4, newinfoKeycap.getKc_reliability());
            ps.setInt(5, pro_id);
            count = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (count == 0) ? null : newinfoKeycap;
    }

    public Switch updateSwitch(int pro_id, Switch newinfoSwitch) {
        int count = 0;
        try {
            PreparedStatement ps = conn.prepareStatement("update switch set switch_pin=?, switch_type=?, switch_spring=?, switch_reliability=?, switch_depth=? where pro_id=?");
            ps.setString(1, newinfoSwitch.getSw_pin());
            ps.setString(2, newinfoSwitch.getSw_type());
            ps.setString(3, newinfoSwitch.getSw_spring());
            ps.setString(4, newinfoSwitch.getSw_reliability());
            ps.setString(5, newinfoSwitch.getSw_depth());
            ps.setInt(6, pro_id);
            count = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (count == 0) ? null : newinfoSwitch;
    }

    public Mouse updateMouse(int pro_id, Mouse newinfoMouse) {
        int count = 0;
        try {
            PreparedStatement ps = conn.prepareStatement("update mouse set mouse_dpi=?, mouse_wire_length=?, mouse_led=?, mouse_type_battery=?, mouse_weight=?, mouse_compatibility=? where pro_id=?");
            ps.setString(1, newinfoMouse.getMouse_dpi());
            ps.setString(2, newinfoMouse.getMouse_wireLength());
            ps.setString(3, newinfoMouse.getMouse_led());
            ps.setString(4, newinfoMouse.getMouse_typeBattery());
            ps.setString(5, newinfoMouse.getMouse_weight());
            ps.setString(6, newinfoMouse.getMouse_weight());
            ps.setInt(7, pro_id);
            count = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (count == 0) ? null : newinfoMouse;
    }

    public Earphone updateEarphone(int pro_id, Earphone newinfoEarphone) {
        int count = 0;
        try {
            PreparedStatement ps = conn.prepareStatement("update switch set ear_type=?, ear_plug=?, ear_compatibility=?, ear_wire_length=?, ear_utility=?, ear_connect=?, ear_control=?,  ear_charging_port=?, ear_connect_tech=?  where pro_id=?");
            ps.setString(1, newinfoEarphone.getEar_type());
            ps.setString(2, newinfoEarphone.getEar_plug());
            ps.setString(3, newinfoEarphone.getEar_compatibility());
            ps.setString(4, newinfoEarphone.getEar_wireLength());
            ps.setString(5, newinfoEarphone.getEar_utility());
            ps.setString(6, newinfoEarphone.getEar_connect());
            ps.setString(7, newinfoEarphone.getEar_control());
            ps.setString(8, newinfoEarphone.getEar_chargingPort());
            ps.setString(9, newinfoEarphone.getEar_connectTeach());
            ps.setInt(10, pro_id);
            count = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (count == 0) ? null : newinfoEarphone;
    }

    public ResultSet getProductByCategory(String pro_category) {
        ResultSet rs = null;
        try {
            PreparedStatement ps = conn.prepareStatement("select * from Product where pro_category=?");
            ps.setString(1, pro_category);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public ResultSet getSimilarProduct(String category, int pro_id) {
        ResultSet rs = null;
        try {
            PreparedStatement ps = conn.prepareStatement("select * from Product p where pro_id != ? and p.pro_category=?");
            ps.setInt(1, pro_id);
            ps.setString(2, category);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public boolean addCard(int id, int quantity, String username) {
        int count = 0;
        try {
            PreparedStatement ps = conn.prepareStatement("Insert into Cart values(?,?,?)");
            ps.setString(1, username);
            ps.setInt(2, id);
            ps.setInt(3, quantity);
            count = ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (count != 0);
    }

    public int updateQuantityProduct(int quantity, int pro_id) {
        int count = 0;

        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE product SET pro_quantity = pro_quantity - ? WHERE pro_id = ?");
            ps.setInt(1, quantity);
            ps.setInt(2, pro_id);
            count = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return count;
    }

    public int getProductQuantity(int pro_id) {
        int quantity = 0;
        ResultSet rs = null;
        try {
            PreparedStatement ps = conn.prepareStatement("Select * from Product where pro_id = ?");
            ps.setInt(1, pro_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                quantity = rs.getInt("pro_quantity");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return quantity;
    }

    public Product getProduct(int pro_id) {
        Product pro = null;
        try {
            PreparedStatement ps = conn.prepareStatement("select * from product where pro_id= ?");
            ps.setInt(1, pro_id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pro = new Product(rs.getInt("pro_id"), rs.getString("pro_name"), rs.getInt("pro_quantity"), rs.getString("pro_price"), rs.getString("pro_image"), rs.getString("pro_description"), rs.getString("pro_discount"), rs.getDate("pro_date"), rs.getString("pro_category"), rs.getString("pro_brand"), rs.getString("pro_origin"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pro;
    }

    public List<Product> getProductSearch(String pro_name) {
        List<Product> list = new ArrayList<>();
        ResultSet rs = null;
        try {
            PreparedStatement ps = conn.prepareStatement("select * from Product where pro_name like ?");
            ps.setString(1, "%" + pro_name + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Product pro = new Product();
                pro.setPro_id(rs.getInt("pro_id"));
                pro.setPro_name(rs.getString("pro_name"));
                pro.setPro_quantity(rs.getInt("pro_quantity"));
                pro.setPro_price(rs.getString("pro_price"));
                pro.setPro_image(rs.getString("pro_image"));
                pro.setPro_description(rs.getString("pro_description"));
                pro.setPro_discount(rs.getString("pro_discount"));
                pro.setPro_category(rs.getString("pro_category"));
                list.add(pro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ResultSet getNewProduct() {
        ResultSet rs = null;

        Statement st;
        try {
            st = conn.createStatement();
            rs = st.executeQuery("select top 8 * from Product order by pro_id desc");
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public ResultSet get2NewProduct() {
        ResultSet rs = null;

        Statement st;
        try {
            st = conn.createStatement();
            rs = st.executeQuery("select top 2 * from Product order by pro_id desc");
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public ResultSet getProductToStatics(String str) {
        ResultSet rs = null;
        try {
            Date date = Date.valueOf(str);
            PreparedStatement ps = conn.prepareStatement("SELECT o.user_id ,u.user_fullname,p.pro_name,od.od_quantity, o.order_totalMoney, o.order_date\n"
                    + "FROM Order_details od \n"
                    + "join Orders o on od.order_id = o.order_id\n"
                    + "join \"User\" u  on u.user_id =  o.user_id\n"
                    + "join Cart c on c.user_id =  o.user_id\n"
                    + "join Product p on p.pro_id = c.pro_id\n"
                    + "where o.order_date = ? and o.order_status ='Accept'");
            ps.setDate(1, date);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }

    public ResultSet getProductToStaticsForMonth(String str) {
        ResultSet rs = null;
        try {
            int month = Integer.parseInt(str);

            PreparedStatement ps = conn.prepareStatement("SELECT o.user_id ,u.user_fullname,p.pro_name,od.od_quantity, o.order_totalMoney, o.order_date\n"
                    + "FROM Order_details od join Orders o on od.order_id = o.order_id\n"
                    + "join \"User\" u  on u.user_id =  o.user_id\n"
                    + "join Cart c on c.user_id =  o.user_id\n"
                    + "join Product p on p.pro_id = c.pro_id\n"
                    + "where MONTH(order_date) = ? and o.order_status ='Accept'");
            ps.setInt(1, month);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }

    public ResultSet getProductToStaticsForYear(String str) {
        ResultSet rs = null;
        try {
            int month = Integer.parseInt(str);

            PreparedStatement ps = conn.prepareStatement("SELECT o.user_id ,u.user_fullname,p.pro_name,od.od_quantity, o.order_totalMoney, o.order_date\n"
                    + "FROM Order_details od join Orders o on od.order_id = o.order_id\n"
                    + "join \"User\" u  on u.user_id =  o.user_id\n"
                    + "join Cart c on c.user_id =  o.user_id\n"
                    + "join Product p on p.pro_id = c.pro_id\n"
                    + "where YEAR(order_date) = ? and o.order_status ='Accept'");
            ps.setInt(1, month);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }

}
