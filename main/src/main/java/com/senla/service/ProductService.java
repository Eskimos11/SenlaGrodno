package com.senla.service;

import com.senla.api.dao.ProductDao;
import com.senla.controller.dto.ProductDto.ProductDto;
import com.senla.entity.Product;
import com.senla.exception.ProductNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import static java.util.Optional.ofNullable;

@Log4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductDao productDao;
    private final ModelMapper mapper;

    public ProductDto saveProduct(ProductDto productDto) {
        final Product product = mapper.map(productDto, Product.class);
        final Product productSave = productDao.save(product);
        return mapper.map(productSave, ProductDto.class);
    }

    public void deleteProduct(Integer id) {
        productDao.deleteById(id);
    }

    public ProductDto getProductInfo(Integer id) {
        final Product product = ofNullable(productDao.getById(id))
                .orElseThrow(() -> new ProductNotFoundException(id));
        return mapper.map(product, ProductDto.class);
    }

    public ProductDto updateProduct(ProductDto productDto) {
        final Product product = mapper.map(productDto, Product.class);
        final Product productUpdate = productDao.update(product);
        return mapper.map(productUpdate, ProductDto.class);
    }

}
