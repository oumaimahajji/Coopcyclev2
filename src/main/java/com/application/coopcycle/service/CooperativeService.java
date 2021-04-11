package com.application.coopcycle.service;

import com.application.coopcycle.service.dto.CooperativeDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.application.coopcycle.domain.Cooperative}.
 */
public interface CooperativeService {
    /**
     * Save a cooperative.
     *
     * @param cooperativeDTO the entity to save.
     * @return the persisted entity.
     */
    CooperativeDTO save(CooperativeDTO cooperativeDTO);

    /**
     * Partially updates a cooperative.
     *
     * @param cooperativeDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<CooperativeDTO> partialUpdate(CooperativeDTO cooperativeDTO);

    /**
     * Get all the cooperatives.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<CooperativeDTO> findAll(Pageable pageable);

    /**
     * Get the "id" cooperative.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<CooperativeDTO> findOne(Long id);

    /**
     * Delete the "id" cooperative.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
