package com.application.coopcycle.repository;

import com.application.coopcycle.domain.Cooperative;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the Cooperative entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CooperativeRepository extends JpaRepository<Cooperative, Long>, JpaSpecificationExecutor<Cooperative> {}
