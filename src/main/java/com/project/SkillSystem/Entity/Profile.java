package com.project.SkillSystem.Entity;

import com.project.SkillSystem.Dto.Response.CertificateResponse;
import com.project.SkillSystem.Dto.Response.SkillResponse;
import com.project.SkillSystem.Enum.Profile.*;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Map;

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

    @Transient
    List<Education> education;

    @Transient
    List<Certificate> certificate;

    @Transient
    Map<String, List<CertificateResponse>> certificateList;

    @Transient
    List<WorkExperience> workExperience;

    @Transient
    List<Skill> skill;

    @Transient
    Map<String, List<SkillResponse>> skillList;

    @Transient
    List<Language> language;

    @Transient
    List<Project> project;

}
