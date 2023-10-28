package com.project.quanlybanhang.service.jwt;

import com.project.quanlybanhang.response.UserPrinciple;
import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.crypto.MacProvider;
import org.slf4j.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Component
@Service
public class JwtService {

    /**
     * Mục đích của class này là tạo ra token sau khi đăng nhập thành công
     */

    /**
     * SECRET_KEY là bí mật, chỉ có phía service biết
     */
    static Key SECRET_KEY = MacProvider.generateKey();
    /**
     * Thời gian có hiệu lực của chuỗi jwt
     **/
    private static final long EXPIRE_TIME = 1048000L;
    private static final Logger logger = LoggerFactory.getLogger(JwtService.class.getName());

    /**
     * Tạo ra jwt từ thông tin user
     */
    public String generateTokenLogin(Authentication authentication) {
        UserPrinciple userPrincipal = (UserPrinciple) authentication.getPrincipal();

        /**
         * Tạo chuỗi json web token từ username của user
         */
        return Jwts.builder()
                .setSubject((userPrincipal.getUsername()))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + EXPIRE_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY.getEncoded()).parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token -> Message: ", e);
        } catch (ExpiredJwtException e) {
            logger.error("Expired JWT token -> Message: ", e);
        } catch (UnsupportedJwtException e) {
            logger.error("Unsupported JWT token -> Message: ", e);
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty -> Message: ", e);
        }

        return false;
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody().getSubject();
    }
}
