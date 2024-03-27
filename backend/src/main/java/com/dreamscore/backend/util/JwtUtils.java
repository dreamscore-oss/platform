package com.dreamscore.backend.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class JwtUtils {

    public String getSub() {
        org.springframework.security.oauth2.jwt.Jwt jwt =
            (org.springframework.security.oauth2.jwt.Jwt) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        return jwt.getClaimAsString("sub");
    }
}
