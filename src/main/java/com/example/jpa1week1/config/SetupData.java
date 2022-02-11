package com.example.jpa1week1.config;

import com.example.jpa1week1.Repository.CustomerRepository;
import com.example.jpa1week1.entity.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

@Controller
public class SetupData implements CommandLineRunner {

    CustomerRepository customerRepository;

    public SetupData(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        customerRepository.save(new Customer("Jonatan","Segal","mail1@test.com"));
        customerRepository.save(new Customer("Fumio","Seijuro","mail2@test.com"));


    }
}
