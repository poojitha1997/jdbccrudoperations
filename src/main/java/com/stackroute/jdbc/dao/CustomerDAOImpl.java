package com.stackroute.jdbc.dao;

import com.stackroute.jdbc.model.Customer;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAOImpl implements CustomerDAO {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate()
    {
        return jdbcTemplate;
    }
    @Override
    public int insert(Customer customer)
    {
        int custid=customer.getCustomerId();
        String name=customer.getCustomerName();
        String address=customer.getCustomerAddress();
        int rows = jdbcTemplate.update("insert into customer values(?,?,?)", custid, name, address);
        return rows;
    }
    @Override
    public int deleteCustomer(int customerId)
    {
        String query="DELETE from customer where custid=?";
        return jdbcTemplate.update(query, new Object[] { Integer.valueOf(customerId) });

    }
    @Override
    public Customer selectCustomer(int customerId)
    {
        final Customer customer=new Customer();
      return jdbcTemplate.query("SELECT * FROM customer", new ResultSetExtractor<Customer>() {
          @Override
          public Customer extractData(ResultSet resultSet) throws SQLException, DataAccessException {
              while (resultSet.next())
              {
                  customer.setCustomerId(resultSet.getInt(1));
                  customer.setCustomerName(resultSet.getString(2));
                  customer.setCustomerAddress(resultSet.getString(3));

              }
              return customer;
          }
      });

    }

    public void updateCustomer(Customer customer)
    {String query = "UPDATE customer SET custname=?,city=? WHERE custid=?";
        jdbcTemplate.update(query,
                new Object[] {
                        customer.getCustomerName(),customer.getCustomerAddress(), Integer.valueOf(customer.getCustomerId())
                });



    }



}
