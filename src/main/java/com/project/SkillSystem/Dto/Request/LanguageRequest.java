package com.project.SkillSystem.Dto.Request;

import com.project.SkillSystem.Enum.LanguageLevel;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LanguageRequest {
    String name;

    LanguageLevel level;

    String note;

    String profileId;
}
