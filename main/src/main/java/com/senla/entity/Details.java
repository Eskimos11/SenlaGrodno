package com.senla.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "details")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Details {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "details-id-sequence")
    @SequenceGenerator(name = "details-id-sequence", sequenceName = "details_seq", allocationSize = 1)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name", unique = true)
    private String lastName;
    @Column(name = "city", unique = true)
    private String city;
    @Column(name = "phone_number", unique = true)
    private String phoneNumber;


    @Override
    public String toString() {
        return "Details{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", city='" + city + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
