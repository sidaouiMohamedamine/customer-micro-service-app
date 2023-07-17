package com.sid.fraud;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class FraudService {

        private final FraudRepository fraudRepository;



    public boolean isFraudlentCustomer(Long customerId){

        Fraud fraud = new Fraud()
                .builder()
                .isFraud(false)
                .customerId(customerId)
                .createAt(LocalDateTime.now())
                .build();

        fraudRepository.save(fraud);

        return false;
    }
}
