/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.model;

/**
 *
 * @author THUY
 */
public class Service {
    private int id;
    private String name;
    private float price;
    private int unit;
    private int catService;

    public Service() {
    }

    public Service(int id, String name, float price, int unit, int catService) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.unit = unit;
        this.catService = catService;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public int getCatService() {
        return catService;
    }

    public void setCatService(int catService) {
        this.catService = catService;
    }
    
    
}
