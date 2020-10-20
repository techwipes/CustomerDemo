package org.techwipes.customerdemo.service;


import org.techwipes.customerdemo.model.Customer;

import java.util.List;

public interface CustomerService {

    // get customer from the db
    Customer getById(Long id);

    //save customer in the db
    void save(Customer customer);

    //delete customer from the db
    void delete(Long id);

    //get all customers from the db
    List<Customer> getAll();


}
