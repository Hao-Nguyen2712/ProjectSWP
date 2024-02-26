/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author nguye
 */
public class Earphone {

    private int ear_id;
    private String ear_type;
    private String ear_plug;
    private String ear_compatibility;
    private String ear_wireLength;
    private String ear_utility;
    private String ear_connect;
    private String ear_control;
    private String ear_chargingPort;
    private String ear_connectTeach;
    private int pro_id;

    public Earphone() {
    }

    public Earphone(int ear_id, String ear_type, String ear_plug, String ear_compatibility, String ear_wireLength, String ear_utility, String ear_connect, String ear_control, String ear_chargingPort, String ear_connectTeach, int pro_id) {
        this.ear_id = ear_id;
        this.ear_type = ear_type;
        this.ear_plug = ear_plug;
        this.ear_compatibility = ear_compatibility;
        this.ear_wireLength = ear_wireLength;
        this.ear_utility = ear_utility;
        this.ear_connect = ear_connect;
        this.ear_control = ear_control;
        this.ear_chargingPort = ear_chargingPort;
        this.ear_connectTeach = ear_connectTeach;
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

    public String getEar_wireLength() {
        return ear_wireLength;
    }

    public void setEar_wireLength(String ear_wireLength) {
        this.ear_wireLength = ear_wireLength;
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

    public String getEar_chargingPort() {
        return ear_chargingPort;
    }

    public void setEar_chargingPort(String ear_chargingPort) {
        this.ear_chargingPort = ear_chargingPort;
    }

    public String getEar_connectTeach() {
        return ear_connectTeach;
    }

    public void setEar_connectTeach(String ear_connectTeach) {
        this.ear_connectTeach = ear_connectTeach;
    }

    public int getPro_id() {
        return pro_id;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }

}
