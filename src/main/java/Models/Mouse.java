/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author nguye
 */
public class Mouse {
    private int mouse_id;
    private String mouse_dpi;
    private String mouse_wireLength;
    private String mouse_led;
    private String mouse_typeBattery;
    private String mouse_weight;
    private String mouse_compatibility;
    private int pro_id;

    public Mouse() {
    }

    public Mouse(int mouse_id, String mouse_dpi, String mouse_wireLength, String mouse_led, String mouse_typeBattery, String mouse_weight,  String mouse_compatibility, int pro_id) {
        this.mouse_id = mouse_id;
        this.mouse_dpi = mouse_dpi;
        this.mouse_wireLength = mouse_wireLength;
        this.mouse_led = mouse_led;
        this.mouse_typeBattery = mouse_typeBattery;
        this.mouse_weight = mouse_weight;
        this.mouse_compatibility = mouse_compatibility;
        this.pro_id = pro_id;
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

    public String getMouse_wireLength() {
        return mouse_wireLength;
    }

    public void setMouse_wireLength(String mouse_wireLength) {
        this.mouse_wireLength = mouse_wireLength;
    }

    public String getMouse_led() {
        return mouse_led;
    }

    public void setMouse_led(String mouse_led) {
        this.mouse_led = mouse_led;
    }

    public String getMouse_typeBattery() {
        return mouse_typeBattery;
    }

    public void setMouse_typeBattery(String mouse_typeBattery) {
        this.mouse_typeBattery = mouse_typeBattery;
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

    public int getPro_id() {
        return pro_id;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }
    
    
}
