package com.senior.daniel.controller;

import com.senior.daniel.dto.OrderDTO;
import com.senior.daniel.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderDTO> create(@RequestBody OrderDTO request) {
        OrderDTO order = orderService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }


    @GetMapping("{id}")
    public ResponseEntity<OrderDTO> read(@PathVariable UUID id) {
        OrderDTO orderDTO = orderService.read(id);
        if (orderDTO != null) {
            return ResponseEntity.status(HttpStatus.OK).body(orderDTO);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PutMapping("{id}")
    public ResponseEntity<OrderDTO> update(@PathVariable UUID id, @RequestBody OrderDTO request) {
        OrderDTO order = orderService.udpate(id, request);
        if (order != null) {
            return ResponseEntity.status(HttpStatus.OK).body(order);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable UUID id) {
        orderService.delete(id);
    }

    @GetMapping
    public ResponseEntity<List<OrderDTO>> list() {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.list());
    }

}
