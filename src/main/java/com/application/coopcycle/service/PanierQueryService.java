package com.application.coopcycle.service;

import com.application.coopcycle.domain.*; // for static metamodels
import com.application.coopcycle.domain.Panier;
import com.application.coopcycle.repository.PanierRepository;
import com.application.coopcycle.service.criteria.PanierCriteria;
import com.application.coopcycle.service.dto.PanierDTO;
import com.application.coopcycle.service.mapper.PanierMapper;
import java.util.List;
import javax.persistence.criteria.JoinType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link Panier} entities in the database.
 * The main input is a {@link PanierCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link PanierDTO} or a {@link Page} of {@link PanierDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class PanierQueryService extends QueryService<Panier> {

    private final Logger log = LoggerFactory.getLogger(PanierQueryService.class);

    private final PanierRepository panierRepository;

    private final PanierMapper panierMapper;

    public PanierQueryService(PanierRepository panierRepository, PanierMapper panierMapper) {
        this.panierRepository = panierRepository;
        this.panierMapper = panierMapper;
    }

    /**
     * Return a {@link List} of {@link PanierDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<PanierDTO> findByCriteria(PanierCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Panier> specification = createSpecification(criteria);
        return panierMapper.toDto(panierRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link PanierDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<PanierDTO> findByCriteria(PanierCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Panier> specification = createSpecification(criteria);
        return panierRepository.findAll(specification, page).map(panierMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(PanierCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Panier> specification = createSpecification(criteria);
        return panierRepository.count(specification);
    }

    /**
     * Function to convert {@link PanierCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Panier> createSpecification(PanierCriteria criteria) {
        Specification<Panier> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Panier_.id));
            }
            if (criteria.getPrice() != null) {
                specification = specification.and(buildStringSpecification(criteria.getPrice(), Panier_.price));
            }
            if (criteria.getMadeById() != null) {
                specification =
                    specification.and(
                        buildSpecification(criteria.getMadeById(), root -> root.join(Panier_.madeBy, JoinType.LEFT).get(Compte_.id))
                    );
            }
            if (criteria.getPaidById() != null) {
                specification =
                    specification.and(
                        buildSpecification(
                            criteria.getPaidById(),
                            root -> root.join(Panier_.paidBy, JoinType.LEFT).get(SystemePaiement_.id)
                        )
                    );
            }
        }
        return specification;
    }
}
