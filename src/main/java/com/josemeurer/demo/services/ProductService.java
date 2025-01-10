package com.josemeurer.demo.services;

import com.josemeurer.demo.dtos.ProductDto;
import com.josemeurer.demo.entities.Product;
import com.josemeurer.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductDto> findAll() {
        List<Product> list = productRepository.findAll();
        return list.stream().map(this::entityToDto).toList();
    }

    public ProductDto findById(long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));

        return entityToDto(product);
    }



    private ProductDto entityToDto(Product entity) {
        return ProductDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .price(entity.getPrice())
                .build();
    }
}
