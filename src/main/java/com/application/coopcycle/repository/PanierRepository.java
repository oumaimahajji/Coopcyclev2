package com.application.coopcycle.repository;

import com.application.coopcycle.domain.Panier;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the Panier entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PanierRepository extends JpaRepository<Panier, Long>, JpaSpecificationExecutor<Panier> {}
