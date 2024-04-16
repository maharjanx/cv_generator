package com.infodev.cvgenerator.user.entity;

import lombok.*;


import jakarta.persistence.*;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "fl_districts")
public class District{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fl_district_seq_gen")
    @SequenceGenerator(name ="fl_district_seq_gen", sequenceName = "seq_fl_district", allocationSize = 1)
    private Short id;

    @Column(name = "name", unique = true, length = 100)
    private String name;

    @Column(name = "name_nepali", unique = true, length = 100)
    private String nameNepali;

    @Column(name = "code", unique = true, length = 10)
    private String code;

    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Province.class)
    @JoinColumn(name = "province_id",foreignKey = @ForeignKey(name = "fk_province_district"))
    private Province province;


}
