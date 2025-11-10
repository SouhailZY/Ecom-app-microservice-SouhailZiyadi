package com.emsi.customerservice.repository;

import com.emsi.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
