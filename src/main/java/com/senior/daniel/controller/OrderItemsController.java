package com.senior.daniel.controller;

import com.senior.daniel.dto.OrderItemsDTO;
import com.senior.daniel.service.OrderItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/orders")
public class OrderItemsController {

    @Autowired
    private OrderItemsService orderItemsService;

    @PostMapping("{idOrder}/items")
    public ResponseEntity<OrderItemsDTO> create(@PathVariable UUID idOrder, @RequestBody OrderItemsDTO request) {
        OrderItemsDTO orderItems = orderItemsService.create(idOrder, request);
        if (orderItems == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(orderItems);
    }

    @GetMapping("{idOrder}/items/{idItem}")
    public ResponseEntity<OrderItemsDTO> read(@PathVariable UUID idOrder, @PathVariable UUID idItem) {
        OrderItemsDTO orderItem = orderItemsService.read(idOrder, idItem);
        return ResponseEntity.status(HttpStatus.OK).body(orderItem);
    }

/*
 @PutMapping("{id}")
    public ResponseEntity<Order> update(@PathVariable UUID id, @RequestBody Order request) {
        Order order = orderItemsService.udpate(id, request);
        if (order != null) {
            return ResponseEntity.status(HttpStatus.OK).body(order);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable UUID id) {
        orderItemsService.delete(id);
    }

    @GetMapping
    public ResponseEntity<List<Order>> list() {
        return ResponseEntity.status(HttpStatus.OK).body(orderItemsService.list());
    }
    */
}
