package com.project.SkillSystem.Dto.Request;

import com.project.SkillSystem.Enum.CertStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CertificateRequest {
   Long CertCategoryId;

    String name;

    Date issuedDate;

    String achievement;

    String fileAttachment;

    CertStatus status;

    String profileId;
}
