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
@Table(name = "fl_province", uniqueConstraints = @UniqueConstraint(columnNames = {"id"}))
public class Province{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Short id;

    @Column(name = "name", unique = true, length = 100)
    private String name;

    @Column(name = "name_nepali", unique = true, length = 100)
    private String nameNepali;

    @Column(name = "code", unique = true, length = 10)
    private String code;

    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Country.class)
    @JoinColumn(name = "country_id",foreignKey = @ForeignKey(name = "fk_country_province"))
    private Country country;


}
