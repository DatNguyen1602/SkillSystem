package com.project.SkillSystem.Controller;

import com.project.SkillSystem.Dto.Request.ProjectRequest;
import com.project.SkillSystem.Dto.Response.ApiResponse;
import com.project.SkillSystem.Dto.Response.ProjectResponse;
import com.project.SkillSystem.Service.ProjectService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProjectController {
    ProjectService projectService;

    @PostMapping("/add")
    ApiResponse<ProjectResponse> createProject(@RequestBody @Valid ProjectRequest projectRequest) {
        return ApiResponse.<ProjectResponse>builder()
                .result(projectService.createProject(projectRequest))
                .build();
    }

    @PutMapping("/update/{id}")
    ApiResponse<ProjectResponse> updateProject(@PathVariable Long id, ProjectRequest projectRequest) {
        return ApiResponse.<ProjectResponse>builder()
                .result(projectService.updateProject(id, projectRequest))
                .build();
    }

    @DeleteMapping("/delete/{id}")
    ApiResponse<String> deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        return ApiResponse.<String>builder()
                .result(" has been deleted")
                .build();
    }




}
