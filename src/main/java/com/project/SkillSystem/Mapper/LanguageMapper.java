package com.project.SkillSystem.Mapper;

import com.project.SkillSystem.Dto.Request.LanguageRequest;
import com.project.SkillSystem.Dto.Response.LanguageResponse;
import com.project.SkillSystem.Entity.Language;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface LanguageMapper {
    Language toLanguage(LanguageRequest languageRequest);

    LanguageResponse toLanguageResponse(Language language);

    void updateLanguage(@MappingTarget Language language, LanguageRequest languageRequest);
}
