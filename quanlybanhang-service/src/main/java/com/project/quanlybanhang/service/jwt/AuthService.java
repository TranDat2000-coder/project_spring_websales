package com.project.quanlybanhang.service.jwt;

import com.project.quanlybanhang.entity.User;
import com.project.quanlybanhang.request.AuthRequest;
import com.project.quanlybanhang.response.UserPrincipal;
import com.project.quanlybanhang.response.common.JwtResponse;
import com.project.quanlybanhang.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@Service
public class AuthService {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    public ResponseEntity<JwtResponse> authenticateGetToken(AuthRequest authRequest) {

        //Xác thực từ username và password.
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));

        //Nếu không xảy ra exception tức là thông tin hợp lệ
        //Set thông tin authentication vào Security context
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserPrincipal principal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        //Trả về JWT cho người dùng
        String resultJwt = jwtService.generateToken(authentication);

        return ResponseEntity.ok(new JwtResponse(
                principal.getId(),
                resultJwt,
                principal.getUsername(),
                principal.getFullName(),
                authentication.getAuthorities())
        );

    }
}
