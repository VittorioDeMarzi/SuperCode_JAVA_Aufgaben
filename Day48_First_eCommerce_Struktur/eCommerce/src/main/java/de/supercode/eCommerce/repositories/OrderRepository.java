package de.supercode.eCommerce.repositories;

import de.supercode.eCommerce.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
