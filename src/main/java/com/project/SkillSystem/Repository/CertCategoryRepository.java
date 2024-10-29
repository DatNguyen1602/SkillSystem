package com.project.SkillSystem.Repository;

import com.project.SkillSystem.Entity.CertCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CertCategoryRepository extends JpaRepository<CertCategory, Long> {
    Optional<CertCategory> findById(Long id);
}
