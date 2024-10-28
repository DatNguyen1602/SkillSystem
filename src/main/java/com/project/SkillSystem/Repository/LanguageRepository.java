package com.project.SkillSystem.Repository;

import com.project.SkillSystem.Entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LanguageRepository extends JpaRepository<Language, Long> {
    List<Language> findByProfileId(String profileId);
}
