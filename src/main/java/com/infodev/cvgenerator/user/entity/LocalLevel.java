package com.infodev.cvgenerator.user.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import jakarta.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "fl_localevels")
public class LocalLevel{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fl_locallevel_seq_gen")
    @SequenceGenerator(name = "fl_locallevel_seq_gen", sequenceName = "seq_fl_locallevel", allocationSize = 1)
    private Short id;

    @Column(name = "name", unique = true, length = 100)
    private String name;

    @Column(name = "name_nepali", unique = true, length = 100)
    private String nameNepali;

    @Column(name = "total_ward_count")
    private int totalWardCount;

    @Column(name = "code", unique = true, length = 10)
    private String code;

    @ManyToOne(fetch = FetchType.LAZY,targetEntity = District.class)
    @JoinColumn(name = "district_id",foreignKey = @ForeignKey(name = "fk_district_locallevel"))
    private District district;
}
