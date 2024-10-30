package com.project.SkillSystem.Controller;

import com.project.SkillSystem.Dto.Request.SkillRequest;
import com.project.SkillSystem.Dto.Response.ApiResponse;
import com.project.SkillSystem.Dto.Response.SkillResponse;
import com.project.SkillSystem.Service.SkillService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/skills")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SkillController {
    SkillService skillService;

    @PostMapping("/add")
    ApiResponse<SkillResponse> createSkill(@RequestBody @Valid SkillRequest skillRequest) {
        return ApiResponse.<SkillResponse>builder()
                .result(skillService.createSkill(skillRequest))
                .build();
    }

    @PutMapping("/update/{id}")
    ApiResponse<SkillResponse> updateSkill(@PathVariable Long id, SkillRequest skillRequest) {
        return ApiResponse.<SkillResponse>builder()
                .result(skillService.updateSkill(id, skillRequest))
                .build();
    }

    @DeleteMapping("/delete/{id}")
    ApiResponse<String> deleteSkill(@PathVariable Long id) {
        skillService.deleteSkill(id);
        return ApiResponse.<String>builder()
                .result(" has been deleted")
                .build();
    }




}
