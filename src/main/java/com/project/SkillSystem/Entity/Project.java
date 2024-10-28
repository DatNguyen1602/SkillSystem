package com.project.SkillSystem.Entity;

import com.project.SkillSystem.Enum.Profile.ProfileRole;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String title;

    Date startDate;

    Date endDate;

    String client;

    String description;

    Long teamSize;

    @Enumerated(EnumType.STRING)
    ProfileRole role;

    Long skillId;

    String profileId;
}
