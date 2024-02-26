/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author nguye
 */
public class Switch {
    private int sw_id;
    private String sw_pin;
    private String sw_type;
    private String sw_spring;
    private String sw_reliability;
    private String sw_depth;
    private int pro_id;

    public Switch() {
    }

    public Switch(int sw_id, String sw_pin, String sw_type, String sw_spring, String sw_reliability, String sw_depth, int pro_id) {
        this.sw_id = sw_id;
        this.sw_pin = sw_pin;
        this.sw_type = sw_type;
        this.sw_spring = sw_spring;
        this.sw_reliability = sw_reliability;
        this.sw_depth = sw_depth;
        this.pro_id = pro_id;
    }

    public int getSw_id() {
        return sw_id;
    }

    public void setSw_id(int sw_id) {
        this.sw_id = sw_id;
    }

    public String getSw_pin() {
        return sw_pin;
    }

    public void setSw_pin(String sw_pin) {
        this.sw_pin = sw_pin;
    }

    public String getSw_type() {
        return sw_type;
    }

    public void setSw_type(String sw_type) {
        this.sw_type = sw_type;
    }

    public String getSw_spring() {
        return sw_spring;
    }

    public void setSw_spring(String sw_spring) {
        this.sw_spring = sw_spring;
    }

    public String getSw_reliability() {
        return sw_reliability;
    }

    public void setSw_reliability(String sw_reliability) {
        this.sw_reliability = sw_reliability;
    }

    public String getSw_depth() {
        return sw_depth;
    }

    public void setSw_depth(String sw_depth) {
        this.sw_depth = sw_depth;
    }

    public int getPro_id() {
        return pro_id;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }
    
    
    
}
