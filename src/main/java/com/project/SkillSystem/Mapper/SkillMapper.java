package com.project.SkillSystem.Mapper;

import com.project.SkillSystem.Dto.Request.SkillRequest;
import com.project.SkillSystem.Dto.Response.SkillResponse;
import com.project.SkillSystem.Entity.Skill;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface SkillMapper {
    Skill toSkill(SkillRequest skillRequest);

    SkillResponse toSkillResponse(Skill skill);

    void updateSkill(@MappingTarget Skill skill, SkillRequest skillRequest);
}
