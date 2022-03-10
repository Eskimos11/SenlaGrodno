package com.senla.entity;

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
    @SequenceGenerator(name = "order-id-sequence", sequenceName = "orders_seq", allocationSize = 1)
    private Integer id;
    @ManyToMany(fetch= FetchType.LAZY, cascade= {CascadeType.PERSIST,CascadeType.MERGE
                                                 ,CascadeType.REFRESH,CascadeType.DETACH})
    @JoinTable(name = "orders_products",
            joinColumns = @JoinColumn(name = "orders_id"),
            inverseJoinColumns = @JoinColumn(name = "products_id"))
    private List<Product> productList;
    @Column(name = "sum")
    private Integer sum;
//    @ManyToOne(fetch = FetchType.LAZY, cascade= {CascadeType.PERSIST})
//    @JoinColumn(name = "role_id")
//    private ProductAmount productAmount;
    @Column(name = "user_id")
    private Integer userId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "discount_card_id")
    private DiscountCard discountCard;

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", sum=" + sum +
                '}';
    }

}
