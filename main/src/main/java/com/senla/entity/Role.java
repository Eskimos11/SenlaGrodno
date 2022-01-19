package com.senla.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Table(name = "role")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedEntityGraph(
        name = "with-users",
        attributeNodes = @NamedAttributeNode("users")
)
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role-id-seq")
    @SequenceGenerator(name = "role-id-seq", sequenceName = "role_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}