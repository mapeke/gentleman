package kz.bitlab.techboot.gentleman.service;

import kz.bitlab.techboot.gentleman.dto.OrderDTO;
import kz.bitlab.techboot.gentleman.mapper.OrderMapper;
import kz.bitlab.techboot.gentleman.model.Order;
import kz.bitlab.techboot.gentleman.model.User;
import kz.bitlab.techboot.gentleman.repository.OrderRepository;
import kz.bitlab.techboot.gentleman.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final UserRepository userRepository;

    public List<OrderDTO> getOrdersByClient(Long id) {
        return orderMapper.toDtoList(orderRepository.findAllByClientId(id));
    }

    public OrderDTO approveOrder(OrderDTO order) {
        return orderMapper.toDto(orderRepository.save(orderMapper.toModel(order)));
    }

    public List<OrderDTO> getOrdersByBarber(Long id) {
        return orderMapper.toDtoList(orderRepository.findAllByBarberId(id));
    }

    public OrderDTO getOrder(Long id){
        return orderMapper.toDto(orderRepository.findById(id).orElse(new Order()));
    }

    public void deleteOrder(Long id){
        orderRepository.deleteById(id);
    }

    public OrderDTO addOrder(OrderDTO order){
        Long barberId = order.getBarber().getId();
        Long clientId = order.getClient().getId();

        if (barberId == null) {
            throw new IllegalArgumentException("Barber ID must not be null");
        }

        if (clientId == null) {
            throw new IllegalArgumentException("Client ID must not be null");
        }
        User barber = userRepository.findById(order.getBarber().getId())
                .orElseThrow(() -> new IllegalStateException("Barber not found"));
        User client = userRepository.findById(order.getClient().getId())
                .orElseThrow(() -> new IllegalStateException("Client not found"));
        Order newOrder = new Order();
        newOrder.setDate(order.getDate());
        newOrder.setBarber(barber);
        newOrder.setClient(client);
        Order savedOrder = orderRepository.save(newOrder);

        return orderMapper.toDto(savedOrder);
    }

}
