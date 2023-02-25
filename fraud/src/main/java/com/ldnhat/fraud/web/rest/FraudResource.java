package com.ldnhat.fraud.web.rest;

import com.ldnhat.clients.fraud.FraudCheckDTO;
import com.ldnhat.fraud.service.FraudService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/fraud")
public class FraudResource {
    private final FraudService fraudService;

    public FraudResource(FraudService fraudService) {
        this.fraudService = fraudService;
    }

    /**
     * {@code GET /fraud} : check the fraudster.
     *
     * @param customerId {@link Integer}
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the result in body.
     */
    @GetMapping("/{customerId}")
    public ResponseEntity<FraudCheckDTO> fraud(@PathVariable Integer customerId) {
        log.info("REST request to check fraudster {}", customerId);
        FraudCheckDTO result = fraudService.save(customerId);
        return ResponseEntity.ok().body(result);
    }
}
