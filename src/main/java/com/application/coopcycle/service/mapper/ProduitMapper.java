package com.application.coopcycle.service.mapper;

import com.application.coopcycle.domain.*;
import com.application.coopcycle.service.dto.ProduitDTO;
import java.util.Set;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Produit} and its DTO {@link ProduitDTO}.
 */
@Mapper(componentModel = "spring", uses = { RestaurantMapper.class })
public interface ProduitMapper extends EntityMapper<ProduitDTO, Produit> {
    @Mapping(target = "restaurants", source = "restaurants", qualifiedByName = "restaurantNameSet")
    ProduitDTO toDto(Produit s);

    @Named("idSet")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    Set<ProduitDTO> toDtoIdSet(Set<Produit> produit);

    @Mapping(target = "removeRestaurant", ignore = true)
    Produit toEntity(ProduitDTO produitDTO);
}
