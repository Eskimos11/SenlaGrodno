package com.senla.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "discount_cards")
public class DiscountCard {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "discountCard-id-sequence")
    @SequenceGenerator(name = "discountCard-id-sequence", sequenceName = "discountCard_seq", allocationSize = 1)
    private Long id;
    @Column(name = "number")
    private String number;
    @Column(name = "balance")
    private Integer balance;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @OneToOne(cascade= {CascadeType.PERSIST,CascadeType.MERGE
            ,CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "details_id")
    private Details details;

    @Override
    public String toString() {
        return "DiscountCard{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", balance=" + balance +
                ", status=" + status +
                '}';
    }
}
