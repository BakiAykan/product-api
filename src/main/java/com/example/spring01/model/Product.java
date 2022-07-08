package com.example.spring01.model;

public class Product {

    private Long id;

    private String name;

    private Brand brand;

    private Category category;

    public Product() {
    }

    public Product(Long id, String name, Brand brand, Category category) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
