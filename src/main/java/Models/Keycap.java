/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author HIEU
 */
public class Keycap {

    private int kc_id;
    private String kc_material;
    private String kc_layout;
    private String kc_thickness;
    private String kc_reliability;
    private Product pro_id;

    public Keycap() {
    }

    public Keycap(int kc_id, String kc_material, String kc_layout, String kc_thickness, String kc_reliability, Product pro_id) {
        this.kc_id = kc_id;
        this.kc_material = kc_material;
        this.kc_layout = kc_layout;
        this.kc_thickness = kc_thickness;
        this.kc_reliability = kc_reliability;
        this.pro_id = pro_id;
    }

    public int getKc_id() {
        return kc_id;
    }

    public void setKc_id(int kc_id) {
        this.kc_id = kc_id;
    }

    public String getKc_material() {
        return kc_material;
    }

    public void setKc_material(String kc_material) {
        this.kc_material = kc_material;
    }

    public String getKc_layout() {
        return kc_layout;
    }

    public void setKc_layout(String kc_layout) {
        this.kc_layout = kc_layout;
    }

    public String getKc_thickness() {
        return kc_thickness;
    }

    public void setKc_thickness(String kc_thickness) {
        this.kc_thickness = kc_thickness;
    }

    public String getKc_reliability() {
        return kc_reliability;
    }

    public void setKc_reliability(String kc_reliability) {
        this.kc_reliability = kc_reliability;
    }

    public Product getPro_id() {
        return pro_id;
    }

    public void setPro_id(Product pro_id) {
        this.pro_id = pro_id;
    }

}
