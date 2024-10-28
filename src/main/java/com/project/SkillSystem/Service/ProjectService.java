package com.project.SkillSystem.Service;

import com.project.SkillSystem.Dto.Request.ProjectRequest;
import com.project.SkillSystem.Dto.Response.ProjectResponse;
import com.project.SkillSystem.Entity.Project;
import com.project.SkillSystem.Mapper.ProjectMapper;
import com.project.SkillSystem.Repository.ProjectRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProjectService {
    ProjectRepository projectRepository;
    ProjectMapper projectMapper;

    public ProjectResponse createProject(ProjectRequest projectRequest) {
        Project project = projectMapper.toProject(projectRequest);

        return projectMapper.toProjectResponse(projectRepository.save(project));
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
}
