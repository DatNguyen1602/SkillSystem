package com.project.SkillSystem.Repository;

import com.project.SkillSystem.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    boolean existsByLdap(String ldap);

    Optional<User> findByLdap(String ldap);
}
