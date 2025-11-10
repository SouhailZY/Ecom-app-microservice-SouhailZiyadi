package com.emsi.billingservice.repository;

import com.emsi.billingservice.entities.Bill;
import org.springframework.data.repository.CrudRepository;

public interface BillRepository extends CrudRepository<Bill, Long> {
}
