package com.project.SkillSystem.Dto.Request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EducationRequest {
    String major;

    String school;

    Date startDate;

    Date endDate;

    String status;

    String grade;

    String qualification;

    String achievement;

    String profileId;
}
