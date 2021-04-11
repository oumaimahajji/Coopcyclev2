package com.application.coopcycle.service.mapper;

import com.application.coopcycle.domain.*;
import com.application.coopcycle.service.dto.RestaurantDTO;
import java.util.Set;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Restaurant} and its DTO {@link RestaurantDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface RestaurantMapper extends EntityMapper<RestaurantDTO, Restaurant> {
    @Named("restaurantNameSet")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "restaurantName", source = "restaurantName")
    Set<RestaurantDTO> toDtoRestaurantNameSet(Set<Restaurant> restaurant);
}
