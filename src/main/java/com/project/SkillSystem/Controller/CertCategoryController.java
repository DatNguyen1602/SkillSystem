package com.project.SkillSystem.Controller;

import com.project.SkillSystem.Dto.Request.CertCategoryRequest;
import com.project.SkillSystem.Dto.Response.ApiResponse;
import com.project.SkillSystem.Dto.Response.CertCategoryResponse;
import com.project.SkillSystem.Service.CertCategoryService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/certCategories")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CertCategoryController {
    CertCategoryService certCategoryService;

    @PostMapping("/add")
    ApiResponse<CertCategoryResponse> createCertCategory(@RequestBody @Valid CertCategoryRequest certCategoryRequest) {
        return ApiResponse.<CertCategoryResponse>builder()
                .result(certCategoryService.createCertCategory(certCategoryRequest))
                .build();
    }

    @DeleteMapping("/delete/{id}")
    ApiResponse<String> deleteCertCategory(@PathVariable Long id) {
        certCategoryService.deleteCertCategory(id);
        return ApiResponse.<String>builder()
                .result(" has been deleted")
                .build();
    }




}
