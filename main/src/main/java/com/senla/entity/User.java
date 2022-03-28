package com.senla.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;


@Entity
@Table(name = "users")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user-id-sequence")
    @SequenceGenerator(name = "user-id-sequence", sequenceName = "users_seq", allocationSize = 1)
    private Long id;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password", unique = true)
    private String password;

    @ManyToOne(fetch = FetchType.LAZY, cascade= {CascadeType.PERSIST})
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToOne(cascade= {CascadeType.PERSIST,CascadeType.MERGE
            ,CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "details_id")
    private Details details;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", details=" + details +
                '}';
    }
}
