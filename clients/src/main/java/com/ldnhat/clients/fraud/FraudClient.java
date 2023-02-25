package com.ldnhat.clients.fraud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("fraud")
public interface FraudClient {

    @GetMapping("api/v1/fraud/{customerId}")
    ResponseEntity<FraudCheckDTO> fraud(@PathVariable("customerId") Integer customerId);
}
