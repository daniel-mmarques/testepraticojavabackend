package com.senior.daniel.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@Table(name = "`ORDER`")
public class OrderModel {

    @Id
    private UUID id;

    @Column
    @NotNull
    private Integer number;

    @Column
    @NotNull
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime date;

    @Column
    @NotNull
    private Double percentualDiscount;

    @Column
    private Double totalValue;

    @OneToMany(mappedBy = "order")
    Set<OrderItemModel> orderItem;

}
