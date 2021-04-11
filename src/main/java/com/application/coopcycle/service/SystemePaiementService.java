package com.application.coopcycle.service;

import com.application.coopcycle.service.dto.SystemePaiementDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.application.coopcycle.domain.SystemePaiement}.
 */
public interface SystemePaiementService {
    /**
     * Save a systemePaiement.
     *
     * @param systemePaiementDTO the entity to save.
     * @return the persisted entity.
     */
    SystemePaiementDTO save(SystemePaiementDTO systemePaiementDTO);

    /**
     * Partially updates a systemePaiement.
     *
     * @param systemePaiementDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<SystemePaiementDTO> partialUpdate(SystemePaiementDTO systemePaiementDTO);

    /**
     * Get all the systemePaiements.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<SystemePaiementDTO> findAll(Pageable pageable);

    /**
     * Get the "id" systemePaiement.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<SystemePaiementDTO> findOne(Long id);

    /**
     * Delete the "id" systemePaiement.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
