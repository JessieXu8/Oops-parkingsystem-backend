package com.oocl.parking.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oocl.parking.entities.User;
import com.oocl.parking.services.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;



    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try{
            User creds = new ObjectMapper().readValue(request.getInputStream(),User.class);
            User user = userService.validateUser(creds);
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            creds.getUsername(),
                            user.getRole(),
                            new ArrayList<>()
                            )
            );

        } catch (IOException e) {
           throw new RuntimeException();
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse res, FilterChain chain, Authentication auth) throws IOException, ServletException {
        String token = Jwts.builder()
                .setSubject(((User) auth.getPrincipal()).getUsername())
                .setExpiration(Date.from(Instant.ofEpochSecond(4622470422L)))
                .signWith(SignatureAlgorithm.HS512, TextCodec.BASE64.decode("Yn2kjibddFAWtnPJ2AFlL8WXmohJMCvigQggaEypa5E="))
                .compact();
        res.addHeader("Authorization", "Bearer " + token);
    }
}
