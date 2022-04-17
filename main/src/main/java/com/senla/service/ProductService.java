package com.senla.service;

import com.senla.api.dao.ProductDao;
import com.senla.controller.dto.ProductDto.ProductCreateDto;
import com.senla.controller.dto.ProductDto.ProductDto;
import com.senla.entity.Product;
import com.senla.exception.ProductNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

//@Log4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductDao productDao;
    private final ModelMapper mapper;

    @Transactional
    public ProductDto createProduct(ProductDto productDto) {
        final Product product = mapper.map(productDto, Product.class);
        final Product productSave = productDao.save(product);
        return mapper.map(productSave, ProductDto.class);
    }
    @Transactional
    public void deleteProduct(Long id) {
        productDao.deleteById(id);
    }
    @Transactional
    public ProductCreateDto getProductInfo(Long id) {
        final Product product = ofNullable(productDao.getById(id))
                .orElseThrow(() -> new ProductNotFoundException(id));

        return mapper.map(product, ProductCreateDto.class);
    }
    @Transactional
    public ProductDto updateProduct(ProductDto productDto) {
        final Product product = mapper.map(productDto, Product.class);
        final Product productUpdate = productDao.update(product);
        return mapper.map(productUpdate, ProductDto.class);
    }
    @Transactional
    public List<ProductDto> getProductLimit(Integer amount) {
        List<Product> productList = productDao.getProductLimit(amount);
        return productList
                .stream()
                .map(product -> mapper.map(product, ProductDto.class))
                .collect(Collectors.toList());
    }



}
