package com.project.SkillSystem.Mapper;

import com.project.SkillSystem.Dto.Request.EducationRequest;
import com.project.SkillSystem.Dto.Response.EducationResponse;
import com.project.SkillSystem.Entity.Education;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface EducationMapper {
    Education toEducation(EducationRequest educationRequest);

    EducationResponse toEducationResponse(Education education);

    void updateEducation(@MappingTarget Education education, EducationRequest educationRequest);
}
