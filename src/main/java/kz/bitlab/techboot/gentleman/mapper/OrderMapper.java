package kz.bitlab.techboot.gentleman.mapper;

import kz.bitlab.techboot.gentleman.dto.OrderDTO;
import kz.bitlab.techboot.gentleman.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(source = "client", target = "client")
    OrderDTO toDto(Order order);

    @Mapping(source = "client", target = "client")
    Order toModel(OrderDTO orderDTO);

    List<OrderDTO> toDtoList(List<Order> orderList);
    List<Order> toModelList(List<OrderDTO> orderList);
}
