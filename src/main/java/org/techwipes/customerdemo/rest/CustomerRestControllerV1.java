package org.techwipes.customerdemo.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import org.techwipes.customerdemo.model.Customer;
import org.techwipes.customerdemo.service.CustomerService;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/customers/")
public class CustomerRestControllerV1 {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") Long customerId) {
        if (customerId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Customer customer = this.customerService.getById(customerId);

        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customer, HttpStatus.OK);

    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Customer> saveCustomer(@RequestBody @Valid Customer customer) {
        HttpHeaders headers = new HttpHeaders();

        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.customerService.save((customer));
        return new ResponseEntity<>(customer, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Customer> updateCustomer(@RequestBody @Valid Customer customer, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();

        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.customerService.save((customer));

        return new ResponseEntity<>(customer, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Customer> deleteCustomer(Long id) {
        Customer customer = this.customerService.getById(id);

        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.customerService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
