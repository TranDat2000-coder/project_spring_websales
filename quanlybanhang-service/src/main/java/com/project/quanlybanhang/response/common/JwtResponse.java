package com.project.quanlybanhang.response.common;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Data
public class JwtResponse {

    private Long id;
    private String token;
    private String type = "Bearer";
    private String username;
    private String fullName;
    private Collection<? extends GrantedAuthority> roles;

    public JwtResponse(Long id, String token, String username, String fullName,
                       Collection<? extends GrantedAuthority> roles) {
        this.id = id;
        this.token = token;
        this.username = username;
        this.fullName = fullName;
        this.roles = roles;
    }
}
