package com.project.SkillSystem.Controller;

import com.project.SkillSystem.Dto.Request.CertificateRequest;
import com.project.SkillSystem.Dto.Response.ApiResponse;
import com.project.SkillSystem.Dto.Response.CertificateResponse;
import com.project.SkillSystem.Service.CertificateService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/certificates")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CertificateController {
    CertificateService certificateService;

    @PostMapping("/add")
    ApiResponse<CertificateResponse> createCertificate(@RequestBody @Valid CertificateRequest certificateRequest) {
        return ApiResponse.<CertificateResponse>builder()
                .result(certificateService.createCertificate(certificateRequest))
                .build();
    }

    @PutMapping("/update/{id}")
    ApiResponse<CertificateResponse> updateCertificate(@PathVariable Long id, CertificateRequest certificateequest) {
        return ApiResponse.<CertificateResponse>builder()
                .result(certificateService.updateCertificate(id, certificateRequest))
                .build();
    }

    @DeleteMapping("/delete/{id}")
    ApiResponse<String> deleteCertificate(@PathVariable Long id) {
        certificateService.deleteCertificate(id);
        return ApiResponse.<String>builder()
                .result(" has been deleted")
                .build();
    }




}
