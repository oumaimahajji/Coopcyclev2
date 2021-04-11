package com.application.coopcycle.service;

import com.application.coopcycle.domain.*; // for static metamodels
import com.application.coopcycle.domain.Compte;
import com.application.coopcycle.repository.CompteRepository;
import com.application.coopcycle.service.criteria.CompteCriteria;
import com.application.coopcycle.service.dto.CompteDTO;
import com.application.coopcycle.service.mapper.CompteMapper;
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
 * Service for executing complex queries for {@link Compte} entities in the database.
 * The main input is a {@link CompteCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link CompteDTO} or a {@link Page} of {@link CompteDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class CompteQueryService extends QueryService<Compte> {

    private final Logger log = LoggerFactory.getLogger(CompteQueryService.class);

    private final CompteRepository compteRepository;

    private final CompteMapper compteMapper;

    public CompteQueryService(CompteRepository compteRepository, CompteMapper compteMapper) {
        this.compteRepository = compteRepository;
        this.compteMapper = compteMapper;
    }

    /**
     * Return a {@link List} of {@link CompteDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<CompteDTO> findByCriteria(CompteCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Compte> specification = createSpecification(criteria);
        return compteMapper.toDto(compteRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link CompteDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<CompteDTO> findByCriteria(CompteCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Compte> specification = createSpecification(criteria);
        return compteRepository.findAll(specification, page).map(compteMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(CompteCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Compte> specification = createSpecification(criteria);
        return compteRepository.count(specification);
    }

    /**
     * Function to convert {@link CompteCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Compte> createSpecification(CompteCriteria criteria) {
        Specification<Compte> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Compte_.id));
            }
            if (criteria.getName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getName(), Compte_.name));
            }
            if (criteria.getSurname() != null) {
                specification = specification.and(buildStringSpecification(criteria.getSurname(), Compte_.surname));
            }
            if (criteria.getEmail() != null) {
                specification = specification.and(buildStringSpecification(criteria.getEmail(), Compte_.email));
            }
            if (criteria.getCategorie() != null) {
                specification = specification.and(buildSpecification(criteria.getCategorie(), Compte_.categorie));
            }
            if (criteria.getPhoneNumber() != null) {
                specification = specification.and(buildStringSpecification(criteria.getPhoneNumber(), Compte_.phoneNumber));
            }
            if (criteria.getAddress() != null) {
                specification = specification.and(buildStringSpecification(criteria.getAddress(), Compte_.address));
            }
            if (criteria.getPostalCode() != null) {
                specification = specification.and(buildStringSpecification(criteria.getPostalCode(), Compte_.postalCode));
            }
            if (criteria.getCity() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCity(), Compte_.city));
            }
            if (criteria.getPanierId() != null) {
                specification =
                    specification.and(
                        buildSpecification(criteria.getPanierId(), root -> root.join(Compte_.paniers, JoinType.LEFT).get(Panier_.id))
                    );
            }
            if (criteria.getCommandeId() != null) {
                specification =
                    specification.and(
                        buildSpecification(criteria.getCommandeId(), root -> root.join(Compte_.commandes, JoinType.LEFT).get(Commande_.id))
                    );
            }
            if (criteria.getMemberOfId() != null) {
                specification =
                    specification.and(
                        buildSpecification(
                            criteria.getMemberOfId(),
                            root -> root.join(Compte_.memberOf, JoinType.LEFT).get(Cooperative_.id)
                        )
                    );
            }
        }
        return specification;
    }
}
