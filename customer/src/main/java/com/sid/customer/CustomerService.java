package com.sid.customer;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

        private final CustomerRepository customerRepository;
    public void registerCustomer(CustomerRequest customerRequest) {

        Customer customer= Customer
                .builder()
                .firstname(customerRequest.getFirstname())
                .lastname(customerRequest.getLastname())
                .email(customerRequest.getEmail())
                .build();

        // to do : check if email valid
        // to do : check if email not taken
        customerRepository.save(customer);
    }
}
