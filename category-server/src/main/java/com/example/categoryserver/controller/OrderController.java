package com.example.categoryserver.controller;

import com.example.categoryserver.models.Order;
import com.example.categoryserver.service.OrderService;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class OrderController {
    private static final String ORDER_SERVICE ="orderService" ;

    @Autowired
    public OrderService orderService;

    @GetMapping("/orders")
    @RateLimiter(name = ORDER_SERVICE)
    public List<Order> getLisOrder(){
        return  orderService.getListOrder();
    }

    @GetMapping("/orders/{id}")
    public Order getUserById(@PathVariable(value = "id") long id){
        return orderService.getOrderById(id);
    }

    @PostMapping("/orders")
    public Order addOrder(@RequestBody Order order) {
        return orderService.addOrder(order);
    }

    @DeleteMapping("/orders/{orderId}")
    public void deleteOrder(@PathVariable(value = "orderId") long orderId){
        orderService.deleteOrderById(orderId);
    }
}


