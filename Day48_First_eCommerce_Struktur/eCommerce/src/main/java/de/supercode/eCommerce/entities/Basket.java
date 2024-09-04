package de.supercode.eCommerce.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @OneToMany(mappedBy =  "basket")
    private Set<BasketProduct> basketProduct;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<BasketProduct> getBasketItem() {
        return basketProduct;
    }

    public void setBasketItem(Set<BasketProduct> basketProduct) {
        this.basketProduct = basketProduct;
    }
}
