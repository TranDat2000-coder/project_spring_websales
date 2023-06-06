package com.project.quanlybanhang.controller.auth;

import com.project.quanlybanhang.entities.UserEntity;
import com.project.quanlybanhang.model.response.JwtResponse;
import com.project.quanlybanhang.service.IUserService;
import com.project.quanlybanhang.service.jwt.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private IUserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserEntity user){

        //Xác thực từ username và password.
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        user.getPassword()
                )
        );

        //Nếu không xảy ra exception tức là thông tin hợp lệ
        //Set thông tin authentication vào Security context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        //Trả về JWT cho người dùng
        String jwt = jwtService.generateTokenLogin(authentication);

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        UserEntity currentUser = userService.findByUsername(user.getUsername()).get();

        return ResponseEntity.ok(new JwtResponse(jwt,
                currentUser.getId(),
                userDetails.getUsername(),
                currentUser.getFullName(),
                userDetails.getAuthorities())
        );
    }
}
