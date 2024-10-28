package com.project.SkillSystem.Repository;

import com.project.SkillSystem.Entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EducationRepository extends JpaRepository<Education, Long> {
    List<Education> findByProfileId(String profileId);
}
