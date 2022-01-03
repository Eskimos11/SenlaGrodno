package com.senla.controller;

import com.senla.controller.dto.ProductDto;
import com.senla.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        return productService.saveProduct(productDto);
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
    }
    @GetMapping(value = "/{id}")
    public ProductDto getById(@PathVariable Integer id) {
        return productService.getProductInfo(id);
    }
    @PutMapping
    public ProductDto updateCustomer(@RequestBody ProductDto productDto) {
        return productService.updateProduct(productDto);

    }
}
