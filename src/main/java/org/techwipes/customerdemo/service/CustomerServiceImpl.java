package org.techwipes.customerdemo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.techwipes.customerdemo.model.Customer;
import org.techwipes.customerdemo.repository.CustomerRepository;

import java.util.List;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer getById(Long id) {
        return customerRepository.getOne(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);

    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }
}
