package com.example.jpa1week1.Repository;

import com.example.jpa1week1.entity.Customer;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    static int custId1, custId2;

    @BeforeAll
    static void setUp(@Autowired CustomerRepository customerRepository) {
        Customer c1 = customerRepository.save(new Customer("a","b","c@a.dk"));
        custId1 = c1.getId();
        custId2 = customerRepository.save(new Customer("aa","bb","ac@a.dk")).getId();

    }
    @Test
    public void testAddCustomer(){
        Customer cusNew = customerRepository.save(new Customer("ab","ba","ab@ba.dk"));
        assertNotEquals(0,cusNew.getId());
        assertEquals(3,customerRepository.count());
    }

    @Test
    public void testCount(){
        assertEquals(2,customerRepository.count());
    }
    @Test
    public void testFindById(){
        Customer cFound = customerRepository.findById(custId2).orElse(null);
        assertEquals("ac@a.dk",cFound.getEmail());
    }

}