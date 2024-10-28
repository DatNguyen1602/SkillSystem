package com.project.SkillSystem.Mapper;

import com.project.SkillSystem.Dto.Request.ProjectRequest;
import com.project.SkillSystem.Dto.Response.ProjectResponse;
import com.project.SkillSystem.Entity.Project;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    Project toProject(ProjectRequest projectRequest);

    ProjectResponse toProjectResponse(Project project);

    void updateProject(@MappingTarget Project project, ProjectRequest projectRequest);

}
