package com.senla.api.dao;

import com.senla.entity.Provider;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ProviderDao extends GenericDao<Provider, Integer> {
    Provider update(Provider user);

    void deleteById(Integer id);


}
