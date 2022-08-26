package com.senior.daniel.model;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Table(name = "ORDER_ITEM")
public class OrderItemModel {

    @Id
    private UUID id = UUID.randomUUID();

    @ManyToOne
    @JoinColumn(name = "item_id")
    private ItemModel item;

    private Double quantity;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderModel order;

}
