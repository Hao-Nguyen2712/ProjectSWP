/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MyUtils;

import java.util.Date;

/**
 * class dung de format Excel
 *
 * @author joonn
 */
public class Excel {

    private int user_Id;
    private String user_Fullname;
    private String pro_name;
    private int od_quantity;
    private int order_totalMoney;
    private String order_Date;

    public Excel() {
    }

    public Excel(int user_Id, String user_Fullname, String pro_name, int od_quantity, int order_totalMoney, String order_Date) {
        this.user_Id = user_Id;
        this.user_Fullname = user_Fullname;
        this.pro_name = pro_name;
        this.od_quantity = od_quantity;
        this.order_totalMoney = order_totalMoney;
        this.order_Date = order_Date;
    }

    public String getOrder_Date() {
        return order_Date;
    }

    public void setOrder_Date(String order_Date) {
        this.order_Date = order_Date;
    }



    public int getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(int user_Id) {
        this.user_Id = user_Id;
    }

    public String getUser_Fullname() {
        return user_Fullname;
    }

    public void setUser_Fullname(String user_Fullname) {
        this.user_Fullname = user_Fullname;
    }

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public int getOd_quantity() {
        return od_quantity;
    }

    public void setOd_quantity(int od_quantity) {
        this.od_quantity = od_quantity;
    }

    public int getOrder_totalMoney() {
        return order_totalMoney;
    }

    public void setOrder_totalMoney(int order_totalMoney) {
        this.order_totalMoney = order_totalMoney;
    }

}
