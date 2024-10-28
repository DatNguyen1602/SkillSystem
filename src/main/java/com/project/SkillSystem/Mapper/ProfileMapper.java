package com.project.SkillSystem.Mapper;

import com.project.SkillSystem.Dto.Request.ProfileCreationRequest;
import com.project.SkillSystem.Dto.Request.ProfileUpdaterequest;
import com.project.SkillSystem.Dto.Response.MyProfileResponse;
import com.project.SkillSystem.Dto.Response.ProfileResponse;
import com.project.SkillSystem.Entity.Profile;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProfileMapper {
    Profile toProfile(ProfileCreationRequest profileCreationRequest);

    ProfileResponse toProfileResponse(Profile profile);

    void updateProfile(@MappingTarget Profile profile, ProfileUpdaterequest profileUpdaterequest);

    MyProfileResponse toMyProfileResponse(Profile profile);


}
