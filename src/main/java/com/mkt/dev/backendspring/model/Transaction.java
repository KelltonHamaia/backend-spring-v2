package com.mkt.dev.backendspring.model;

import jakarta.persistence.*;

@Entity
public class Transaction {

    public Transaction() {

    }

    public Transaction(TransactionAction action, int quantity, User user, Product product) {
        this.action = action;
        this.quantity = quantity;
        this.user = user;
        this.product = product;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TransactionAction action;
    private int quantity;

    @JoinColumn(name="user_id")
    @ManyToOne
    private User user;

    @JoinColumn(name="product_id")
    @ManyToOne
    private Product product;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TransactionAction getAction() {
        return action;
    }

    public void setAction(TransactionAction action) {
        this.action = action;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
