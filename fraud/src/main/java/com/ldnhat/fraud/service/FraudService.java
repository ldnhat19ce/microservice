package com.ldnhat.fraud.service;

import com.ldnhat.clients.fraud.FraudCheckDTO;

import java.util.Optional;

public interface FraudService {
    /**
     * Save a barCart.
     *
     * @param customerId the id of customer to save.
     * @return the persisted entity.
     */
    FraudCheckDTO save(Integer customerId);

    /**
     * Updates a barCart.
     *
     * @param fraudCheckDTO the entity to update.
     * @return the persisted entity.
     */
    FraudCheckDTO update(FraudCheckDTO fraudCheckDTO);

    /**
     * Partially updates a barCart.
     *
     * @param fraudCheckDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<FraudCheckDTO> partialUpdate(FraudCheckDTO fraudCheckDTO);

    /**
     * Get the "id" barCart.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<FraudCheckDTO> findOne(Long id);

    /**
     * Delete the "id" barCart.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
