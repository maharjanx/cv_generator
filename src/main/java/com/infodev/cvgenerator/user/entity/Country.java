package com.infodev.cvgenerator.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "fl_countries", uniqueConstraints = @UniqueConstraint(columnNames = {"id"}))
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fl_country_seq_gen")
    @SequenceGenerator(name = "fl_country_seq_gen", sequenceName = "seq_fl_country", allocationSize = 1)
    private Short id;

    @Column(name = "name", unique = true, length = 100)
    private String name;

    @Column(name = "code", unique = true, length = 10)
    private String code;

    @Column(name="country_alias", unique = true, length = 10)
    private String countryAlias;


}
