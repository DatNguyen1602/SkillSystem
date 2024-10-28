package com.project.SkillSystem.Dto.Response;

import com.project.SkillSystem.Enum.User.Role;
import com.project.SkillSystem.Enum.User.UserStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    String ldap;

    String firstName;

    String lastName;

    Role role;

    UserStatus status;
}
