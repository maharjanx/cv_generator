package com.infodev.cvgenerator.user.entity;

import com.infodev.cvgenerator.user.ENUM.DegreeName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "education_informations")
public class EducationInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "education_information_seq_gen")
    @SequenceGenerator(name = "education_information_seq_gen", sequenceName = "seq_education_information")
    private short id;

    @Column(name = "institution_name", length = 200, nullable = false)
    private String institutionName;

    @Column(name = "institution_address", length = 200, nullable = false)
    private String institutionAddress;

    @Column(name = "institution_contact", length = 10, nullable = false)
    private String institutionContact;

    @Column(name = "from_date", nullable = false)
    private Date fromDate;

    @Column(name = "to_date")
    private Date toDate;

    @Column(name ="to_present")
    private boolean toPresent;

    @Enumerated(EnumType.STRING)
    private DegreeName degreeName;

    @Column(name="education_description", length = 100, nullable = false)
    private String educationDescription;

    @ManyToOne(fetch = FetchType.LAZY,targetEntity = BasicInformation.class)
    @JoinColumn(name = "basic_information_id",foreignKey = @ForeignKey(name = "fk_education_information_basic_information"))
    private BasicInformation basicInformation;

}
