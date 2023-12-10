package com.warehouse.model;

import jakarta.persistence.*;

@Entity
@Table(name="PRODUCTS")
public class ProductBlock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="PRODUCT_BLOCK", length=100, nullable=false, unique=true)
    private String blockJson;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getBlockJson() {
        return blockJson;
    }

    public void setBlockJson(String blockJson) {
        this.blockJson = blockJson;
    }
}
