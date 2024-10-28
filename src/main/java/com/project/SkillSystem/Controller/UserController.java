package com.project.SkillSystem.Controller;

import com.project.SkillSystem.Dto.Request.UserCreationRequest;
import com.project.SkillSystem.Dto.Request.UserUpdateRequest;
import com.project.SkillSystem.Dto.Response.ApiResponse;
import com.project.SkillSystem.Dto.Response.UserResponse;
import com.project.SkillSystem.Service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {
    UserService userService;

    @PostMapping("/add")
    ApiResponse<UserResponse> createUser(@RequestBody @Valid UserCreationRequest userCreationRequest) {
        return ApiResponse.<UserResponse>builder()
                .result(userService.createUser(userCreationRequest))
                .build();
    }

    @PutMapping("/update/{ldap}")
    ApiResponse<UserResponse> updateUser(@PathVariable String ldap, @RequestBody UserUpdateRequest userUpdateRequest) {
        return ApiResponse.<UserResponse>builder()
                .result(userService.updateUser(ldap, userUpdateRequest))
                .build();
    }

    @DeleteMapping("/delete/{ldap}")
    ApiResponse<String> deleteUser(@PathVariable String ldap) {
        userService.deleteUser(ldap);
        return ApiResponse.<String>builder()
                .result("User has been deleted")
                .build();
    }
}
