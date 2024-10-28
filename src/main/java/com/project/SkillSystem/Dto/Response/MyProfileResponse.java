package com.project.SkillSystem.Dto.Response;

import com.project.SkillSystem.Entity.*;
import com.project.SkillSystem.Enum.Profile.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MyProfileResponse {
    String id;

    String fullName;

    String availableTime;

    String lastUpdate;

    String email;

    ProfileRole role;

    String dateOfBirth;

    UserGroup userGroup;

    String du;

    String phone;

    Gender gender;

    Nationality nationality;

    MaritalStatus maritalStatus;

    String objectives;

    String professionalText;

    String personalInterests;

    ProfileStatus status;

    List<Education> education;

    List<Certificate> certificate;

    List<WorkExperience> workExperience;

    List<Skill> skill;

    List<Language> language;

    List<Project> project;

}
