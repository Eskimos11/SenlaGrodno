package com.senla.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "product-id-sequence")
    @SequenceGenerator(name = "product-id-sequence", sequenceName = "product_seq", allocationSize = 1)
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "price")
    private Integer price;
    @Column(name = "number")
    private Integer number;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + getId() +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
