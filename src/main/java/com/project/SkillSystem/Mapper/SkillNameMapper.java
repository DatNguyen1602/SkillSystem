package com.project.SkillSystem.Mapper;

import com.project.SkillSystem.Dto.Response.SkillNameResponse;
import com.project.SkillSystem.Entity.SkillName;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SkillNameMapper {
    SkillNameResponse toSkillNameResponse(SkillName skillName);
}
