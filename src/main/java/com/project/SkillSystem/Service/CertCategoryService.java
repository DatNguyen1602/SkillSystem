package com.project.SkillSystem.Service;

import com.project.SkillSystem.Dto.Request.CertCategoryRequest;
import com.project.SkillSystem.Dto.Response.CertCategoryResponse;
import com.project.SkillSystem.Entity.CertCategory;
import com.project.SkillSystem.Mapper.CertCategoryMapper;
import com.project.SkillSystem.Repository.CertCategoryRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CertCategoryService {
    CertCategoryRepository certCategoryRepository;
    CertCategoryMapper certCategoryMapper;

    public CertCategoryResponse createCertCategory(CertCategoryRequest certCategoryRequest) {
        CertCategory certCategory = certCategoryMapper.toCertCategory(certCategoryRequest);

         return certCategoryMapper.toCertCategoryResponse(certCategoryRepository.save(certCategory));
    }

    public void deleteCertCategory(Long id) {
        certCategoryRepository.deleteById(id);
    }

}
