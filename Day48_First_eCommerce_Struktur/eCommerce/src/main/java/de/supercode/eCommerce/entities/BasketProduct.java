package de.supercode.eCommerce.entities;

import jakarta.persistence.*;

@Entity
public class BasketProduct {
    @Id
    @ManyToOne
    @JoinColumn(name = "baskeId")
    private Basket basket;

    @ManyToOne
    @JoinColumn(name = "itemId")
    private Product product;

    private int quantity;

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public Product getItem() {
        return product;
    }

    public void setItem(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
