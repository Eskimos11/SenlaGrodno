package com.senla.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "discount_cards")
public class DiscountCard {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "discountCard-id-sequence")
    @SequenceGenerator(name = "discountCard-id-sequence", sequenceName = "discountCard_seq", allocationSize = 1)
    private Integer id;
    @Column(name = "number")
    private String number;


    @Override
    public String toString() {
        return "DiscountCard{" +
                "id=" + id +
                ", number='" + number + '\'' +
                '}';
    }
}
