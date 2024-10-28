package com.project.SkillSystem.Dto.Request;

import com.project.SkillSystem.Enum.User.Role;
import com.project.SkillSystem.Enum.User.UserStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserUpdateRequest {
    String password;

    Role role;

    UserStatus status;
}
