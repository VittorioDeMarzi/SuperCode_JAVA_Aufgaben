package de.supercode.eCommerce.servicies;

import de.supercode.eCommerce.entities.Product;
import de.supercode.eCommerce.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // save new product
    public void saveNewProduct(Product product) {
        productRepository.save(product);
    }

    // find all products
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    // find product by ID
    public Optional<Product> findById(long id) {
        return productRepository.findById(id);
    }

    // delete Product By ID
    public Optional<Product> deleteProductById(long id) {
        Optional<Product> eventToDelete = findById(id);
        productRepository.deleteById(id);
        return eventToDelete;
    }
}
