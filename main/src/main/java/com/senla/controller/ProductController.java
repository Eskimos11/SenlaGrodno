package com.senla.controller;

import com.senla.controller.dto.ProductDto.ProductDto;
import com.senla.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        return productService.createProduct(productDto);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping(value = "/{id}")
    public ProductDto getById(@PathVariable Integer id) {
        return productService.getProductInfo(id);
    }

    @PutMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
        return productService.updateProduct(productDto);
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping("/limit/{amount}")
    public List<ProductDto> getProductLimit(@PathVariable Integer amount){
        return  productService.getProductLimit(amount);
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping("/order/{id}")
    public List<ProductDto> getProductOrder(@PathVariable Integer id){
        return  productService.getProductOrders(id);
    }

}
