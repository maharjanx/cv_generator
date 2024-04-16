package com.infodev.cvgenerator.user.entity;

import com.infodev.cvgenerator.user.ENUM.AddressType;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "address_informations")
public class AddressInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_information_seq_gen")
    @SequenceGenerator(name = "address_information_seq_gen", sequenceName = "seq_address_information", allocationSize = 1)
    private Short id;

    @Enumerated(EnumType.STRING)
    @Column(name = "address_type")
    private AddressType addressType;

    @ManyToOne(fetch = FetchType.LAZY,targetEntity = BasicInformation.class)
    @JoinColumn(name = "basic_information_id",foreignKey = @ForeignKey(name = "fk_basic_information_address_information"))
    private BasicInformation basicInformation;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Province.class)
    @JoinColumn(name = "province_id", foreignKey = @ForeignKey(name = "fk_province_address_information"))
    private Province province;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Country.class)
    @JoinColumn(name = "country_id", foreignKey = @ForeignKey(name = "fk_country_address_information"))
    private Country country;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = District.class)
    @JoinColumn(name = "district_id", foreignKey = @ForeignKey(name = "fk_district_address_information"))
    private District district;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = LocalLevel.class)
    @JoinColumn(name = "locallevel_id", foreignKey = @ForeignKey(name = "fk_locallevel_address_information"))
    private LocalLevel localLevel;



}
