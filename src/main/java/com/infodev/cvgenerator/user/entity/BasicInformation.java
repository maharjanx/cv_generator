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
@Table(name = "basic_informations")
public class BasicInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "basic_information_seq_gen")
    @SequenceGenerator(name = "basic_information_seq_gen", sequenceName = "seq_basic_information", allocationSize = 1)
    private Short id;

    @Column(length = 50, nullable = false, name = "first_name")
    private String firstName;

    @Column(length = 50, name = "middle_name")
    private String middleName;

    @Column(length = 50, nullable = false, name = "last_name")
    private String lastName;

    @Column(nullable = false, name = "background")
    private String background;

    @Column(length = 100, nullable = false, name = "title")
    private String title;

    @Column(length = 10, nullable = false, name = "mobile_number")
    private String mobileNumber;

    @Column(length = 100, nullable = false, name = "email", unique = true)
    private String email;

    @Column(length = 200, nullable = false, name = "linked_in_url")
    private String linkedInUrl;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "file_information_id")
    private FileInformation fileInformation;


}
