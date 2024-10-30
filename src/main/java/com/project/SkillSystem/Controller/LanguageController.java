package com.project.SkillSystem.Controller;

import com.project.SkillSystem.Dto.Request.LanguageRequest;
import com.project.SkillSystem.Dto.Response.ApiResponse;
import com.project.SkillSystem.Dto.Response.LanguageResponse;
import com.project.SkillSystem.Service.LanguageService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/languages")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LanguageController {
    LanguageService languageService;

    @PostMapping("/add")
    ApiResponse<LanguageResponse> createLanguage(@RequestBody @Valid LanguageRequest languageRequest) {
        return ApiResponse.<LanguageResponse>builder()
                .result(languageService.createLanguage(languageRequest))
                .build();
    }

    @PutMapping("/update/{id}")
    ApiResponse<LanguageResponse> updateLanguage(@PathVariable Long id, LanguageRequest languageRequest) {
        return ApiResponse.<LanguageResponse>builder()
                .result(languageService.updateLanguage(id, languageRequest))
                .build();
    }

    @DeleteMapping("/delete/{id}")
    ApiResponse<String> deleteLanguage(@PathVariable Long id) {
        languageService.deleteLanguage(id);
        return ApiResponse.<String>builder()
                .result(" has been deleted")
                .build();
    }




}
