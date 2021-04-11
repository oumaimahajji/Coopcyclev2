package com.application.coopcycle.repository;

import com.application.coopcycle.domain.SystemePaiement;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the SystemePaiement entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SystemePaiementRepository extends JpaRepository<SystemePaiement, Long>, JpaSpecificationExecutor<SystemePaiement> {}
