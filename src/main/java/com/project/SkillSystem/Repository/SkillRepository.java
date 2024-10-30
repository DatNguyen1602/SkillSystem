package com.project.SkillSystem.Repository;

import com.project.SkillSystem.Entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillRepository extends JpaRepository<Skill, Long> {
    List<Skill> findByProfileId(String profileId);

    void deleteByProfileId(String profileId);
}
