package com.project.SkillSystem.Mapper;

import com.project.SkillSystem.Dto.Request.WorkExperienceRequest;
import com.project.SkillSystem.Dto.Response.WorkExperienceResponse;
import com.project.SkillSystem.Entity.WorkExperience;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface WorkExperienceMapper {
    WorkExperience toWorkExperience(WorkExperienceRequest workExperienceRequest);

    WorkExperienceResponse toWorkExperienceResponse(WorkExperience workExperience);

    void updateWorkExperience(@MappingTarget WorkExperience workExperience, WorkExperienceRequest workExperienceRequest);
}
