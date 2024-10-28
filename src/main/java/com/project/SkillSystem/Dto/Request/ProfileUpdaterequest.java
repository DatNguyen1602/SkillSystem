package com.project.SkillSystem.Dto.Request;

import com.project.SkillSystem.Enum.Profile.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProfileUpdaterequest {
    ProfileRole role;

    String dateOfBirth;

    String phone;

    Gender gender;

    Nationality nationality;

    MaritalStatus maritalStatus;

    String objectives;

    String professionalText;

    String personalInterests;

    ProfileStatus status;
}
