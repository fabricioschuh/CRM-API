package com.example.crm.controller;

import com.example.crm.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.crm.model.Customer;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    //Return all customers
    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {

        return customerRepository.findAll();
    }

    //Return one customer
    @GetMapping("/customers/{id}")
    public Optional<Customer> getCustomerById(@PathVariable Long id) {

        return customerRepository.findById(id);
    }

    //Add new customer
    @PostMapping("/customers")
    public Customer add(@RequestBody Customer customer) {

        return customerRepository.save(customer);
    }

    //Delete a customer
    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable Long id) {

        customerRepository.deleteById(id);
    }

    //Update a customer
    @PutMapping("/customers/{id}")
    public void updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {

        Customer actualCustomer = customerRepository.findById(id).get();

    }


}
