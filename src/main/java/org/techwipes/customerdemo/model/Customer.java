package org.techwipes.customerdemo.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Simple Javabean domain object that present Customer.
 */

@Entity
@Table (name = "customers")
@Data
public class Customer extends BaseEntity{

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "address")
    private String address;

    @Column(name = "budget")
    private BigDecimal budget;

}
