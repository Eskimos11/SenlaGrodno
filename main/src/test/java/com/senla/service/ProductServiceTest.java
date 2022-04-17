package com.senla.service;

import com.senla.api.dao.ProductDao;
import com.senla.controller.dto.ProductDto.ProductCreateDto;
import com.senla.controller.dto.ProductDto.ProductDto;
import com.senla.entity.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@Rollback(value = false)
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProductServiceTest {

    @InjectMocks
    private ProductService productService;
    @Spy
    private ModelMapper modelMapper;
    @Mock
    private ProductDao productDao;
    private ProductDto productDto;

    @BeforeEach
    public void init(){
        when(productDao.save(any())).thenReturn(Product.builder().title("XLEB").price(11).amount(10).build());
         productDto = productService.createProduct(
                ProductDto.builder()
                        .title("XLEB")
                        .price(11)
                        .amount(10)
                        .build());
        when(productDao.save(Product.builder().title("Moloko").price(10).amount(9).build()))
                .thenReturn(Product.builder().id(124L).title("Moloko").price(10).amount(9).build());
        productDao.save(
                Product.builder()
                        .title("Moloko")
                        .price(10)
                        .amount(9)
                        .build());
    }

    @Test
    public void saveProductShouldFinishOk() {
        assertEquals("XLEB", productDto.getTitle());
        assertEquals(11, productDto.getPrice());
        assertEquals(10, productDto.getAmount());
    }

    @Test
    public void getUserInfoTest() {
        when(productDao.getById(any())).thenReturn(Product.builder().title("XLEB").price(11).amount(10).build());
        ProductCreateDto productDto = productService.getProductInfo(1L);
        assertEquals("XLEB", productDto.getTitle());
        assertEquals(11, productDto.getPrice());
        assertEquals(10, productDto.getAmount());
    }

    @Test
    public void deleteProductByIdTest() {
        productService.deleteProduct(productDto.getId());
        assertNull(productDao.getById(productDto.getId()));
    }

    @Test
    public void updateProductTest() {
        when(productDao.save(any())).thenReturn(Product.builder().id(123L).title("XLEB").price(11).amount(10).build());
        when(productDao.update(any())).thenReturn(Product.builder().id(123L).title("MOLOKO").price(123).amount(312).build());
        final Long id = 1L;
        final String title = "MOLOKO";
        final Integer price = 10;
        final Integer amount = 11;
        ProductDto product = productService.createProduct(
                ProductDto.builder()
                        .id(id)
                        .title(title)
                        .price(price)
                        .amount(amount)
                        .build());
        ProductDto productDtoUpdate = ProductDto.builder()
                .id(123L)
                .title("MOLOKO")
                .price(123)
                .amount(312)
                .build();
        product = productService.updateProduct(product);
        assertEquals(product.getId(), productDtoUpdate.getId());
    }

    @Test
    public void getLimitProductTest() {
        when(productDao.getProductLimit(any())).thenReturn(List.of(Product.builder()
                .title("Moloko")
                .price(10)
                .amount(9)
                .build()));
        List<ProductDto> productList = productService.getProductLimit(9);
        assertEquals(1, productList.size());
    }


}
