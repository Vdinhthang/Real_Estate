package com.javaweb.Model;

public class BuildingDTO {
    private String name;
    private Integer numberofbasement;
    private String address;

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberofbasement(Integer numberofbasement) {
        this.numberofbasement = numberofbasement;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Integer getNumberofbasement() {
        return numberofbasement;
    }
}

