package com.sid.customer;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class CustomerService {

        private final CustomerRepository customerRepository;
        private final RestTemplate restTemplate;
    public void registerCustomer(CustomerRequest customerRequest) {

        Customers customers= Customers
                .builder()
                .firstname(customerRequest.getFirstname())
                .lastname(customerRequest.getLastname())
                .email(customerRequest.getEmail())
                .build();
        customerRepository.saveAndFlush(customers);
        FraudResponse fraudResponse = restTemplate.getForObject(
                "http://localhost:8060/api/v1/fraud/{customerId}",
                FraudResponse.class,
                customers.getId()
        );

        if (fraudResponse.isFraudster()){
            throw new IllegalStateException("The customer is fraudster");
        }

        // to do : check if email valid
        // to do : check if email not taken
    }
}
