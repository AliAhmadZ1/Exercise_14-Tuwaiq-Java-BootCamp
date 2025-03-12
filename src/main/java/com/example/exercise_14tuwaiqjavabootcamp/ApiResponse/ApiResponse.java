package com.example.exercise_14tuwaiqjavabootcamp.ApiResponse;

import jakarta.annotation.security.DenyAll;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse {
    private String message;
}
