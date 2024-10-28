package com.project.SkillSystem.Entity;

import com.project.SkillSystem.Enum.CertStatus;
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
public class Certificate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Long CertCategoryId;

    String name;

    Date issuedDate;

    String achievement;

    String fileAttachment;

    @Enumerated(EnumType.STRING)
    CertStatus status;

    String profileId;
}
