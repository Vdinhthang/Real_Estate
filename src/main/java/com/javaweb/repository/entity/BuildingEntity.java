package com.javaweb.repository.entity;

public class BuildingEntity {
    private String name;
    private String street;
    private String ward;
    private Integer numberofbasement;

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberofbasement(Integer numberofbasement) {
        this.numberofbasement = numberofbasement;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getName() {
        return name;
    }

    public Integer getNumberofbasement() {
        return numberofbasement;
    }

    public String getStreet() {
        return street;
    }

    public String getWard() {
        return ward;
    }
}
