package com.stackroute.jdbc.dao;

import com.stackroute.jdbc.model.Customer;

public interface CustomerDAO {
    Customer selectCustomer(int cistomerId);
    int insert(Customer c);
    int deleteCustomer(int customerId);
    void updateCustomer(Customer customer);
}
