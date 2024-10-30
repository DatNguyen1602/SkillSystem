package com.project.SkillSystem.Service;

import com.project.SkillSystem.Dto.Request.AuthenticationRequest;
import com.project.SkillSystem.Dto.Response.AuthenticationResponse;
import com.project.SkillSystem.Exception.AppException;
import com.project.SkillSystem.Exception.ErrorCode;
import com.project.SkillSystem.Repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationService {
    UserRepository userRepository;

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        var user = userRepository.findbyLdap(authenticationRequest.getLdap())
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        return AuthenticationResponse.builder().build();
    }
}
