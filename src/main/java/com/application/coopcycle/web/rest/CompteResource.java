package com.application.coopcycle.web.rest;

import com.application.coopcycle.repository.CompteRepository;
import com.application.coopcycle.service.CompteQueryService;
import com.application.coopcycle.service.CompteService;
import com.application.coopcycle.service.criteria.CompteCriteria;
import com.application.coopcycle.service.dto.CompteDTO;
import com.application.coopcycle.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.PaginationUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.application.coopcycle.domain.Compte}.
 */
@RestController
@RequestMapping("/api")
public class CompteResource {

    private final Logger log = LoggerFactory.getLogger(CompteResource.class);

    private static final String ENTITY_NAME = "compte";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final CompteService compteService;

    private final CompteRepository compteRepository;

    private final CompteQueryService compteQueryService;

    public CompteResource(CompteService compteService, CompteRepository compteRepository, CompteQueryService compteQueryService) {
        this.compteService = compteService;
        this.compteRepository = compteRepository;
        this.compteQueryService = compteQueryService;
    }

    /**
     * {@code POST  /comptes} : Create a new compte.
     *
     * @param compteDTO the compteDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new compteDTO, or with status {@code 400 (Bad Request)} if the compte has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/comptes")
    public ResponseEntity<CompteDTO> createCompte(@Valid @RequestBody CompteDTO compteDTO) throws URISyntaxException {
        log.debug("REST request to save Compte : {}", compteDTO);
        if (compteDTO.getId() != null) {
            throw new BadRequestAlertException("A new compte cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CompteDTO result = compteService.save(compteDTO);
        return ResponseEntity
            .created(new URI("/api/comptes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /comptes/:id} : Updates an existing compte.
     *
     * @param id the id of the compteDTO to save.
     * @param compteDTO the compteDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated compteDTO,
     * or with status {@code 400 (Bad Request)} if the compteDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the compteDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/comptes/{id}")
    public ResponseEntity<CompteDTO> updateCompte(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody CompteDTO compteDTO
    ) throws URISyntaxException {
        log.debug("REST request to update Compte : {}, {}", id, compteDTO);
        if (compteDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, compteDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!compteRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        CompteDTO result = compteService.save(compteDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, compteDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /comptes/:id} : Partial updates given fields of an existing compte, field will ignore if it is null
     *
     * @param id the id of the compteDTO to save.
     * @param compteDTO the compteDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated compteDTO,
     * or with status {@code 400 (Bad Request)} if the compteDTO is not valid,
     * or with status {@code 404 (Not Found)} if the compteDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the compteDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/comptes/{id}", consumes = "application/merge-patch+json")
    public ResponseEntity<CompteDTO> partialUpdateCompte(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody CompteDTO compteDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update Compte partially : {}, {}", id, compteDTO);
        if (compteDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, compteDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!compteRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<CompteDTO> result = compteService.partialUpdate(compteDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, compteDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /comptes} : get all the comptes.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of comptes in body.
     */
    @GetMapping("/comptes")
    public ResponseEntity<List<CompteDTO>> getAllComptes(CompteCriteria criteria, Pageable pageable) {
        log.debug("REST request to get Comptes by criteria: {}", criteria);
        Page<CompteDTO> page = compteQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /comptes/count} : count all the comptes.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/comptes/count")
    public ResponseEntity<Long> countComptes(CompteCriteria criteria) {
        log.debug("REST request to count Comptes by criteria: {}", criteria);
        return ResponseEntity.ok().body(compteQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /comptes/:id} : get the "id" compte.
     *
     * @param id the id of the compteDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the compteDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/comptes/{id}")
    public ResponseEntity<CompteDTO> getCompte(@PathVariable Long id) {
        log.debug("REST request to get Compte : {}", id);
        Optional<CompteDTO> compteDTO = compteService.findOne(id);
        return ResponseUtil.wrapOrNotFound(compteDTO);
    }

    /**
     * {@code DELETE  /comptes/:id} : delete the "id" compte.
     *
     * @param id the id of the compteDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/comptes/{id}")
    public ResponseEntity<Void> deleteCompte(@PathVariable Long id) {
        log.debug("REST request to delete Compte : {}", id);
        compteService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
