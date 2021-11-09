package com.senla.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Provider extends AEntity {

    private String title;

    @Override
    public String toString() {
        return "Provider{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
