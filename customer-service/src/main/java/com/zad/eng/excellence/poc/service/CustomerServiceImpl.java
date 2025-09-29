package com.zad.eng.excellence.poc.service;

import java.util.Collection;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.zad.eng.excellence.poc.model.Customer;
import com.zad.eng.excellence.poc.storage.CustomerDataStorage;

@Service
public class CustomerServiceImpl implements CustomerService {

  
    private final CustomerDataStorage customerDataStorage;

    // Constructor injection of storage
    public CustomerServiceImpl(CustomerDataStorage customerDataStorage) {
        this.customerDataStorage = customerDataStorage;
    }

    @Override
    public UUID addCustomer(Customer customer) {
         return customerDataStorage.saveNewCustomerData(customer);
    }
  

    @Override
    public Collection<Customer> getAllCustomers() {
        return customerDataStorage.getAllCustomerData();
    }

	@Override
	public Customer getCustomerById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}
}
