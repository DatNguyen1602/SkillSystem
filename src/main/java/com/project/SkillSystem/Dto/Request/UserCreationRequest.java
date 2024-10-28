package com.project.SkillSystem.Dto.Request;

import com.project.SkillSystem.Enum.User.Role;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationRequest {
    String firstName;

    String lastName;

    String password;

    Role role;
}
