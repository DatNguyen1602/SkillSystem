package com.project.SkillSystem.Controller;

import com.project.SkillSystem.Dto.Response.ApiResponse;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/s")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class WorkExperienceController {
    Service Service;

    @PostMapping("/add")
    ApiResponse<Response> create(@RequestBody @Valid Request Request) {
        return ApiResponse.<Response>builder()
                .result(Service.create(Request))
                .build();
    }

    @PutMapping("/update/{id}")
    ApiResponse<Response> update(@PathVariable Long id, Request Request) {
        return ApiResponse.<Response>builder()
                .result(Service.update(id, Request))
                .build();
    }

    @DeleteMapping("/delete/{id}")
    ApiResponse<String> delete(@PathVariable Long id) {
        Service.delete(id);
        return ApiResponse.<String>builder()
                .result(" has been deleted")
                .build();
    }




}
