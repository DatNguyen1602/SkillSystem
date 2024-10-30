package com.project.SkillSystem.Service;

import com.project.SkillSystem.Dto.Request.SkillRequest;
import com.project.SkillSystem.Dto.Response.SkillResponse;
import com.project.SkillSystem.Entity.Skill;
import com.project.SkillSystem.Exception.AppException;
import com.project.SkillSystem.Exception.ErrorCode;
import com.project.SkillSystem.Mapper.SkillMapper;
import com.project.SkillSystem.Repository.SkillRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SkillService {
    SkillRepository skillRepository;
    SkillMapper skillMapper;

    public SkillResponse createSkill(SkillRequest skillRequest) {
        Skill skill= skillMapper.toSkill(skillRequest);

         return skillMapper.toSkillResponse(skillRepository.save(skill));
    }

    public SkillResponse updateSkill(Long id, SkillRequest skillRequest) {
        Skill skill = skillRepository.findById(id)
                .orElseThrow(() ->new AppException(ErrorCode.SKILL_NOT_EXISTED));

        skillMapper.updateSkill(skill, skillRequest);

        return skillMapper.toSkillResponse(skillRepository.save(skill));
    }

    public void deleteSkill(Long id) {
        skillRepository.deleteById(id);
    }
}
