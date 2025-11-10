package com.emsi.billingservice.feign;

import com.emsi.billingservice.model.Customer;
import com.emsi.billingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "inventory-service")
public interface ProductRestClient {
    @GetMapping("/api/products/{id}")
    public Product getProductById(@PathVariable Long id);

    @GetMapping("/api/products")
    PagedModel<Product> getAllProducts();
}
