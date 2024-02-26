/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.sql.Date;

/**
 *
 * @author HIEU
 */
public class Product {

    private int pro_id;
    private String pro_name;
    private int pro_quantity;
    private String pro_price;
    private String pro_image;
    private String pro_description;
    private String pro_discount;
    private String pro_category;
    

    public Product() {
    }

    public Product(int pro_id, String pro_name, int pro_quantity, String pro_price, String pro_image, String pro_description, String pro_discount, String pro_category) {
        this.pro_id = pro_id;
        this.pro_name = pro_name;
        this.pro_quantity = pro_quantity;
        this.pro_price = pro_price;
        this.pro_image = pro_image;
        this.pro_description = pro_description;
        this.pro_discount = pro_discount;
        this.pro_category = pro_category;
    }

    public int getPro_id() {
        return pro_id;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public int getPro_quantity() {
        return pro_quantity;
    }

    public void setPro_quantity(int pro_quantity) {
        this.pro_quantity = pro_quantity;
    }

    public String getPro_price() {
        return pro_price;
    }

    public void setPro_price(String pro_price) {
        this.pro_price = pro_price;
    }

    public String getPro_image() {
        return pro_image;
    }

    public void setPro_image(String pro_image) {
        this.pro_image = pro_image;
    }

    public String getPro_description() {
        return pro_description;
    }

    public void setPro_description(String pro_description) {
        this.pro_description = pro_description;
    }

    public String getPro_discount() {
        return pro_discount;
    }

    public void setPro_discount(String pro_discount) {
        this.pro_discount = pro_discount;
    }

    public String getPro_category() {
        return pro_category;
    }

    public void setPro_category(String pro_category) {
        this.pro_category = pro_category;
    }

}
