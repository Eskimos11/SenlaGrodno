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
@Table(name = "providers")
@Builder
public class Provider  {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "provider-id-sequence")
    @SequenceGenerator(name = "provider-id-sequence", sequenceName = "provider_seq", allocationSize = 1)
    private Integer id;
    @Column(name = "title")
    private String title;

    @Override
    public String toString() {
        return "Provider{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
