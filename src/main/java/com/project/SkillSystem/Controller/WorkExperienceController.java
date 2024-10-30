package com.project.SkillSystem.Controller;

import com.project.SkillSystem.Dto.Request.WorkExperienceRequest;
import com.project.SkillSystem.Dto.Response.ApiResponse;
import com.project.SkillSystem.Dto.Response.WorkExperienceResponse;
import com.project.SkillSystem.Service.WorkExperienceService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/workExperiences")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class WorkExperienceController {
    WorkExperienceService workExperienceService;

    @PostMapping("/add")
    ApiResponse<WorkExperienceResponse> createWorkExperience(@RequestBody @Valid WorkExperienceRequest workExperienceRequest) {
        return ApiResponse.<WorkExperienceResponse>builder()
                .result(workExperienceService.createWorkExperience(workExperienceRequest))
                .build();
    }

    @PutMapping("/update/{id}")
    ApiResponse<WorkExperienceResponse> updateWorkExperience(@PathVariable Long id, WorkExperienceRequest workExperienceRequest) {
        return ApiResponse.<WorkExperienceResponse>builder()
                .result(workExperienceService.updateWorkExperience(id, workExperienceRequest))
                .build();
    }

    @DeleteMapping("/delete/{id}")
    ApiResponse<String> delete(@PathVariable Long id) {
        workExperienceService.deleteWorkExperience(id);
        return ApiResponse.<String>builder()
                .result(" has been deleted")
                .build();
    }




}
