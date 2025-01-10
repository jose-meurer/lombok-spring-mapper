package com.josemeurer.demo.controllers;

import com.josemeurer.demo.dtos.ProductDto;
import com.josemeurer.demo.services.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private HttpServletRequest servlet;

    @GetMapping
    public ResponseEntity<List<ProductDto>> findAll() {
        List<ProductDto> list = productService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> findById(@PathVariable("id") long id) {
        ProductDto dto = productService.findById(id);


        return ResponseEntity.ok().body(dto);
    }
}
