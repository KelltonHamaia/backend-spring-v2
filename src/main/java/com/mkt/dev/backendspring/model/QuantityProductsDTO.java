package com.mkt.dev.backendspring.model;

public class QuantityProductsDTO {
    public QuantityProductsDTO(String name, Long quantity){
        this.name = name;
        this.quantity = quantity;
    }
    private String name;
    private Long quantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
