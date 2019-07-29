package com.stackroute.jdbc.service;

import com.stackroute.jdbc.dao.CustomerDAOImpl;
import com.stackroute.jdbc.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;

public class DemoBean {
    @Autowired
private CustomerDAOImpl customerDAOImpl;
public void setCustomerDAO(CustomerDAOImpl customerDAOImpl)
{
    this.customerDAOImpl = customerDAOImpl;
}
public void insertCustomer(int cid,String custname,String addr)
{
    Customer customer=new Customer();
    customer.setCustomerId(cid);
    customer.setCustomerName(custname);
    customer.setCustomerAddress(addr);
    int res= customerDAOImpl.insert(customer);
    System.out.println(res+ ": Records inserted");
}
public int deleteCustomer(int customerId)
{
    return customerDAOImpl.deleteCustomer(customerId);
}
public Customer selectCustomer(int customerId)
{
    return customerDAOImpl.selectCustomer(customerId);
}
public void updateCustomer(Customer customer)
{
    customerDAOImpl.updateCustomer(customer);
}
}
