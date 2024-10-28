package com.project.SkillSystem.Dto.Response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WorkExperienceResponse {
    Long id;

    String companyName;

    String position;

    Date startDate;

    Date endDate;

    String description;

}
