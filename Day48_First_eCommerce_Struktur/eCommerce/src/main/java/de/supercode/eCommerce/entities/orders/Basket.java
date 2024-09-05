package de.supercode.eCommerce.entities.orders;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import de.supercode.eCommerce.entities.customer.Customer;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JsonBackReference
    @JsonIgnore
    @JoinColumn(name = "customerId")
    private Customer customer;

    @JsonManagedReference
    @OneToMany(mappedBy =  "basket",  cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Set<BasketProduct> basketProduct =  new HashSet<>();

}
