package com.project.quanlybanhang.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Data
public class JwtResponse {

    private Long id;
    private String token;

    private String type = "Bearer";
    private String username;
    private String name;
    private Collection<? extends GrantedAuthority> roles;

    public JwtResponse(String accessToken, Long id, String username, String name, Collection<? extends GrantedAuthority> roles) {
        this.token = accessToken;
        this.id = id;
        this.username = username;
        this.name = name;
        this.roles = roles;
    }
}
