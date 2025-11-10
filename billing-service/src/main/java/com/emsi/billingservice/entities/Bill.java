package com.emsi.billingservice.entities;

import com.emsi.billingservice.model.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor @AllArgsConstructor @Getter
@Setter @Builder
public class Bill {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date billingDate;
    private long customerId;
    @OneToMany(mappedBy = "bill")
    private List<ProductItem> productItem = new ArrayList<>();
    @Transient //cela dit a jpa que j'ai besoin de cet attribut mais tu l'ignore dans la bd, donc ne cree pas une table pour cet attribut
    private Customer customer;
}
