package com.application.coopcycle.repository;

import com.application.coopcycle.domain.Produit;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the Produit entity.
 */
@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long>, JpaSpecificationExecutor<Produit> {
    @Query(
        value = "select distinct produit from Produit produit left join fetch produit.restaurants",
        countQuery = "select count(distinct produit) from Produit produit"
    )
    Page<Produit> findAllWithEagerRelationships(Pageable pageable);

    @Query("select distinct produit from Produit produit left join fetch produit.restaurants")
    List<Produit> findAllWithEagerRelationships();

    @Query("select produit from Produit produit left join fetch produit.restaurants where produit.id =:id")
    Optional<Produit> findOneWithEagerRelationships(@Param("id") Long id);
}
