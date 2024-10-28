package com.project.SkillSystem.Dto.Request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WorkExperienceRequest {
    String companyName;

    String position;

    Date startDate;

    Date endDate;

    String description;

    String profileId;

}
