package com.project.quanlybanhang.controller.auth;

import com.project.quanlybanhang.request.AuthRequest;
import com.project.quanlybanhang.service.jwt.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/generateToken")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
        return authService.authenticateGetToken(authRequest);
    }
}
