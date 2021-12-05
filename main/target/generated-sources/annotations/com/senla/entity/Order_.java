package com.senla.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Order.class)
public abstract class Order_ {

	public static volatile SingularAttribute<Order, DiscountCard> discountCard;
	public static volatile SingularAttribute<Order, Integer> id;
	public static volatile ListAttribute<Order, Product> productList;
	public static volatile SingularAttribute<Order, Customer> customer;

}

