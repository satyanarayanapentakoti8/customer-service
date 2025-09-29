package com.zad.eng.excellence.poc.storage;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import jakarta.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.zad.eng.excellence.poc.model.Customer;
import com.zad.eng.excellence.poc.model.Customer.CustomerType;
import com.zad.eng.excellence.poc.model.Customer.Gender;
import com.zad.eng.excellence.poc.model.Customer.Status;

@Component
public class CustomerDataStorageImpl implements CustomerDataStorage {

	Map<UUID, Customer> customerMap = null;
	
	 public CustomerDataStorageImpl() {
	        this.customerMap = new HashMap<UUID, Customer>();
	    }

	 @PostConstruct
	 public void initDefaultCustomers() {
		 loadDefaultCustomerData();
	 }
	@Override
	public void loadDefaultCustomerData() {
		
		// Customer 1
		UUID id1 = UUID.randomUUID();
		Customer customer1 = new Customer(id1, "John", "Doe", LocalDate.of(1990, 5, 12), Gender.MALE, "SSN123456",
				CustomerType.INDIVIDUAL, Status.ACTIVE, LocalDateTime.now().minusYears(1), LocalDateTime.now());
		customerMap.put(id1, customer1);

		// Customer 2
		UUID id2 = UUID.randomUUID();
		Customer customer2 = new Customer(id2, "Alice", "Smith", LocalDate.of(1985, 8, 25), Gender.FEMALE,
				"AADHAAR998877", CustomerType.INDIVIDUAL, Status.SUSPENDED, LocalDateTime.now().minusMonths(6),
				LocalDateTime.now());
		customerMap.put(id2, customer2);

		// Customer 3
		UUID id3 = UUID.randomUUID();
		Customer customer3 = new Customer(id3, "TechCorp", "Ltd", null, // Business type may not have DOB
				Gender.OTHER, "REG-99887766", CustomerType.BUSINESS, Status.ACTIVE, LocalDateTime.now().minusDays(200),
				LocalDateTime.now());
		customerMap.put(id3, customer3);

	}

	@Override
	public UUID saveNewCustomerData(Customer customer) {
		if (customer.getCustomerId() == null) {
            customer.setCustomerId(UUID.randomUUID());
        }
        UUID id = customer.getCustomerId();
        customerMap.put(id, customer);  
        return id;
	}

	@Override
	public Collection<Customer> getAllCustomerData() {
		return customerMap.values();
	}

}
