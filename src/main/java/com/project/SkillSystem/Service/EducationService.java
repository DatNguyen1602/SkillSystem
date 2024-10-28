package com.project.SkillSystem.Service;

import com.project.SkillSystem.Dto.Request.EducationRequest;
import com.project.SkillSystem.Dto.Response.EducationResponse;
import com.project.SkillSystem.Entity.Education;
import com.project.SkillSystem.Mapper.EducationMapper;
import com.project.SkillSystem.Repository.EducationRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EducationService {
    EducationRepository educationRepository;
    EducationMapper educationMapper;

    public EducationResponse createEducation(EducationRequest educationRequest) {
        Education education= educationMapper.toEducation(educationRequest);

         return educationMapper.toEducationResponse(educationRepository.save(education));
    }

    public EducationResponse updateEducation(Long id, EducationRequest educationRequest){
        Education education = educationRepository.findById(id).orElseThrow();

        educationMapper.updateEducation(education, educationRequest);

        return educationMapper
    }

    public void deleteEducation(Long id) {
        educationRepository.deleteById(id);
    }

}
