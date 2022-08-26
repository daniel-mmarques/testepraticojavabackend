package com.senior.daniel.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class ItemDTO {
    private UUID id;
    @NotNull
    private String description;
    @NotNull
    private Double value;
    @NotNull
    private char type;
}
