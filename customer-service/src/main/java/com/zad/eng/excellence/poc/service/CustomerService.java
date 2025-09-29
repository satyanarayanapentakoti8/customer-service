package com.zad.eng.excellence.poc.service;

import java.util.Collection;
import java.util.UUID;

import com.zad.eng.excellence.poc.model.Customer;

public interface CustomerService {

    /**
     * Add a new customer
     * @param customer Customer object
     * @return UUID of the saved customer
     */
    UUID addCustomer(Customer customer);

    /**
     * Get a customer by ID
     * @param id UUID of customer
     * @return Customer object or null if not found
     */
    Customer getCustomerById(UUID id);

    /**
     * Get all customers
     * @return Collection of Customer objects
     */
    Collection<Customer> getAllCustomers();
}
