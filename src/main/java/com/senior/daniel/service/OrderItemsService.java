package com.senior.daniel.service;

import com.senior.daniel.dto.OrderItemsDTO;
import com.senior.daniel.model.ItemModel;
import com.senior.daniel.model.OrderItemModel;
import com.senior.daniel.model.OrderModel;
import com.senior.daniel.repository.ItemRepository;
import com.senior.daniel.repository.OrderItemRepository;
import com.senior.daniel.repository.OrderRepository;
import lombok.val;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderItemsService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private ModelMapper modelMapper;

    public OrderItemsDTO create(UUID idOrder, OrderItemsDTO orderItems) {

        orderItems.setId(UUID.randomUUID());
        Optional<OrderModel> optionalOrder = orderRepository.findById(idOrder);
        Optional<ItemModel> optionalItem = itemRepository.findById(orderItems.getItemId());

        if (optionalOrder.isEmpty()) {
            return null;
        }

        if (optionalItem.isEmpty()) {
            return null;
        }

        var orderItem = new OrderItemModel();
        orderItem.setOrder(optionalOrder.get());
        orderItem.setItem(optionalItem.get());
        orderItem.setQuantity(orderItems.getQuantity());

        val orderItemModel = orderItemRepository.save(orderItem);
        return modelMapper.map(orderItemModel, OrderItemsDTO.class);
    }


    public OrderItemsDTO read(UUID idOrder, UUID idItem) {
        OrderItemModel orderItemModel = orderItemRepository.findByOrderIdAndItemId(idOrder, idItem);
        return modelMapper.map(orderItemModel, OrderItemsDTO.class);
    }
/*
    public OrderItems udpate(UUID id, OrderItems order) {
        Optional<OrderItems> optionalOrder = orderItemRepository.findById(id);
        if (optionalOrder.isPresent()) {
            order.setId(optionalOrder.get().getId());
            return orderItemRepository.save(order);
        }
        return null;
    }

    public void delete(UUID id) {
        orderItemRepository.deleteById(id);
    }

    public List<OrderItems> list() {
        return orderItemRepository.findAll();
    }
*/


}
