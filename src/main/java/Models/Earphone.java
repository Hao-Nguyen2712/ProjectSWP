/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Laptop
 */
public class Earphone {

    private int ear_id;
    private String ear_type;
    private String ear_plug;
    private String ear_compatibility;
    private String ear_wire_length;
    private String ear_utility;
    private String ear_connect;
    private String ear_control;
    private String ear_charging_port;
    private String ear_connect_tech;
    private Product pro_id;

    public Earphone() {
    }

    public Earphone(int ear_id, String ear_type, String ear_plug, String ear_compatibility, String ear_wire_length, String ear_utility, String ear_connect, String ear_control, String ear_charging_port, String ear_connect_tech, Product pro_id) {
        this.ear_id = ear_id;
        this.ear_type = ear_type;
        this.ear_plug = ear_plug;
        this.ear_compatibility = ear_compatibility;
        this.ear_wire_length = ear_wire_length;
        this.ear_utility = ear_utility;
        this.ear_connect = ear_connect;
        this.ear_control = ear_control;
        this.ear_charging_port = ear_charging_port;
        this.ear_connect_tech = ear_connect_tech;
        this.pro_id = pro_id;
    }

    public int getEar_id() {
        return ear_id;
    }

    public void setEar_id(int ear_id) {
        this.ear_id = ear_id;
    }

    public String getEar_type() {
        return ear_type;
    }

    public void setEar_type(String ear_type) {
        this.ear_type = ear_type;
    }

    public String getEar_plug() {
        return ear_plug;
    }

    public void setEar_plug(String ear_plug) {
        this.ear_plug = ear_plug;
    }

    public String getEar_compatibility() {
        return ear_compatibility;
    }

    public void setEar_compatibility(String ear_compatibility) {
        this.ear_compatibility = ear_compatibility;
    }

    public String getEar_wire_length() {
        return ear_wire_length;
    }

    public void setEar_wire_length(String ear_wire_length) {
        this.ear_wire_length = ear_wire_length;
    }

    public String getEar_utility() {
        return ear_utility;
    }

    public void setEar_utility(String ear_utility) {
        this.ear_utility = ear_utility;
    }

    public String getEar_connect() {
        return ear_connect;
    }

    public void setEar_connect(String ear_connect) {
        this.ear_connect = ear_connect;
    }

    public String getEar_control() {
        return ear_control;
    }

    public void setEar_control(String ear_control) {
        this.ear_control = ear_control;
    }

    public String getEar_charging_port() {
        return ear_charging_port;
    }

    public void setEar_charging_port(String ear_charging_port) {
        this.ear_charging_port = ear_charging_port;
    }

    public String getEar_connect_tech() {
        return ear_connect_tech;
    }

    public void setEar_connect_tech(String ear_connect_tech) {
        this.ear_connect_tech = ear_connect_tech;
    }

    public Product getPro_id() {
        return pro_id;
    }

    public void setPro_id(Product pro_id) {
        this.pro_id = pro_id;
    }

}
