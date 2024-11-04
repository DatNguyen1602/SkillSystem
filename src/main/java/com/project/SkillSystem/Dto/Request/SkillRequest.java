package com.project.SkillSystem.Dto.Request;

import com.project.SkillSystem.Enum.SkillLevel;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SkillRequest {
    Long skillNameId;

    SkillLevel level;

    Long yearsOfExperience;

    Date lastUsed;

    String profileId;
}
