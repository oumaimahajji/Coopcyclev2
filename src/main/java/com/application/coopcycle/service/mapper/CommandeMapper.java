package com.application.coopcycle.service.mapper;

import com.application.coopcycle.domain.*;
import com.application.coopcycle.service.dto.CommandeDTO;
import java.util.Set;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Commande} and its DTO {@link CommandeDTO}.
 */
@Mapper(componentModel = "spring", uses = { PanierMapper.class, ProduitMapper.class, CompteMapper.class })
public interface CommandeMapper extends EntityMapper<CommandeDTO, Commande> {
    @Mapping(target = "price", source = "price", qualifiedByName = "price")
    @Mapping(target = "produits", source = "produits", qualifiedByName = "idSet")
    @Mapping(target = "deliveredBy", source = "deliveredBy", qualifiedByName = "name")
    CommandeDTO toDto(Commande s);

    @Mapping(target = "removeProduit", ignore = true)
    Commande toEntity(CommandeDTO commandeDTO);
}
