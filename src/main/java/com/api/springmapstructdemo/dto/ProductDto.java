package com.api.springmapstructdemo.dto;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {

    @Id
    private int id;
    private String name;
    private String description;
    private int quantity;
    private long price;
}
