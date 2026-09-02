package com.api.auth.controller;

import com.api.auth.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    @GetMapping("/me")
    public ResponseEntity<Map<String, Object>> getCurrentUser(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(Map.of(
                "id",          user.getId(),
                "username",    user.getUsername(),
                "email",       user.getEmail(),
                "role",        user.getRole().name(),
                "createdAt",   user.getCreatedAt().toString(),
                "retrievedAt", LocalDateTime.now().toString()
        ));
    }
}
