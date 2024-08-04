package com.csince90.wowkeviaggio.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Nome", nullable = false,unique = true)
    private String nome;

     @Column(name = "Email", nullable = false,unique = true)
    private String email;

    @Column(name = "Indirizzo", nullable = false)
    private String indirizzo;

    @Column(name = "Nazionalita", nullable = false)
    private String nazionalita;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "role")
    private String role = "USER";

    @PrePersist
    protected void onCreate() {
        if (this.role == null) {
            this.role = "ROLE_USER";
    
        }
    }
}
