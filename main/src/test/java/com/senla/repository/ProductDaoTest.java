package com.senla.repository;

import com.senla.BaseRepositoryTest;
import com.senla.api.dao.ProductDao;
import com.senla.dao.ProductDaoImpl;
import com.senla.entity.Product;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import javax.persistence.NoResultException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = ProductDaoImpl.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductDaoTest extends BaseRepositoryTest {

    private Product product;
    @Autowired
    ProductDao productDao;
    @BeforeAll
    public void createProduct(){
//        productDao.save(
//                Product.builder().title("cola").price(11).amount(11).build());
        productDao.save(
                Product.builder().title("Pivo").price(11).amount(10).build());
         product = productDao.save(
                Product.builder().title("Moloko").price(11).amount(9).build());
    }

    @Test
    public void jpaShouldSetIdWhenEntitySaved() {
        assertNotNull(product.getId());
    }
    @Test
    @Order(1)
    public void shouldFindEntityByNameCorrect() {
        productDao.save(
                Product.builder().title("Kvas").price(11).amount(9).build());
        Product product1 = productDao.getByTitle("Kvas");
        assertEquals("Kvas",product1.getTitle());
    }

    @Test
    public void repositoryShouldThrowExceptionWhenProductNotFoundByName() {
        assertThrows(NoResultException.class, () -> {
            productDao.getByTitle("absent-title");
        });
    }


    @Test
    @Order(2)
    public void getProductById(){
        Product product1 = productDao.getById(product.getId());
        assertEquals(product1,product);
    }

    @Test
    public void deleteProductById() {
        productDao.deleteById(product.getId());
        Product product1 = productDao.getById(product.getId());
        assertNull(product1);
    }
    @Test
    public void updateProduct(){
         Product updateProduct = productDao.save(
                Product.builder()
                        .title("Kvas")
                        .price(11)
                        .amount(10)
                        .build());
         product = productDao.update(updateProduct);

         assertEquals(product.getId(),updateProduct.getId());

    }

    @Test
    public void getProductLimit(){
        List<Product> productList = productDao.getProductLimit(10);
        assertEquals(0 ,productList.size());
    }

}


