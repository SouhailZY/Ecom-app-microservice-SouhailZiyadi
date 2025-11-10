package com.emsi.billingservice.web;

import com.emsi.billingservice.entities.Bill;
import com.emsi.billingservice.feign.CustomerRestClient;
import com.emsi.billingservice.feign.ProductRestClient;
import com.emsi.billingservice.repository.BillRepository;
import com.emsi.billingservice.repository.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillRestController {
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private ProductItemRepository productItemRepository;
    @Autowired
    private CustomerRestClient customerRestClient;
    @Autowired
    private ProductRestClient productRestClient;

    @GetMapping(path = "/bills/{id}")
    public Bill getBill(Long id) {
        Bill bill = billRepository.findById(id).get();
        bill.setCustomer(customerRestClient.getCustomerById(bill.getCustomer().getId()));
        bill.getProductItem().forEach(productItem -> {
            productItem.setProduct(productRestClient.getProductById(productItem.getId()));
        });
        return bill;
    }
}
