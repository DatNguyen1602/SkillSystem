package com.project.SkillSystem.Dto.Response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EducationResponse {
    Long id;

    String major;

    String school;

    Date startDate;

    Date endDate;

    String status;

    String grade;

    String qualification;

    String achievement;
}
