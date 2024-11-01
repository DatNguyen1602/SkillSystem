package com.project.SkillSystem.Controller;

import com.project.SkillSystem.Dto.Response.ApiResponse;
import com.project.SkillSystem.Dto.Response.SkillCategoryResponse;
import com.project.SkillSystem.Service.SkillCategoryService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/skillCategories")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SkillCategoryController {
    SkillCategoryService skillCategoryService;

    @PostMapping("/add")
    ApiResponse<SkillCategoryResponse> createSkillCategory(@RequestBody @Valid SkillCategoryRequest skillCategoryRequest) {
        return ApiResponse.<SkillCategoryResponse>builder()
                .result(skillCategoryService.createSkillCategory(skillCategoryRequest))
                .build();
    }

    @DeleteMapping("/delete/{id}")
    ApiResponse<String> deleteSkillCategory(@PathVariable Long id) {
        skillCategoryService.deleteSkillCategory(id);
        return ApiResponse.<String>builder()
                .result(" has been deleted")
                .build();
    }




}
