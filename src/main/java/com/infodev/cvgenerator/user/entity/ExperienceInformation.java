package com.infodev.cvgenerator.user.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "experience_informations")
public class ExperienceInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "experience_information_seq_gen")
    @SequenceGenerator(name = "experience_information_seq_gen", sequenceName = "seq_experience_information")
    private Short id;

    @Column(name = "company_name", length = 200, nullable = false)
    private String companyName;

    @Column(name = "company_address", length = 200, nullable = false)
    private String companyAddress;

    @Column(name = "company_contact", length = 50, nullable = false)
    private String companyContact;

    @Column(name = "from_date", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fromDate;

    @Column(name = "to_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date toDate;

    @Column(name ="to_present")
    private boolean toPresent;

    @ManyToOne(fetch = FetchType.LAZY,targetEntity = BasicInformation.class)
    @JoinColumn(name = "basic_information_id",foreignKey = @ForeignKey(name = "fk_experience_information_basic_information"))
    private BasicInformation basicInformation;

    @OneToMany(mappedBy = "experienceInformation", orphanRemoval = true )
    private Set<ProjectInformation> projectInformations;
}
