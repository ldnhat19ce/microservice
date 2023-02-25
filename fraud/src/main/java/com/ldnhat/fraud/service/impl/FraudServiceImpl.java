package com.ldnhat.fraud.service.impl;

import com.ldnhat.clients.fraud.FraudCheckDTO;
import com.ldnhat.fraud.domain.FraudCheckHistory;
import com.ldnhat.fraud.repository.FraudCheckHistoryRepository;
import com.ldnhat.fraud.service.FraudService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class FraudServiceImpl implements FraudService {
    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    @Override
    public FraudCheckDTO save(Integer customerId) {
        FraudCheckHistory fraudCheckHistory = FraudCheckHistory.builder()
                .customerId(customerId)
                .isFraudster(false)
                .build();
        fraudCheckHistoryRepository.save(fraudCheckHistory);
        return FraudCheckDTO.builder()
                .id(fraudCheckHistory.getId())
                .customerId(fraudCheckHistory.getCustomerId())
                .isFraudster(fraudCheckHistory.getIsFraudster())
                .build();
    }

    @Override
    public FraudCheckDTO update(FraudCheckDTO fraudCheckDTO) {
        return null;
    }

    @Override
    public Optional<FraudCheckDTO> partialUpdate(FraudCheckDTO fraudCheckDTO) {
        return Optional.empty();
    }

    @Override
    public Optional<FraudCheckDTO> findOne(Long id) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {

    }
}
