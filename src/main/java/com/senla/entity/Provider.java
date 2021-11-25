package com.senla.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "providers")
@Builder
public class Provider extends AEntity {

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
