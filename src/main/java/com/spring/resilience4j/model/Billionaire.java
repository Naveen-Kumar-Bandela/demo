package com.spring.resilience4j.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Entity
@Table(name = "billionaires")
@Setter
@Getter
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Billionaire implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "net_worth", nullable = false)
    private Long netWorth;

    @Column(name = "source_of_wealth", nullable = false)
    private String sourceOfWealth;

    @Column(name = "country", nullable = false)
    private String country;

    // Getters, setters, and other methods
}
