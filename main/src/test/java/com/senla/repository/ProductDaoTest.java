package com.senla.repository;

import com.senla.BaseRepositoryTest;
import com.senla.dao.ProductDaoImpl;
import org.springframework.test.context.ContextConfiguration;

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
