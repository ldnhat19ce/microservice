package com.ldnhat.customer.service;

import com.ldnhat.customer.service.dto.CustomerDTO;

import java.util.Optional;

public interface CustomerService {
    /**
     * Save a barCart.
     *
     * @param customerDTO the entity to save.
     * @return the persisted entity.
     */
    CustomerDTO save(CustomerDTO customerDTO);

    /**
     * Updates a barCart.
     *
     * @param customerDTO the entity to update.
     * @return the persisted entity.
     */
    CustomerDTO update(CustomerDTO customerDTO);

    /**
     * Partially updates a barCart.
     *
     * @param customerDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<CustomerDTO> partialUpdate(CustomerDTO customerDTO);

    /**
     * Get the "id" barCart.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<CustomerDTO> findOne(Long id);

    /**
     * Delete the "id" barCart.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
