package de.supercode.eCommerce.servicies;

import de.supercode.eCommerce.entities.Customer;
import de.supercode.eCommerce.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    CustomerRepository customerRepository;
    BasketService basketService;

    public CustomerService(CustomerRepository customerRepository, BasketService basketService) {
        this.customerRepository = customerRepository;
        this.basketService = basketService;
    }

    // save new Customer
    public void saveNewCustomer(Customer customer) {
        customerRepository.save(customer);
        basketService.saveNewBasket(customer.getBasket());

    }

    // find all customers
    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }
}
