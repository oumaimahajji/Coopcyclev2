package com.application.coopcycle.service;

import com.application.coopcycle.domain.*; // for static metamodels
import com.application.coopcycle.domain.Cooperative;
import com.application.coopcycle.repository.CooperativeRepository;
import com.application.coopcycle.service.criteria.CooperativeCriteria;
import com.application.coopcycle.service.dto.CooperativeDTO;
import com.application.coopcycle.service.mapper.CooperativeMapper;
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
 * Service for executing complex queries for {@link Cooperative} entities in the database.
 * The main input is a {@link CooperativeCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link CooperativeDTO} or a {@link Page} of {@link CooperativeDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class CooperativeQueryService extends QueryService<Cooperative> {

    private final Logger log = LoggerFactory.getLogger(CooperativeQueryService.class);

    private final CooperativeRepository cooperativeRepository;

    private final CooperativeMapper cooperativeMapper;

    public CooperativeQueryService(CooperativeRepository cooperativeRepository, CooperativeMapper cooperativeMapper) {
        this.cooperativeRepository = cooperativeRepository;
        this.cooperativeMapper = cooperativeMapper;
    }

    /**
     * Return a {@link List} of {@link CooperativeDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<CooperativeDTO> findByCriteria(CooperativeCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Cooperative> specification = createSpecification(criteria);
        return cooperativeMapper.toDto(cooperativeRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link CooperativeDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<CooperativeDTO> findByCriteria(CooperativeCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Cooperative> specification = createSpecification(criteria);
        return cooperativeRepository.findAll(specification, page).map(cooperativeMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(CooperativeCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Cooperative> specification = createSpecification(criteria);
        return cooperativeRepository.count(specification);
    }

    /**
     * Function to convert {@link CooperativeCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Cooperative> createSpecification(CooperativeCriteria criteria) {
        Specification<Cooperative> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Cooperative_.id));
            }
            if (criteria.getCooperativeName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCooperativeName(), Cooperative_.cooperativeName));
            }
            if (criteria.getCooperativeCity() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCooperativeCity(), Cooperative_.cooperativeCity));
            }
            if (criteria.getCooperativeAddress() != null) {
                specification =
                    specification.and(buildStringSpecification(criteria.getCooperativeAddress(), Cooperative_.cooperativeAddress));
            }
            if (criteria.getCompteId() != null) {
                specification =
                    specification.and(
                        buildSpecification(criteria.getCompteId(), root -> root.join(Cooperative_.comptes, JoinType.LEFT).get(Compte_.id))
                    );
            }
        }
        return specification;
    }
}
