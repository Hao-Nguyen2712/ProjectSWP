/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Laptop
 */
public class Mouse {

    private int mouse_id;
    private String mouse_dpi;
    private String mouse_wire_length;
    private String mouse_led;
    private String mouse_type_battery;
    private String mouse_weight;
    private String mouse_compatibility;
    private Product pro_id;

    public Mouse() {
    }

    public Mouse(int mouse_id, String mouse_dpi, String mouse_wire_length, String mouse_led, String mouse_type_battery, String mouse_weight, String mouse_compatibility, Product pro) {
        this.mouse_id = mouse_id;
        this.mouse_dpi = mouse_dpi;
        this.mouse_wire_length = mouse_wire_length;
        this.mouse_led = mouse_led;
        this.mouse_type_battery = mouse_type_battery;
        this.mouse_weight = mouse_weight;
        this.mouse_compatibility = mouse_compatibility;
        this.pro_id = pro;
    }

    public int getMouse_id() {
        return mouse_id;
    }

    public void setMouse_id(int mouse_id) {
        this.mouse_id = mouse_id;
    }

    public String getMouse_dpi() {
        return mouse_dpi;
    }

    public void setMouse_dpi(String mouse_dpi) {
        this.mouse_dpi = mouse_dpi;
    }

    public String getMouse_wire_length() {
        return mouse_wire_length;
    }

    public void setMouse_wire_length(String mouse_wire_length) {
        this.mouse_wire_length = mouse_wire_length;
    }

    public String getMouse_led() {
        return mouse_led;
    }

    public void setMouse_led(String mouse_led) {
        this.mouse_led = mouse_led;
    }

    public String getMouse_type_battery() {
        return mouse_type_battery;
    }

    public void setMouse_type_battery(String mouse_type_battery) {
        this.mouse_type_battery = mouse_type_battery;
    }

    public String getMouse_weight() {
        return mouse_weight;
    }

    public void setMouse_weight(String mouse_weight) {
        this.mouse_weight = mouse_weight;
    }

    public String getMouse_compatibility() {
        return mouse_compatibility;
    }

    public void setMouse_compatibility(String mouse_compatibility) {
        this.mouse_compatibility = mouse_compatibility;
    }

    public Product getPro_id() {
        return pro_id;
    }

    public void setPro(Product pro) {
        this.pro_id = pro;
    }
    
}
