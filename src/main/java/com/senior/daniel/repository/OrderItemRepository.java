package com.senior.daniel.repository;

import com.senior.daniel.model.OrderItemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItemModel, UUID> {

    OrderItemModel findByOrderIdAndItemId(UUID idOrder, UUID idItem);

}
