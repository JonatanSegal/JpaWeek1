package com.example.jpa1week1.DTO;

import com.example.jpa1week1.entity.Customer;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerResponse{
    int id;
    String firstName;
    String lastName;
    String email;
    String secret1;

    public CustomerResponse(Customer c) {
        this.id = c.getId();
        this.lastName = c.getLastName();
        this.firstName = c.getFirstName();
        this.email = c.getEmail();
    }

    public static List<CustomerResponse> getList(List<Customer> customerEntities){
       /* List<CustomerResponse> all = new ArrayList<>();
        for(Customer c: customerEntities){
            all.add(new CustomerResponse(c));
        }
         return all;
        */
        return customerEntities.stream().map(c->new CustomerResponse(c)).collect(Collectors.toList());
    }
}
