package com.sid.fraud;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fraud")
@RequiredArgsConstructor
public class FraudController {

        private final FraudService fraudService;

    @GetMapping("/{customerId}")
    public FraudResponse isFraudle(@PathVariable("customerId") Long customerId){
          boolean isFraudlentCustomer = fraudService.isFraudlentCustomer(customerId);

          return new FraudResponse(isFraudlentCustomer);
    }
}
