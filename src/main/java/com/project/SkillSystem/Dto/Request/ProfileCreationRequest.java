package com.project.SkillSystem.Dto.Request;

import com.project.SkillSystem.Enum.Profile.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProfileCreationRequest {
    UserGroup userGroup;

    String du;

    String ldap;
}
