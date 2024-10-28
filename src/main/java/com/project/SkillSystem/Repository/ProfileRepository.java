package com.project.SkillSystem.Repository;

import com.project.SkillSystem.Entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile, String> {
    boolean exsistsByLdap(String ldap);
}
