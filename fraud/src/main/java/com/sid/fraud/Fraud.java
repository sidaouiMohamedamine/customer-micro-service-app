package com.sid.fraud;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Fraud {

        @Id
        private Long id;
        private Long customerId;
        private Boolean isFraud;
        private LocalDateTime createAt;
}
