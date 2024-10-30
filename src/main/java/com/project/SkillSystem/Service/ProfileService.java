package com.project.SkillSystem.Service;

import com.project.SkillSystem.Dto.Request.ProfileCreationRequest;
import com.project.SkillSystem.Dto.Request.ProfileUpdaterequest;
import com.project.SkillSystem.Dto.Response.CertificateResponse;
import com.project.SkillSystem.Dto.Response.MyProfileResponse;
import com.project.SkillSystem.Dto.Response.ProfileResponse;
import com.project.SkillSystem.Dto.Response.SkillResponse;
import com.project.SkillSystem.Entity.*;
import com.project.SkillSystem.Enum.Profile.ProfileStatus;
import com.project.SkillSystem.Exception.AppException;
import com.project.SkillSystem.Exception.ErrorCode;
import com.project.SkillSystem.Mapper.CertificateMapper;
import com.project.SkillSystem.Mapper.ProfileMapper;
import com.project.SkillSystem.Mapper.SkillMapper;
import com.project.SkillSystem.Repository.*;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProfileService {
    ProfileRepository profileRepository;
    ProfileMapper profileMapper;

    UserRepository userRepository;
    EducationRepository educationRepository;
    CertificateRepository certificateRepository;
    WorkExperienceRepository workExperienceRepository;
    SkillRepository skillRepository;
    LanguageRepository languageRepository;
    ProjectRepository projectRepository;
    CertCategoryRepository certCategoryRepository;
    CertificateMapper certificateMapper;
    SkillCategoryRepository skillCategoryRepository;
    SkillMapper skillMapper;

    public ProfileResponse createProfile(ProfileCreationRequest profileCreationRequest) {
        Profile profile = profileMapper.toProfile(profileCreationRequest);

        if (profileRepository.exsistsByLdap(profileCreationRequest.getLdap()))
            throw new RuntimeException("profile existed");

        profile.setId(profileCreationRequest.getLdap());

        Optional<User> user = userRepository.findbyLdap(profile.getId());
        if (user.isPresent()) {
            String firstName = user.get().getFirstName();
            String lastName = user.get().getLastName();
            profile.setFullName(firstName + ". " + lastName);
        } else {
            String errorMessage = "Không tìm thấy User với Ldap: " + profile.getId();
            throw new IllegalArgumentException(errorMessage);
        }
        profile.setAvailableTime(LocalDate.now().toString());
        profile.setLastUpdate(LocalDateTime.now().toString());
        profile.setEmail(profile.getId() + "@cmcglobal.vn");
        profile.setStatus(ProfileStatus.NEEDUPDATE);

        return profileMapper.toProfileResponse(profileRepository.save(profile));
    }

    public List<ProfileResponse> getAllProfile() {
        return profileRepository.findAll()
                .stream()
                .map(profileMapper::toProfileResponse)
                .toList();
    }

    public MyProfileResponse getMyProfile() {
        var context = SecurityContextHolder.getContext();
        String name = context.getAuthentication().getName();

        Profile profile = profileRepository.findById(name)
                .orElseThrow(() ->new AppException(ErrorCode.PROFILE_NOT_EXISTED));

        profile.setEducation(educationRepository.findByProfileId(name));
        profile.setWorkExperience(workExperienceRepository.findByProfileId(name));
        profile.setLanguage(languageRepository.findByProfileId(name));
        profile.setProject(projectRepository.findByProfileId(name));

        List<Certificate> certificates = certificateRepository.findByProfileId(name);
        List<CertCategory> certCategories = certCategoryRepository.findAll();

        Map<String, List<CertificateResponse>> certificateList =
                certCategories.stream().collect(Collectors.toMap(
                        CertCategory::getName,
                        Category -> certificates.stream()
                                .filter(cert -> cert.getCertCategoryId().equals(Category.getId()))
                                .map(certificateMapper::toCertificateResponse)
                                .collect(Collectors.toList())
                ));
        profile.setCertificateList(certificateList);

        List<Skill> skills = skillRepository.findByProfileId(name);
        List<SkillCategory> skillCategories = skillCategoryRepository.findAll();

        Map<String, List<SkillResponse>> skillList =
                skillCategories.stream().collect(Collectors.toMap(
                        SkillCategory::getTitle,
                        Category -> skills.stream()
                                .filter(skill -> skill.getSkillCategoryId().equals(Category.getId()))
                                .map(skillMapper::toSkillResponse)
                                .collect(Collectors.toList())
                ));
        profile.setSkillList(skillList);

        return profileMapper.toMyProfileResponse(profile);
    }

    public MyProfileResponse getMyProfileById(String id) {
        Profile profile = profileRepository.findById(id)
                .orElseThrow(() ->new AppException(ErrorCode.PROFILE_NOT_EXISTED));

//        profile.setEducation(educationRepository.findByProfileId(id));
//        profile.setCertificate(certificateRepository.findByProfileId(id));
//        profile.setWorkExperience(workExperienceRepository.findByProfileId(id));
//        profile.setLanguage(languageRepository.findByProfileId(id));
//        profile.setProject(projectRepository.findByProfileId(id));

        return profileMapper.toMyProfileResponse(profile);
    }

    public ProfileResponse updateProfile(String id, ProfileUpdaterequest profileUpdateRequest) {
        Profile profile = profileRepository.findById(id).orElseThrow(() ->new AppException(ErrorCode.PROFILE_NOT_EXISTED));

        profileMapper.updateProfile(profile, profileUpdateRequest);

        profile.setLastUpdate(LocalDateTime.now().toString());

        return profileMapper.toProfileResponse(profileRepository.save(profile));
    }

    public void deleteProfile(String id) {

        profileRepository.deleteById(id);
    }
}
