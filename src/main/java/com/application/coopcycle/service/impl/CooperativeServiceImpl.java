package com.application.coopcycle.service.impl;

import com.application.coopcycle.domain.Cooperative;
import com.application.coopcycle.repository.CooperativeRepository;
import com.application.coopcycle.service.CooperativeService;
import com.application.coopcycle.service.dto.CooperativeDTO;
import com.application.coopcycle.service.mapper.CooperativeMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Cooperative}.
 */
@Service
@Transactional
public class CooperativeServiceImpl implements CooperativeService {

    private final Logger log = LoggerFactory.getLogger(CooperativeServiceImpl.class);

    private final CooperativeRepository cooperativeRepository;

    private final CooperativeMapper cooperativeMapper;

    public CooperativeServiceImpl(CooperativeRepository cooperativeRepository, CooperativeMapper cooperativeMapper) {
        this.cooperativeRepository = cooperativeRepository;
        this.cooperativeMapper = cooperativeMapper;
    }

    @Override
    public CooperativeDTO save(CooperativeDTO cooperativeDTO) {
        log.debug("Request to save Cooperative : {}", cooperativeDTO);
        Cooperative cooperative = cooperativeMapper.toEntity(cooperativeDTO);
        cooperative = cooperativeRepository.save(cooperative);
        return cooperativeMapper.toDto(cooperative);
    }

    @Override
    public Optional<CooperativeDTO> partialUpdate(CooperativeDTO cooperativeDTO) {
        log.debug("Request to partially update Cooperative : {}", cooperativeDTO);

        return cooperativeRepository
            .findById(cooperativeDTO.getId())
            .map(
                existingCooperative -> {
                    cooperativeMapper.partialUpdate(existingCooperative, cooperativeDTO);
                    return existingCooperative;
                }
            )
            .map(cooperativeRepository::save)
            .map(cooperativeMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<CooperativeDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Cooperatives");
        return cooperativeRepository.findAll(pageable).map(cooperativeMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CooperativeDTO> findOne(Long id) {
        log.debug("Request to get Cooperative : {}", id);
        return cooperativeRepository.findById(id).map(cooperativeMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Cooperative : {}", id);
        cooperativeRepository.deleteById(id);
    }
}
