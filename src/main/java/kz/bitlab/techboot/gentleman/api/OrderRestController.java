package kz.bitlab.techboot.gentleman.api;

import kz.bitlab.techboot.gentleman.dto.OrderDTO;
import kz.bitlab.techboot.gentleman.model.User;
import kz.bitlab.techboot.gentleman.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/order")
@RequiredArgsConstructor
public class OrderRestController {

    private final OrderService orderService;

    @GetMapping
    public List<OrderDTO> clientOrderList(Authentication authentication){
        User user = (User) authentication.getPrincipal();
        Long userId = user.getId();
        return orderService.getOrdersByClient(userId);
    }

    @GetMapping(value = "/barberOrderList")
    public List<OrderDTO> barberOrderList(Authentication authentication){
        User user = (User) authentication.getPrincipal();
        Long userId = user.getId();
        return orderService.getOrdersByBarber(userId);
    }

    @GetMapping(value = "{id}")
    public OrderDTO getOrder(@PathVariable(name = "id") Long id){
        return orderService.getOrder(id);
    }

    @PutMapping
    @PreAuthorize("hasAnyRole('ROLE_BARBER')")
    public OrderDTO approveOrder(@RequestBody OrderDTO order){
        return orderService.approveOrder(order);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_USER')")
    public OrderDTO addOrder(@RequestBody OrderDTO order){
        return orderService.addOrder(order);
    }

    @DeleteMapping(value = "{id}")
    @PreAuthorize("hasAnyRole('ROLE_USER')")
    public void deleteOrder(@PathVariable(name = "id") Long id){
        orderService.deleteOrder(id);
    }

}
