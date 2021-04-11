package com.application.coopcycle.service.mapper;

import com.application.coopcycle.domain.*;
import com.application.coopcycle.service.dto.CompteDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Compte} and its DTO {@link CompteDTO}.
 */
@Mapper(componentModel = "spring", uses = { CooperativeMapper.class })
public interface CompteMapper extends EntityMapper<CompteDTO, Compte> {
    @Mapping(target = "memberOf", source = "memberOf", qualifiedByName = "cooperativeName")
    CompteDTO toDto(Compte s);

    @Named("name")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    CompteDTO toDtoName(Compte compte);
}
