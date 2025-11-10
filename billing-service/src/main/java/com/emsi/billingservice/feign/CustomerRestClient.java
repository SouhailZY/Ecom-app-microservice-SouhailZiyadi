package com.emsi.billingservice.feign;

import com.emsi.billingservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient (name = "customer-service")
public interface CustomerRestClient {
    @GetMapping("/api/customers/{id}")
    public Customer getCustomerById(@PathVariable Long id);

    @GetMapping("/api/customers")
    PagedModel<Customer> getAllCustomers(); //PagedModel<Customer> cela est du HATEOAS et qui permet d'eviter la creation d'une classe pour faire le traitement de cette methode
}
