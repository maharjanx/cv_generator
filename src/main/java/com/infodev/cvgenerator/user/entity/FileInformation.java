package com.infodev.cvgenerator.user.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "file_information")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FileInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "file_information_seq_gen")
    @SequenceGenerator(name = "file_information_seq_gen", sequenceName = "seq_file_information")
    private Short id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "file_path")
    private String filePath;
}
