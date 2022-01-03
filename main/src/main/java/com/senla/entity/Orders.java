package com.senla.entity;

import jdk.jfr.MemoryAddress;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "order-id-sequence")
    @SequenceGenerator(name = "order-id-sequence", sequenceName = "order_seq", allocationSize = 1)
    private Integer id;
    @ManyToMany(fetch= FetchType.EAGER, cascade= CascadeType.ALL)
    @JoinColumn(name = "products_id")
    private List<Product> productList;
    @Column(name = "sum")
    private Integer sum;
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "customers_discount_cards_id")
//    private DiscountCard discountCard;


}
