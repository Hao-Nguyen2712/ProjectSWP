/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author HIEU
 */
public class Switch {

    private int switch_id;
    private String switch_pin;
    private String switch_type;
    private String switch_spring;
    private String switch_reliability;
    private String switch_depth;
    private Product pro_id;

    public Switch() {
    }

    public Switch(int switch_id, String switch_pin, String switch_type, String switch_spring, String switch_reliability, String switch_depth, Product pro_id) {
        this.switch_id = switch_id;
        this.switch_pin = switch_pin;
        this.switch_type = switch_type;
        this.switch_spring = switch_spring;
        this.switch_reliability = switch_reliability;
        this.switch_depth = switch_depth;
        this.pro_id = pro_id;
    }

    public int getSwitch_id() {
        return switch_id;
    }

    public void setSwitch_id(int switch_id) {
        this.switch_id = switch_id;
    }

    public String getSwitch_pin() {
        return switch_pin;
    }

    public void setSwitch_pin(String switch_pin) {
        this.switch_pin = switch_pin;
    }

    public String getSwitch_type() {
        return switch_type;
    }

    public void setSwitch_type(String switch_type) {
        this.switch_type = switch_type;
    }

    public String getSwitch_spring() {
        return switch_spring;
    }

    public void setSwitch_spring(String switch_spring) {
        this.switch_spring = switch_spring;
    }

    public String getSwitch_reliability() {
        return switch_reliability;
    }

    public void setSwitch_reliability(String switch_reliability) {
        this.switch_reliability = switch_reliability;
    }

    public String getSwitch_depth() {
        return switch_depth;
    }

    public void setSwitch_depth(String switch_depth) {
        this.switch_depth = switch_depth;
    }

    public Product getPro_id() {
        return pro_id;
    }

    public void setPro_id(Product pro_id) {
        this.pro_id = pro_id;
    }

    
}
