package com.project.SkillSystem.Service;

import com.project.SkillSystem.Dto.Request.UserCreationRequest;
import com.project.SkillSystem.Dto.Request.UserUpdateRequest;
import com.project.SkillSystem.Dto.Response.UserResponse;
import com.project.SkillSystem.Entity.Profile;
import com.project.SkillSystem.Entity.User;
import com.project.SkillSystem.Enum.User.UserStatus;
import com.project.SkillSystem.Exception.AppException;
import com.project.SkillSystem.Exception.ErrorCode;
import com.project.SkillSystem.Mapper.ProfileMapper;
import com.project.SkillSystem.Mapper.UserMapper;
import com.project.SkillSystem.Repository.*;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {
    UserRepository userRepository;
    UserMapper userMapper;

    ProfileRepository profileRepository;
    EducationRepository educationRepository;
    CertificateRepository certificateRepository;
    WorkExperienceRepository workExperienceRepository;
    SkillRepository skillRepository;
    LanguageRepository languageRepository;
    ProjectRepository projectRepository;

    PasswordEncoder passwordEncoder;

    public UserResponse createUser(UserCreationRequest userCreationRequest) {
        User user = userMapper.toUser(userCreationRequest);

        String firstName = user.getFirstName();
        String lastName = user.getLastName();

        //Kiểm tra name
        validateFirstName(firstName);
        validateLastName(lastName);

        //Tạo LDAP
        String baseId = (extractUppercaseLetters(lastName) + firstName).toLowerCase();
        String userId = generateUniqueLdap(baseId);

        user.setLdap(generateUniqueLdap(userId));
        user.setStatus(UserStatus.ACTIVE);

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        user.setPassword(passwordEncoder.encode(userCreationRequest.getPassword()));

        return userMapper.toUserResponse(userRepository.save(user));
    }

    public UserResponse updateUser(String ldap, UserUpdateRequest userUpdateRequest) {
        User user = userRepository.findbyLdap(ldap).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));
        userMapper.updateUser(user, userUpdateRequest);

        return userMapper.toUserResponse(userRepository.save(user));
    }

    public void deleteUser(String ldap) {
        Optional<Profile> profile = profileRepository.findById(ldap);
        if(profile.isPresent()) {
            educationRepository.deleteByProfileId(ldap);
            certificateRepository.deleteByProfileId(ldap);
            workExperienceRepository.deleteByProfileId(ldap);
            languageRepository.deleteByProfileId(ldap);
            projectRepository.deleteByProfileId(ldap);
            skillRepository.deleteByProfileId(ldap);
            profileRepository.deleteById(ldap);
        }

        userRepository.deleteById(ldap);
    }

    void validateFirstName(String firstName) {
        if (! firstName.matches("[A-Za-z]+")) {
            throw new IllegalArgumentException("Firstname must contain only letters");
        }

        if (!
                Character.isUpperCase(firstName.charAt(0))  || !
                firstName.substring(1).equals(firstName.substring(1).toLowerCase())
        ) {
            throw new IllegalArgumentException("Firstname must start with an uppercase letters and the remaining letters must be lowercase");
        }
    }

    void validateLastName(String lastName) {
        if (! lastName.matches("([A-Za-z]+( [A-Za-z]+)*)")) {
            throw new IllegalArgumentException("Lastname must contain only letters and spaces");
        }


        String[] words = lastName.split(" ");
        for (String word : words) {
            if (!
                    Character.isUpperCase(word.charAt(0))  || !
                    word.substring(1).equals(word.substring(1).toLowerCase())
            ) {
                throw new IllegalArgumentException("Lastname must start with an uppercase letters and the remaining letters must be lowercase");
            }
        }
    }

    protected String extractUppercaseLetters(String input) {
        StringBuilder uppercaseLetters = new StringBuilder();
        for (char ch : input.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                uppercaseLetters.append(ch);
            }
        }
        return uppercaseLetters.toString();
    }

    protected String generateUniqueLdap(String baseId) {
        String userId = baseId;
        int count = 1;

        while (userRepository.exsistsByLdap(userId)) {
            userId = baseId + count;
            count++;
        }
        return userId;
    }
}
