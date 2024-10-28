package com.project.SkillSystem.Mapper;

import com.project.SkillSystem.Dto.Request.CertificateRequest;
import com.project.SkillSystem.Dto.Response.CertificateResponse;
import com.project.SkillSystem.Entity.Certificate;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CertificateMapper {
    Certificate toCertificate(CertificateRequest certificateRequest);

    CertificateResponse toCertificateResponse(Certificate certificate);

    void updateCertificate(@MappingTarget Certificate certificate, CertificateRequest certificateRequest);

}
