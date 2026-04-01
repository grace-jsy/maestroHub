package com.grace.maestrohub.common.security.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtProvider jwtProvider;

    public JwtAuthenticationFilter(JwtProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        String bearerToken = request.getHeader("Authorization");
        String token = jwtProvider.resolveToken(bearerToken);

        if (token != null && jwtProvider.validateToken(token)) {
            Long userId = jwtProvider.getUserId(token);

            request.setAttribute("userId", userId);
        }

        filterChain.doFilter(request, response);
    }

}
