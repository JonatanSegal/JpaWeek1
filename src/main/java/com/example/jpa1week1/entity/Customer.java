package com.example.jpa1week1.entity;

import com.example.jpa1week1.DTO.CustomerResponse;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity(name = "kunde")
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="fornavn",length = 40,nullable = false)
    private String firstName;

    @Column(name="efternavn",length = 60, nullable = false)
    private String lastName;

    @Column(name="mail",length = 120,nullable = false,unique = true)
    private String email;

    @Column(name="oprettet")
    @CreationTimestamp
    private LocalDateTime dateCreated;

    @Column(name = "rettet")
    @UpdateTimestamp
    private LocalDateTime dateEdited;

    @Column(name="hemlighed1")
    private String secret1;

    @Column(name="hemlighed2")
    private String secret2;

    public Customer() {
    }

    public Customer(CustomerResponse customerResponse){
        this.firstName = customerResponse.getFirstName();
        this.lastName = customerResponse.getLastName();
        this.email = customerResponse.getEmail();
        this.secret1 = "Hemlighed 1";
        this.secret2= "Hemlighed 2";

    }

    public Customer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.secret1 = "Hemlighed 1";
        this.secret2= "Hemlighed 2";
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", dateCreated=" + dateCreated +
                ", dateEdited=" + dateEdited +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id && Objects.equals(firstName, customer.firstName) && Objects.equals(lastName, customer.lastName) && Objects.equals(email, customer.email) && Objects.equals(dateCreated, customer.dateCreated) && Objects.equals(dateEdited, customer.dateEdited);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, dateCreated, dateEdited);
    }
}
