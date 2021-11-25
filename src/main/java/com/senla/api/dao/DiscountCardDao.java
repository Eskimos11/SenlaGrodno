package com.senla.api.dao;

import com.senla.entity.DiscountCard;

import javax.transaction.Transactional;

@Transactional
public interface DiscountCardDao extends GenericDao<DiscountCard> {
}
