package com.example.jpa1week1.Repository;

import com.example.jpa1week1.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
