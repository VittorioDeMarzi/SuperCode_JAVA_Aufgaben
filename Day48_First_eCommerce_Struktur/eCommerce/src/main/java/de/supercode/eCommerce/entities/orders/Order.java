package de.supercode.eCommerce.entities.orders;

import com.fasterxml.jackson.annotation.JsonFormat;
import de.supercode.eCommerce.entities.enums.OrderStatus;
import de.supercode.eCommerce.entities.customer.Customer;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "shop_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @OneToMany(mappedBy = "pk.order")
    private Set<OrderProduct> oderProducts;

    BigDecimal totalPrice;

}
