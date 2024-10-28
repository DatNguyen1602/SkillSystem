package com.project.SkillSystem.Service;

import com.project.SkillSystem.Dto.Request.WorkExperienceRequest;
import com.project.SkillSystem.Dto.Response.WorkExperienceResponse;
import com.project.SkillSystem.Entity.WorkExperience;
import com.project.SkillSystem.Mapper.WorkExperienceMapper;
import com.project.SkillSystem.Repository.WorkExperienceRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class WorkExperienceService {
    WorkExperienceRepository workExperienceRepository;
    WorkExperienceMapper workExperienceMapper;

    public WorkExperienceResponse createWorkExperience(WorkExperienceRequest workExperienceRequest) {

        WorkExperience workExperience = workExperienceMapper.toWorkExperience(workExperienceRequest);

         return workExperienceMapper.toWorkExperienceResponse(workExperienceRepository.save(workExperience));
    }

    public void deleteWorkExperience(Long id) {
        workExperienceRepository.deleteById(id);
    }

}
