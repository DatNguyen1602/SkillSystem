package com.project.SkillSystem.Dto.Response;

import com.project.SkillSystem.Enum.CertStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CertificateResponse {
    Long id;

    Long CertCategoryId;

    String name;

    Date issuedDate;

    String achievement;

    String fileAttachment;

    CertStatus status;
}
