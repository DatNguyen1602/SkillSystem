package com.project.SkillSystem.Repository;

import com.project.SkillSystem.Entity.SkillCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SkillCategoryRepository extends JpaRepository<SkillCategory, Long> {
    Optional<SkillCategory> findById(Long id);
}
