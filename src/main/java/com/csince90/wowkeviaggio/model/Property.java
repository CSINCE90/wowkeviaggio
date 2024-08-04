package com.csince90.wowkeviaggio.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "Property")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Nome", nullable = false)
    private String nome;
    @Column(name = "Location", nullable = false)
    private String location;
    @Column(name = "Prezzo", nullable = false)
    private BigDecimal prezzo;

    @Enumerated(EnumType.STRING)
    @Column(name = "Piattaforma", nullable = false)
    private PiattaformaEnum piattaforma;
}

