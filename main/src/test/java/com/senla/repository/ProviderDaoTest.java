package com.senla.repository;


import com.senla.BaseRepositoryTest;
import com.senla.api.dao.ProviderDao;
import com.senla.dao.ProviderDaoImpl;
import com.senla.entity.Provider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;


import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = ProviderDaoImpl.class)
class ProviderDaoTest extends BaseRepositoryTest {

    @Autowired
    private ProviderDao providerDao;

    @Test
    public void jpaShouldSetIdWhenEntitySaved() {
        final Provider title =
                providerDao.save(
                Provider.builder()
                        .title("Cola")
                        .build()
        );
        assertNotNull(title.getId());
    }

}