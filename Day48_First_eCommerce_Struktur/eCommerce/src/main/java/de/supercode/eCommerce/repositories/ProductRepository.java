package de.supercode.eCommerce.repositories;

import de.supercode.eCommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
