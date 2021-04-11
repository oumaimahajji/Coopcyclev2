package com.application.coopcycle.service.mapper;

import com.application.coopcycle.domain.*;
import com.application.coopcycle.service.dto.PanierDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Panier} and its DTO {@link PanierDTO}.
 */
@Mapper(componentModel = "spring", uses = { CompteMapper.class, SystemePaiementMapper.class })
public interface PanierMapper extends EntityMapper<PanierDTO, Panier> {
    @Mapping(target = "madeBy", source = "madeBy", qualifiedByName = "name")
    @Mapping(target = "paidBy", source = "paidBy", qualifiedByName = "creditCard")
    PanierDTO toDto(Panier s);

    @Named("price")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "price", source = "price")
    PanierDTO toDtoPrice(Panier panier);
}
