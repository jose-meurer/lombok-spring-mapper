package com.josemeurer.demo.services;

import com.josemeurer.demo.dtos.ProductDto;
import com.josemeurer.demo.entities.Product;
import com.josemeurer.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductDto> findAll() {
        List<Product> list = productRepository.findAll();
        return list.stream().map(this::entityToDto).toList();
    }

    private ProductDto entityToDto(Product entity) {
        return new ProductDto(entity.getId(), entity.getName(), entity.getDescription(), entity.getPrice());
    }
}
