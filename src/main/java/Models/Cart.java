/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Laptop
 */
public class Cart {

    private int cart_id;
    private int user_id;
    private int pro_id;
    private int cart_quantity;

    public Cart() {
    }

    public Cart(int cart_id, int user_id, int cart_quantity, int pro_id) {
        this.cart_id = cart_id;
        this.user_id = user_id;
        this.pro_id = pro_id;
        this.cart_quantity = cart_quantity;
    }

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getPro_id() {
        return pro_id;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }

    public int getCart_quantity() {
        return cart_quantity;
    }

    public void setCart_quantity(int cart_quantity) {
        this.cart_quantity = cart_quantity;
    }

}
