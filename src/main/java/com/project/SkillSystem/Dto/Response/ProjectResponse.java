package com.project.SkillSystem.Dto.Response;

import com.project.SkillSystem.Enum.Profile.ProfileRole;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProjectResponse {
    Long id;

    String title;

    Date startDate;

    Date endDate;

    String client;

    String description;

    Long teamSize;

    ProfileRole role;

    Long skillId;
}
