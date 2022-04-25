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
    private Long id;
    @ManyToMany(fetch= FetchType.LAZY, cascade= {CascadeType.PERSIST,CascadeType.MERGE
                                                 ,CascadeType.REFRESH,CascadeType.DETACH})
    @JoinTable(name = "orders_products",
            joinColumns = @JoinColumn(name = "orders_id"),
            inverseJoinColumns = @JoinColumn(name = "products_id"))
    private List<Product> productList;
    @Column(name = "sum")
    private Integer sum;
    @Column(name = "user_id")
    private Long userId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "discount_card_id")
    private DiscountCard discountCard;
    @Column(name = "status_order")
    private boolean statusOrder;

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", sum=" + sum +
                '}';
    }

}
