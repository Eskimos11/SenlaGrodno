package com.senla.repository;

import com.senla.BaseRepositoryTest;
import com.senla.api.dao.ProductDao;
import com.senla.dao.ProductDaoImpl;
import com.senla.dao.ProviderDaoImpl;
import com.senla.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = ProductDaoImpl.class)
public class ProductDaoTest extends BaseRepositoryTest {
//    @Autowired
//    private ProductDao productDao;
//    @Test
//    public void shouldFindEntityByNameCorrect() {
//        final String title = "MOLOKO";
//        final Product product = productDao.save(
//                Product.builder()
//                        .title(title)
//                        .build()
//        );
//        final Product potentialProduct = productDao.getByTitle(title);
//
//        assertEquals(product.getId(), potentialProduct.getId());
//    }
}
