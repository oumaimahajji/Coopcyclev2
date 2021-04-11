package com.application.coopcycle.service;

import com.application.coopcycle.domain.*; // for static metamodels
import com.application.coopcycle.domain.Commande;
import com.application.coopcycle.repository.CommandeRepository;
import com.application.coopcycle.service.criteria.CommandeCriteria;
import com.application.coopcycle.service.dto.CommandeDTO;
import com.application.coopcycle.service.mapper.CommandeMapper;
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
 * Service for executing complex queries for {@link Commande} entities in the database.
 * The main input is a {@link CommandeCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link CommandeDTO} or a {@link Page} of {@link CommandeDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class CommandeQueryService extends QueryService<Commande> {

    private final Logger log = LoggerFactory.getLogger(CommandeQueryService.class);

    private final CommandeRepository commandeRepository;

    private final CommandeMapper commandeMapper;

    public CommandeQueryService(CommandeRepository commandeRepository, CommandeMapper commandeMapper) {
        this.commandeRepository = commandeRepository;
        this.commandeMapper = commandeMapper;
    }

    /**
     * Return a {@link List} of {@link CommandeDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<CommandeDTO> findByCriteria(CommandeCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Commande> specification = createSpecification(criteria);
        return commandeMapper.toDto(commandeRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link CommandeDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<CommandeDTO> findByCriteria(CommandeCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Commande> specification = createSpecification(criteria);
        return commandeRepository.findAll(specification, page).map(commandeMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(CommandeCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Commande> specification = createSpecification(criteria);
        return commandeRepository.count(specification);
    }

    /**
     * Function to convert {@link CommandeCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Commande> createSpecification(CommandeCriteria criteria) {
        Specification<Commande> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Commande_.id));
            }
            if (criteria.getCreated() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCreated(), Commande_.created));
            }
            if (criteria.getState() != null) {
                specification = specification.and(buildSpecification(criteria.getState(), Commande_.state));
            }
            if (criteria.getTimeStarted() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getTimeStarted(), Commande_.timeStarted));
            }
            if (criteria.getTimeEnded() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getTimeEnded(), Commande_.timeEnded));
            }
            if (criteria.getPriceId() != null) {
                specification =
                    specification.and(
                        buildSpecification(criteria.getPriceId(), root -> root.join(Commande_.price, JoinType.LEFT).get(Panier_.id))
                    );
            }
            if (criteria.getProduitId() != null) {
                specification =
                    specification.and(
                        buildSpecification(criteria.getProduitId(), root -> root.join(Commande_.produits, JoinType.LEFT).get(Produit_.id))
                    );
            }
            if (criteria.getDeliveredById() != null) {
                specification =
                    specification.and(
                        buildSpecification(
                            criteria.getDeliveredById(),
                            root -> root.join(Commande_.deliveredBy, JoinType.LEFT).get(Compte_.id)
                        )
                    );
            }
        }
        return specification;
    }
}
