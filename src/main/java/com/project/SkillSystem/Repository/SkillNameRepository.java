package com.project.SkillSystem.Repository;

import com.project.SkillSystem.Entity.SkillName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SkillNameRepository extends JpaRepository<SkillName, Long> {
    Optional<SkillName> findById(Long id);
    List<SkillName> findBySkillCategoryId(String skillCategoryId);
}
