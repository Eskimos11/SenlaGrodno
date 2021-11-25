package com.senla.api.dao;

import com.senla.entity.Provider;

import javax.transaction.Transactional;

@Transactional
public interface ProviderDao extends GenericDao<Provider> {

    Provider getById(Integer id);
}
