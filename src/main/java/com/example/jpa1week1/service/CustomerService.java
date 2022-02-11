package com.example.jpa1week1.service;

import com.example.jpa1week1.DTO.CustomerResponse;
import com.example.jpa1week1.Repository.CustomerRepository;
import com.example.jpa1week1.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    CustomerRepository customerRepository;
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerResponse getCustomer(int id) throws Exception {
        Customer customer = customerRepository.findById(id).orElseThrow(()-> new Exception("not found"));
        return new CustomerResponse(customer);
    }
    public List<CustomerResponse> getCustomers(){
        List<Customer> customers = customerRepository.findAll();
        return CustomerResponse.getList(customers);
    }

    public CustomerResponse addCustomer(CustomerResponse body){
        Customer newCustomer = customerRepository.save(new Customer(body));
        return new CustomerResponse(newCustomer);
    }

    public void deleteCustomer(int id) throws Exception {
        if(!customerRepository.existsById(id)){
            throw new Exception("not found");
        }
        customerRepository.deleteById(id);
    }

}
