package com.project.SkillSystem.Entity;

import com.project.SkillSystem.Enum.SkillLevel;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Long skillCategoryId;

    String name;

    @Enumerated(EnumType.STRING)
    SkillLevel level;

    Long yearsOfExperience;

    Date lastUsed;

    String profileId;
}
