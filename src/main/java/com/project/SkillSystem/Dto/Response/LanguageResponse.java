package com.project.SkillSystem.Dto.Response;

import com.project.SkillSystem.Enum.LanguageLevel;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LanguageResponse {
    Long id;

    String name;

    LanguageLevel level;

    String note;

}
