package com.application.coopcycle.service.mapper;

import com.application.coopcycle.domain.*;
import com.application.coopcycle.service.dto.SystemePaiementDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link SystemePaiement} and its DTO {@link SystemePaiementDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface SystemePaiementMapper extends EntityMapper<SystemePaiementDTO, SystemePaiement> {
    @Named("creditCard")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "creditCard", source = "creditCard")
    SystemePaiementDTO toDtoCreditCard(SystemePaiement systemePaiement);
}
