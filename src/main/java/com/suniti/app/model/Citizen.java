package com.suniti.app.model;

import java.util.UUID;

public class Citizen {
    private final String id;
    private String name;
    private String district;
    private String category;
    private int familySize;
    private long income;
    private String houseType;
    private String email;

    public Citizen(String name, String district, String category, int familySize, long income, String houseType, String email) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.district = district;
        this.category = category;
        this.familySize = familySize;
        this.income = income;
        this.houseType = houseType;
        this.email = email;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getDistrict() { return district; }
    public String getCategory() { return category; }
    public int getFamilySize() { return familySize; }
    public long getIncome() { return income; }
    public String getHouseType() { return houseType; }
    public String getEmail() { return email; }

    public void setName(String name) { this.name = name; }
    public void setDistrict(String district) { this.district = district; }
    public void setCategory(String category) { this.category = category; }
    public void setFamilySize(int familySize) { this.familySize = familySize; }
    public void setIncome(long income) { this.income = income; }
    public void setHouseType(String houseType) { this.houseType = houseType; }
    public void setEmail(String email) { this.email = email; }
}
