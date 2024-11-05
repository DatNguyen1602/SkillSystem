package com.project.SkillSystem.Service;

import com.project.SkillSystem.Dto.Response.SkillCategoryResponse;
import com.project.SkillSystem.Entity.SkillCategory;
import com.project.SkillSystem.Mapper.SkillCategoryMapper;
import com.project.SkillSystem.Repository.SkillCategoryRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SkillCategoryService {
    SkillCategoryRepository skillCategoryRepository;
    SkillCategoryMapper skillCategoryMapper;

//    public SkillCategoryResponse createSkillCategory(SkillCategoryRequest skillCategoryRequest) {
//        SkillCategory skillCategory = skillCategoryMapper.toSkillCategory(skillCategoryRequest);
//
//         return skillCategoryMapper.toSkillCategoryResponse(skillCategoryRepository.save(skillCategory));
//    }

    public void deleteSkillCategory(Long id) {
        skillCategoryRepository.deleteById(id);
    }

}
