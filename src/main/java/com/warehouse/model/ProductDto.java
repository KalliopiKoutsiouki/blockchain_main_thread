package com.warehouse.model;

public class ProductDto {
    private long id;
    private String productCode;
    private String productName;
    private double price;
    private String description;
    private String category;
    private String previousID;

    public ProductDto(long id, String productCode, String productName, double price, String description, String category) {
        this.id = id;
        this.productCode = productCode;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPreviousID() {
        return previousID;
    }

    public void setPreviousID(String previousID) {
        this.previousID = previousID;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", previousID='" + previousID + '\'' +
                '}';
    }
}
