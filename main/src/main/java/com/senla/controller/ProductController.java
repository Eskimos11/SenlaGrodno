package com.senla.controller;

import com.senla.controller.dto.ProductDto.ProductDto;
import com.senla.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @Secured("ROLE_ADMIN")
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        return productService.saveProduct(productDto);
    }
    @DeleteMapping("/{id}")
    @Secured("ROLE_ADMIN")
    public void deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
    }
    @GetMapping(value = "/{id}")
    @Secured("ROLE_ADMIN")
    public ProductDto getById(@PathVariable Integer id) {
        return productService.getProductInfo(id);
    }
    @PutMapping
    @Secured("ROLE_ADMIN")
    public ProductDto updateCustomer(@RequestBody ProductDto productDto) {
        return productService.updateProduct(productDto);

    }
}
