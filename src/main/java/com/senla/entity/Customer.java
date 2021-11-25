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
@Table(name = "customers")
public class Customer extends AEntity {

    @Column(name = "name")
    private String name;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "discount_cards_id", referencedColumnName = "id")
    private DiscountCard discountCard;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", discountCard=" + discountCard +
                '}';
    }
}
