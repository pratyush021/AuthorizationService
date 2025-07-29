package com.spring.authorization.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @GetMapping("/health")
    public String healthCheck(HttpServletRequest request) {
        return "SessionId: " + request.getRequestedSessionId();
    }
}
