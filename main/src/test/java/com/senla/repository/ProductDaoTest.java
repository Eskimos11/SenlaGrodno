package com.senla.repository;

import com.senla.BaseRepositoryTest;
import com.senla.api.dao.ProductDao;
import com.senla.api.dao.UserDao;
import com.senla.dao.ProductDaoImpl;
import com.senla.entity.Product;
import com.senla.entity.Role;
import com.senla.entity.User;
import liquibase.pro.packaged.P;
import org.hibernate.LazyInitializationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import javax.persistence.NoResultException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = ProductDaoImpl.class)
public class ProductDaoTest extends BaseRepositoryTest {
//    @Autowired
//    private ProductDao productDao;
//
//    @Test
//    public void jpaShouldSetIdWhenEntitySaved() {
//        final Product product =
//                productDao.save(
//                        Product.builder()
//                                .title("Cola")
//                                .build()
//                );
//
//        assertNotNull(product.getId());
//    }
//
//    @Test
//    public void repositoryShouldThrowExceptionWhenUserNotFoundByName() {
//        assertThrows(NoResultException.class, () -> {
//            productDao.getByTitle("absent-title");
//        });
//    }
////
//    @Test
//    public void shouldFindEntityByNameCorrect() {
//        final String cola = "cola";
//        final Product product = productDao.save(
//                Product.builder()
//                        .title(cola)
//                        .build()
//        );
//        final Product potentialCola = productDao.getByTitle(cola);
//
//        assertEquals(product.getId(), potentialCola.getId());
//    }
//
//
//
//    @Test
//    public void shouldReturnAllProducts() {
//        final String cola = "cola";
//        productDao.save(
//                Product.builder()
//                        .title(cola)
//                        .build()
//        );
//
//        final List<Product> all = productDao.getAll();
//
//        assertEquals(1, all.size());
//        final Product product = all.get(0);
//        assertEquals("cola", product.getTitle());
//        assertNotNull(product.getId());
//    }
}
