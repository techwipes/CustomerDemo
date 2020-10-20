package org.techwipes.customerdemo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.techwipes.customerdemo.model.Customer;
import org.techwipes.customerdemo.repository.CustomerRepository;

import java.util.List;


/**
 * Implementations of {@link CustomerService} interface.
 */

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer getById(Long id) {
        log.info("IN CustomerServiceImpl getById", id);
        return customerRepository.getOne(id);
    }

    @Override
    public void save(Customer customer) {
        log.info("IN CustomerServiceImpl save", customer);
        customerRepository.save(customer);    }

    @Override
    public void delete(Long id) {
        log.info("IN CustomerServiceImpl delete", id);
        customerRepository.deleteById(id);

    }

    @Override
    public List<Customer> getAll() {
        log.info("IN CustomerServiceImpl findAll");
        return customerRepository.findAll();
    }
}
