package com.senla.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "details")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Details {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "details-id-sequence")
    @SequenceGenerator(name = "details-id-sequence", sequenceName = "details_seq", allocationSize = 1)
    private Integer id;
    @Column(name = "name", unique = true)
    private String name;
    @Column(name = "lastName", unique = true)
    private String lastName;
    @Column(name = "city", unique = true)
    private String city;
    @Column(name = "phone_number", unique = true)
    private String phoneNumber;


}
