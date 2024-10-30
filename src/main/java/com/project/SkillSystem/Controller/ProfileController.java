package com.project.SkillSystem.Controller;

import com.project.SkillSystem.Dto.Request.ProfileCreationRequest;
import com.project.SkillSystem.Dto.Request.ProfileUpdaterequest;
import com.project.SkillSystem.Dto.Response.ApiResponse;
import com.project.SkillSystem.Dto.Response.MyProfileResponse;
import com.project.SkillSystem.Dto.Response.ProfileResponse;
import com.project.SkillSystem.Service.ProfileService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/list")
    ApiResponse<List<ProfileResponse>> getAllProfile() {
        return ApiResponse.<List<ProfileResponse>>builder()
                .result(profileService.getAllProfile())
                .build();
    }

    @GetMapping("/myProfile")
    ApiResponse<MyProfileResponse> getMyProfile() {
        return ApiResponse.<MyProfileResponse>builder()
                .result(profileService.getMyProfile())
                .build();
    }

    @GetMapping("/profile/{id}")
    ApiResponse<MyProfileResponse> getMyProfileById(@PathVariable String id) {
        return ApiResponse.<MyProfileResponse>builder()
                .result(profileService.getMyProfileById(id))
                .build();
    }

    @PutMapping("/update/{id}")
    ApiResponse<ProfileResponse> updateProfile(@PathVariable String id, @RequestBody @Valid ProfileUpdaterequest profileUpdaterequest) {
        return ApiResponse.<ProfileResponse>builder()
                .result(profileService.updateProfile(id, profileUpdaterequest))
                .build();
    }

    @DeleteMapping("/delete/{id}")
    ApiResponse<String> deleteProfile(@PathVariable String id) {
        profileService.deleteProfile(id);
        return ApiResponse.<String>builder().result("Profile has been delete").build();
    }
}
