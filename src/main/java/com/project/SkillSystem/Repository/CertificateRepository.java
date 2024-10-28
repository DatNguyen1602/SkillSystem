package com.project.SkillSystem.Repository;

import com.project.SkillSystem.Entity.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CertificateRepository extends JpaRepository<Certificate, Long> {
    List<Certificate> findByProfileId(String profileId);
}
