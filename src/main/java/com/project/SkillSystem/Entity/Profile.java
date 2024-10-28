package com.project.SkillSystem.Entity;

import com.project.SkillSystem.Enum.Profile.*;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Profile {
    @Id
    String id;

    @Transient
    String fullName;

    String availableTime;

    String lastUpdate;

    String email;

    @Enumerated(EnumType.STRING)
    ProfileRole role;

    String dateOfBirth;

    @Enumerated(EnumType.STRING)
    UserGroup userGroup;

    String du;

    String phone;

    @Enumerated(EnumType.STRING)
    Gender gender;

    @Enumerated(EnumType.STRING)
    Nationality nationality;

    @Enumerated(EnumType.STRING)
    MaritalStatus maritalStatus;

    String objectives;

    String professionalText;

    String personalInterests;

    @Enumerated(EnumType.STRING)
    ProfileStatus status;

    String ldap;

    List<Education> education;

    List<Certificate> certificate;

    List<WorkExperience> workExperience;

    List<Skill> skill;

    List<Language> language;

    List<Project> project;

}
