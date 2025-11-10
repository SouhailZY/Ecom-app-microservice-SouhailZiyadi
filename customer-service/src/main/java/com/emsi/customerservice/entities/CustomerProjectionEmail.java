package com.emsi.customerservice.entities;

import com.emsi.customerservice.entities.Customer;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "email", types = Customer.class)
public interface CustomerProjectionEmail {
    String getEmail();
}