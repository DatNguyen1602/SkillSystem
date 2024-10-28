package com.project.SkillSystem.Controller;

import com.project.SkillSystem.Dto.Request.EducationRequest;
import com.project.SkillSystem.Dto.Response.ApiResponse;
import com.project.SkillSystem.Dto.Response.EducationResponse;
import com.project.SkillSystem.Service.EducationService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/s")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EducationController {
    EducationService educationService;

    @PostMapping("/add")
    ApiResponse<EducationResponse> createEducation(@RequestBody @Valid EducationRequest educationRequest) {
        return ApiResponse.<EducationResponse>builder()
                .result(educationService.createEducation(educationRequest))
                .build();
    }

    @PutMapping("/update/{id}")
    ApiResponse<EducationResponse> updateEducation(@PathVariable Long id, EducationRequest educationRequest) {
        return ApiResponse.<EducationResponse>builder()
                .result(educationService.updateEducation(id, educationRequest))
                .build();
    }

    @DeleteMapping("/delete/{id}")
    ApiResponse<String> delete(@PathVariable Long id) {
        educationService.deleteEducation(id);
        return ApiResponse.<String>builder()
                .result("Education has been deleted")
                .build();
    }




}
