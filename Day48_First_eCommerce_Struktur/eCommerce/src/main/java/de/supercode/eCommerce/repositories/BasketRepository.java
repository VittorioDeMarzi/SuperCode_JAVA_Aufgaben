package de.supercode.eCommerce.repositories;

import de.supercode.eCommerce.entities.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<Basket, Long> {
}
