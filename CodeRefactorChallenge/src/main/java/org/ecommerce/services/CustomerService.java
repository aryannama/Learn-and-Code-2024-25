package org.ecommerce.services;

import org.ecommerce.model.Customer;

import java.util.HashMap;
import java.util.Map;

public class CustomerService {
    public static Map<String, Customer> customers = new HashMap<>();

    public void addCustomer(Customer customer) {
        if (customer.getId() == null || customer.getId().isEmpty() || customer.getEmail() == null || customer.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Customer Id or Email should not be null or empty");
        }
        customers.put(customer.getId(), customer);
    }
}
