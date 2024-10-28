package com.project.SkillSystem.Repository;

import com.project.SkillSystem.Entity.WorkExperience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkExperienceRepository extends JpaRepository<WorkExperience,Long> {
    List<WorkExperience> findByProfileId(String profileId);
}
