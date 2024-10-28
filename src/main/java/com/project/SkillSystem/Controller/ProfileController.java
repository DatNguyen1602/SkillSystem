package com.project.SkillSystem.Controller;

import com.project.SkillSystem.Dto.Request.ProfileCreationRequest;
import com.project.SkillSystem.Dto.Response.ApiResponse;
import com.project.SkillSystem.Dto.Response.ProfileResponse;
import com.project.SkillSystem.Service.ProfileService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profiles")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProfileController {
    ProfileService profileService;

    @PostMapping("/add")
    ApiResponse<ProfileResponse> createProfile(@RequestBody @Valid ProfileCreationRequest profileCreationRequest) {
        return ApiResponse.<ProfileResponse>builder()
                .result(profileService.createProfile(profileCreationRequest))
                .build();
    }
}
