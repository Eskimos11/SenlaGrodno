package com.senla.entity;

import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;

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
    //В методе getProducts выдает NullPointerException (пока не иправил)
    @ManyToMany(fetch= FetchType.EAGER, cascade= {CascadeType.PERSIST,CascadeType.MERGE
                                                 ,CascadeType.REFRESH,CascadeType.DETACH,})
    @JoinTable(name = "orders_products",
            joinColumns = @JoinColumn(name = "orders_id"),
            inverseJoinColumns = @JoinColumn(name = "products_id"))
    private List<Product> productList;
    @Column(name = "sum")
    private Integer sum;

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", sum=" + sum +
                '}';
    }

}
