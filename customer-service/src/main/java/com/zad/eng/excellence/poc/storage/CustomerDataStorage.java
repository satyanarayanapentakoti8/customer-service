package com.zad.eng.excellence.poc.storage;

import java.util.Collection;
import java.util.UUID;

import com.zad.eng.excellence.poc.model.Customer;


public interface CustomerDataStorage {
	
	public void loadDefaultCustomerData();
	
	public UUID saveNewCustomerData(Customer customer);
	
	public Collection<Customer> getAllCustomerData();

}
