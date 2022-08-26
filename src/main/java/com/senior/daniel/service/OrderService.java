package com.senior.daniel.service;

import com.senior.daniel.dto.OrderDTO;
import com.senior.daniel.model.OrderModel;
import com.senior.daniel.repository.OrderRepository;
import lombok.val;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ModelMapper modelMapper;

    public OrderDTO create(OrderDTO orderDTO) {
        orderDTO.setId(UUID.randomUUID());
        var orderModel = modelMapper.map(orderDTO, OrderModel.class);
        orderModel = orderRepository.save(orderModel);
        return modelMapper.map(orderModel, OrderDTO.class);
    }

    public OrderDTO read(UUID id) {
        val optional = orderRepository.findById(id);
        if (optional.isPresent()) {
            return modelMapper.map(optional.get(), OrderDTO.class);
        }
        return null;
    }

    public OrderDTO udpate(UUID id, OrderDTO orderDTO) {
        Optional<OrderModel> optionalOrder = orderRepository.findById(id);
        if (optionalOrder.isPresent()) {
            orderDTO.setId(optionalOrder.get().getId());
            var orderModel = modelMapper.map(orderDTO, OrderModel.class);
            orderModel = orderRepository.save(orderModel);
            return modelMapper.map(orderModel, OrderDTO.class);
        }
        return null;
    }

    public void delete(UUID id) {
        orderRepository.deleteById(id);
    }

    public List<OrderDTO> list() {
        List<OrderDTO> orderDTOS = new ArrayList<>();
        orderRepository.findAll().forEach(model -> {
            orderDTOS.add(modelMapper.map(model, OrderDTO.class));
        });
        return orderDTOS;
    }

}
