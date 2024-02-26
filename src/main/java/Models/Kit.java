/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author nguye
 */
public class Kit {
    private int kitID;
    private String layout;
    private String circuit;
    private String plate;
    private String mode;
    private String kitCase;
    private int pro_id;

    public Kit() {
    }

    public Kit(int kitID, String layout, String circuit, String plate, String mode, String kitCase, int pro_id) {
        this.kitID = kitID;
        this.layout = layout;
        this.circuit = circuit;
        this.plate = plate;
        this.mode = mode;
        this.kitCase = kitCase;
        this.pro_id = pro_id;
    }

    public int getKitID() {
        return kitID;
    }

    public void setKitID(int kitID) {
        this.kitID = kitID;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public String getCircuit() {
        return circuit;
    }

    public void setCircuit(String circuit) {
        this.circuit = circuit;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getKitCase() {
        return kitCase;
    }

    public void setKitCase(String kitCase) {
        this.kitCase = kitCase;
    }

    public int getPro_id() {
        return pro_id;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }
    
    
}
