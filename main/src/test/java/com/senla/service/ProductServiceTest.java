package com.senla.service;

import com.senla.api.dao.ProductDao;
import com.senla.controller.dto.ProductDto.ProductCreateDto;
import com.senla.controller.dto.ProductDto.ProductDto;
import com.senla.entity.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.annotation.Rollback;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@Rollback(value = false)
public class ProductServiceTest {

    @InjectMocks
    private ProductService productService;
    @Mock
    private ProductDao productDao;

    @Test
    public void saveProductShouldFinishOk() {

        final String product = "XLEB";
       when(productDao.save(any())).thenReturn(Product.builder().title("XLEB").price(11).amount(10).build());

        final ProductDto productDto = productService.createProduct(
                ProductDto.builder()
                        .title("XLEB")
                        .price(11)
                        .amount(10)
                        .build());
        assertEquals(product, productDto.getTitle());
        assertEquals(11, productDto.getPrice());
        assertEquals(10, productDto.getAmount());
    }

    @Test
    public void getUserInfoTest() {
        final Long id = 1L;
        final String title = "user";
        final Integer price = 10;
        final Integer amount = 11;
        when(productDao.save(any())).thenReturn(Product.builder().id(id).title(title).price(price).amount(amount).build());
        when(productDao.getById(any())).thenReturn(Product.builder().id(id).title(title).price(price).amount(amount).build());
         productDao.save(
                 Product.builder()
                        .id(id)
                        .title(title)
                        .price(price)
                        .amount(amount)
                        .build());

        ProductCreateDto productDto = productService.getProductInfo(1L);
        assertEquals(id, productDto.getId());
        assertEquals(title, productDto.getTitle());
        assertEquals(price, productDto.getPrice());
        assertEquals(amount, productDto.getAmount());

    }

    @Test()
    public void deleteProductByIdTest() {
        final Long id = 1L;
        final String title = "user";
        final Integer price = 10;
        final Integer amount = 11;
        when(productDao.save(any())).thenReturn(Product.builder().id(id).title(title).price(price).amount(amount).build());
        Product product = productDao.save(
                Product.builder()
                        .id(id)
                        .title(title)
                        .price(price)
                        .amount(amount)
                        .build());

        Product product2 = productDao.getById(product.getId());
        productDao.deleteById(id);
        assertNull(productDao.getById(product.getId()));
    }

}
