package com.project.SkillSystem.Dto.Response;

import com.project.SkillSystem.Entity.*;
import com.project.SkillSystem.Enum.Profile.*;
import jakarta.persistence.Transient;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Map;

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

    Map<String, List<CertificateResponse>> certificateList;

    Map<String, List<SkillResponse>> skillList;

    List<WorkExperience> workExperience;

    List<Language> language;

    List<Project> project;

}
