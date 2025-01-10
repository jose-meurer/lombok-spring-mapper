package com.josemeurer.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDto {

    private long id;
    private String name;
    private String description;
    private Double price;
}