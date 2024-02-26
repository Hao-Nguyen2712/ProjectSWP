/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author nguye
 */
public class Keyboard {
    private int kb_id;
    private String kb_led;
    private String kb_mode;
    private String kb_switch;
    private String kb_keycap;
    private String kb_plate;
    private String kb_case;
    private int pro_id;

    public Keyboard() {
    }

    public Keyboard(int kb_id, String kb_led, String kb_mode, String kb_switch, String kb_keycap, String kb_plate, String kb_case, int pro_id) {
        this.kb_id = kb_id;
        this.kb_led = kb_led;
        this.kb_mode = kb_mode;
        this.kb_switch = kb_switch;
        this.kb_keycap = kb_keycap;
        this.kb_plate = kb_plate;
        this.kb_case = kb_case;
        this.pro_id = pro_id;
    }

    public int getKb_id() {
        return kb_id;
    }

    public void setKb_id(int kb_id) {
        this.kb_id = kb_id;
    }

    public String getKb_led() {
        return kb_led;
    }

    public void setKb_led(String kb_led) {
        this.kb_led = kb_led;
    }

    public String getKb_mode() {
        return kb_mode;
    }

    public void setKb_mode(String kb_mode) {
        this.kb_mode = kb_mode;
    }

    public String getKb_switch() {
        return kb_switch;
    }

    public void setKb_switch(String kb_switch) {
        this.kb_switch = kb_switch;
    }

    public String getKb_keycap() {
        return kb_keycap;
    }

    public void setKb_keycap(String kb_keycap) {
        this.kb_keycap = kb_keycap;
    }

    public String getKb_plate() {
        return kb_plate;
    }

    public void setKb_plate(String kb_plate) {
        this.kb_plate = kb_plate;
    }

    public String getKb_case() {
        return kb_case;
    }

    public void setKb_case(String kb_case) {
        this.kb_case = kb_case;
    }

    public int getPro_id() {
        return pro_id;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }
    
    
    
}
