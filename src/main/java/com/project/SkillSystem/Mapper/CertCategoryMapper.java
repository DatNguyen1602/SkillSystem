package com.project.SkillSystem.Mapper;

import com.project.SkillSystem.Dto.Request.CertCategoryRequest;
import com.project.SkillSystem.Dto.Response.CertCategoryResponse;
import com.project.SkillSystem.Entity.CertCategory;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CertCategoryMapper {
    CertCategory toCertCategory(CertCategoryRequest certCategoryRequest);

    CertCategoryResponse toCertCategoryResponse(CertCategory certCategory);

    void updateCertCategory(@MappingTarget CertCategory certCategory, CertCategoryRequest certCategoryRequest);
}
