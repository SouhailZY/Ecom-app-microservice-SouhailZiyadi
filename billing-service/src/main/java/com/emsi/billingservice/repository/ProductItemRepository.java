package com.emsi.billingservice.repository;

import com.emsi.billingservice.entities.ProductItem;
import org.springframework.data.repository.CrudRepository;

public interface ProductItemRepository extends CrudRepository<ProductItem, Long> {
}
