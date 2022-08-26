package com.senior.daniel.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class OrderItemsDTO {

    @Id
    private UUID id;

    @NotNull
    @JsonIgnore
    private UUID orderId;

    @NotNull
    private UUID itemId;

    @NotNull
    private Double quantity;

    private Double totalValue;

}
