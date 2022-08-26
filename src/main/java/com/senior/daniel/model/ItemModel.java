package com.senior.daniel.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@Table(name = "ITEM")
public class ItemModel {

    @Id
    private UUID id;

    @Column
    @NotNull
    private String description;

    @Column
    @NotNull
    private Double value;

    @Column
    @NotNull
    private char type;

    @OneToMany(mappedBy = "item")
    private Set<OrderItemModel> orders;

}
