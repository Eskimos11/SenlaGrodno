package com.senla.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Customer.class)
public abstract class Customer_ {

	public static volatile SingularAttribute<Customer, String> name;
	public static volatile SingularAttribute<Customer, DiscountCard> discountCard;
	public static volatile SingularAttribute<Customer, Integer> id;

}

