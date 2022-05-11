package com.senla.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "product_amount")
public class ProductAmount {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "productAmount-id-sequence")
    @SequenceGenerator(name = "productAmount-id-sequence", sequenceName = "productAmount_seq", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "orders_id")
    private Orders orders;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "product_amount")
    private Integer amount;



}
