package com.senla.api.dao;

import com.senla.entity.Provider;

public interface ProviderDao extends GenericDao<Provider> {

    Provider getById(Integer id);
}
