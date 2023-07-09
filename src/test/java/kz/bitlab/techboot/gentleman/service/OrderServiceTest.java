package kz.bitlab.techboot.gentleman.service;

import kz.bitlab.techboot.gentleman.dto.OrderDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class OrderServiceTest {
    @Mock
    private OrderService orderService;

    @Test
    public void testGetOrder() throws Exception {
        //prepare
        when(orderService.getOrder(1L)).thenReturn(null);
        //testing
        OrderDTO order = orderService.getOrder(1L);
        //validate
        verify(orderService).getOrder(1L);
    }

    @Test
    public void testGetOrdersByBarber() throws Exception {
        //prepare
        when(orderService.getOrdersByBarber(1L)).thenReturn(null);
        //testing
        List<OrderDTO> orderDTOList = orderService.getOrdersByBarber(1L);
        //validate
        verify(orderService).getOrdersByBarber(1L);
    }

    @Test
    public void testGetOrdersByClient() throws Exception {
        //prepare
        when(orderService.getOrdersByClient(1L)).thenReturn(null);
        //testing
        List<OrderDTO> orderDTOList = orderService.getOrdersByClient(1L);
        //validate
        verify(orderService).getOrdersByClient(1L);
    }

    @Test
    public void testApproveOrder() throws Exception {
        OrderDTO order = new OrderDTO();
        //prepare
        when(orderService.approveOrder(order)).thenReturn(null);
        //testing
        orderService.approveOrder(order);
        //validate
        verify(orderService).approveOrder(order);
    }

    @Test
    public void testDeleteOrder() throws Exception {
        //prepare
        orderService.deleteOrder(1L);
        //validate
        verify(orderService).deleteOrder(1L);
    }

    @Test
    public void testAddOrder() throws Exception {
        OrderDTO order = new OrderDTO();
        //prepare
        when(orderService.addOrder(order)).thenReturn(null);
        //testing
        orderService.addOrder(order);
        //validate
        verify(orderService).addOrder(order);
    }

}
