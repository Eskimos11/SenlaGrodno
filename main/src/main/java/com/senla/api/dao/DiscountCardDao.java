package com.senla.api.dao;

import com.senla.entity.DiscountCard;


import javax.transaction.Transactional;


public interface DiscountCardDao extends GenericDao<DiscountCard, Long> {

    DiscountCard update(DiscountCard discountCard);

    void deleteById(Long id);

    DiscountCard getByNumber(String number);

}
