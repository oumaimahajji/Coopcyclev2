package com.application.coopcycle.repository;

import com.application.coopcycle.domain.Compte;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the Compte entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CompteRepository extends JpaRepository<Compte, Long>, JpaSpecificationExecutor<Compte> {}
