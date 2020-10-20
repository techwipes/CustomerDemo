package org.techwipes.customerdemo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.techwipes.customerdemo.model.Customer;

/**
 * Repository interface for {@link Customer} class
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
