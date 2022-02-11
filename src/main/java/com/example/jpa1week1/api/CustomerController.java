package com.example.jpa1week1.api;

import com.example.jpa1week1.DTO.CustomerResponse;
import com.example.jpa1week1.Repository.CustomerRepository;
import com.example.jpa1week1.entity.Customer;
import com.example.jpa1week1.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customer")
public class CustomerController {

    CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    //Converts  the list to Json objects
    @GetMapping()
    public List<CustomerResponse> getCustomers(){
        return customerService.getCustomers();
    }

    @GetMapping("/{id}")
    public CustomerResponse getCustomer(@PathVariable int id) throws Exception{
        return customerService.getCustomer(id);
    }
    @PostMapping
    public CustomerResponse addCustomer(@RequestBody CustomerResponse body){
        return customerService.addCustomer(body);
    }
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable int id) throws Exception{
        customerService.deleteCustomer(id);
    }

}
