package com.infodev.cvgenerator.user.entity;

import com.infodev.cvgenerator.user.ENUM.ProjectStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "project_informations")
public class ProjectInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_information_seq_gen")
    @SequenceGenerator(name = "project_information_seq_gen", sequenceName = "seq_project_information")
    private Short id;

    @Column(name = "project_name", length = 100, nullable = false)
    private String projectName;

    @Column(name = "project_role", length = 50, nullable = false)
    private String projectRole;

    @Column(name = "project_description", nullable = false)
    private String projectDescription;

    @Column(name = "project_url", length = 200)
    private String projectUrl;

    @Enumerated(EnumType.STRING)
    @Column(name = "project_status")
    private ProjectStatus projectStatus;

    @ManyToOne(fetch = FetchType.LAZY,targetEntity = ExperienceInformation.class)
    @JoinColumn(name = "experience_information_id",foreignKey = @ForeignKey(name = "fk_experience_information_project_information"))
    private ExperienceInformation experienceInformation;


}
