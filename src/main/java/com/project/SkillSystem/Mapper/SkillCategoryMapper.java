package com.project.SkillSystem.Mapper;

import com.project.SkillSystem.Dto.Request.SkillCategoryRequest;
import com.project.SkillSystem.Dto.Response.SkillCategoryResponse;
import com.project.SkillSystem.Entity.SkillCategory;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface SkillCategoryMapper {
    SkillCategory toSkillCategory(SkillCategoryRequest skillCategoryRequest);

    SkillCategoryResponse toSkillCategoryResponse(SkillCategory skillCategory);

    void updateSkillCategory(@MappingTarget SkillCategory skillCategory, SkillCategoryRequest skillCategoryRequest);
}
