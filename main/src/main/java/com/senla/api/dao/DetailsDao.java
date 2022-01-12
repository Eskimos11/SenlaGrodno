package com.senla.api.dao;

import com.senla.entity.Details;

import javax.transaction.Transactional;

@Transactional
public interface DetailsDao extends GenericDao<Details, Integer> {
}
