package com.project.SkillSystem.Service;

import com.project.SkillSystem.Dto.Request.LanguageRequest;
import com.project.SkillSystem.Dto.Response.LanguageResponse;
import com.project.SkillSystem.Entity.Language;
import com.project.SkillSystem.Mapper.LanguageMapper;
import com.project.SkillSystem.Repository.LanguageRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LanguageService {
    LanguageRepository languageRepository;
    LanguageMapper languageMapper;

    public LanguageResponse createLanguage(LanguageRequest languageRequest) {
        Language language = languageMapper.toLanguage(languageRequest);

        return languageMapper.toLanguageResponse(languageRepository.save(language));
    }

    public void deleteLanguage(Long id) {
        languageRepository.deleteById(id);
    }
}
