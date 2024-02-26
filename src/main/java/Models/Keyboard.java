/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Laptop
 */
public class Keyboard {

    private int keyboard_id;
    private String led;
    private String mode;
    private String Switch;
    private String keycap;
    private String plate;
    private String Case;
    private Product pro_id;

    public Keyboard() {
    }

    public Keyboard(int keyboard_id, String led, String mode, String Switch, String keycap, String plate, String Case, Product pro_id) {
        this.keyboard_id = keyboard_id;
        this.led = led;
        this.mode = mode;
        this.Switch = Switch;
        this.keycap = keycap;
        this.plate = plate;
        this.Case = Case;
        this.pro_id = pro_id;
    }

    public int getKeyboard_id() {
        return keyboard_id;
    }

    public void setKeyboard_id(int keyboard_id) {
        this.keyboard_id = keyboard_id;
    }

    public String getLed() {
        return led;
    }

    public void setLed(String led) {
        this.led = led;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getSwitch() {
        return Switch;
    }

    public void setSwitch(String Switch) {
        this.Switch = Switch;
    }

    public String getKeycap() {
        return keycap;
    }

    public void setKeycap(String keycap) {
        this.keycap = keycap;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getCase() {
        return Case;
    }

    public void setCase(String Case) {
        this.Case = Case;
    }

    public Product getPro_id() {
        return pro_id;
    }

    public void setPro_id(Product pro_id) {
        this.pro_id = pro_id;
    }

}
