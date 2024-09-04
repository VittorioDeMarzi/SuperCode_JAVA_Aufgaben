package de.supercode.eCommerce.controllers;

import de.supercode.eCommerce.entities.Customer;
import de.supercode.eCommerce.errors.ApiError;
import de.supercode.eCommerce.servicies.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // save new Customer
    @PostMapping
    public ResponseEntity<?> saveNewCustomer(@RequestBody Customer customer) {
        try {
            customerService.saveNewCustomer(customer);
            return new ResponseEntity<>(customer, HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(new ApiError(HttpStatus.BAD_REQUEST, "Customer with Email: " + customer.getEmail() + " already in DataBase"), HttpStatus.BAD_REQUEST);
        }
    }

    // find all customers

    @GetMapping
    public ResponseEntity<?> getAllProducts() {
        try {
            customerService.findAllCustomers();
            return new ResponseEntity<>(customerService.findAllCustomers(), HttpStatus.CREATED);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
