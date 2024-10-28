package com.project.SkillSystem.Mapper;

import com.project.SkillSystem.Dto.Request.UserCreationRequest;
import com.project.SkillSystem.Dto.Request.UserUpdateRequest;
import com.project.SkillSystem.Dto.Response.UserResponse;
import com.project.SkillSystem.Entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest userCreationRequest);

    UserResponse toUserResponse(User user);

    void updateUser(@MappingTarget User user, UserUpdateRequest userUpdateRequest);
}
