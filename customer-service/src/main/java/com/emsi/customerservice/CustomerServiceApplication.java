package com.emsi.customerservice;

import com.emsi.customerservice.config.CustomerConfigParams;
import com.emsi.customerservice.entities.Customer;
import com.emsi.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(CustomerConfigParams.class)
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner init(CustomerRepository customerRepository) {
        return args -> {
            customerRepository.save(Customer.builder()
                    .name("souhail").email("souhail@gmail.com")
                    .build());
            customerRepository.save(Customer.builder()
                    .name("Adnane").email("Adnane@gmail.com")
                    .build());
            customerRepository.save(Customer.builder()
                    .name("Reda").email("Reda@gmail.com")
                    .build());
            customerRepository.save(Customer.builder()
                    .name("Mouad").email("mouad@gmail.com")
                    .build());
            customerRepository.findAll().forEach(c->{
                System.out.println("========================");
                System.out.println(c.getId());
                System.out.println(c.getName());
                System.out.println(c.getEmail());
                System.out.println("========================");
            });

        };
    }

}
