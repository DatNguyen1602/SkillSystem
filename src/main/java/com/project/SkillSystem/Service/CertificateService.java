package com.project.SkillSystem.Service;

import com.project.SkillSystem.Dto.Request.CertificateRequest;
import com.project.SkillSystem.Dto.Response.CertificateResponse;
import com.project.SkillSystem.Entity.Certificate;
import com.project.SkillSystem.Mapper.CertificateMapper;
import com.project.SkillSystem.Repository.CertificateRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CertificateService {
    CertificateRepository certificateRepository;
    CertificateMapper certificateMapper;

    public CertificateResponse createCertificate(CertificateRequest certificateRequest) {
         Certificate certificate = certificateMapper.toCertificate(certificateRequest);

         return certificateMapper.toCertificateResponse(certificateRepository.save(certificate));
    }

    public void deleteCertificate(Long id) {
        certificateRepository.deleteById(id);
    }

}
