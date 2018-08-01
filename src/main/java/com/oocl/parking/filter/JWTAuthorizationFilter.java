package com.oocl.parking.filter;

import com.oocl.parking.util.JWTTokenUtils;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.impl.TextCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;



public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTTokenUtils tokenProvider;

    public JWTAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }


    @Override
    protected void doFilterInternal(HttpServletRequest req,
                                    HttpServletResponse res,
                                    FilterChain chain) throws IOException, ServletException {

        System.out.println("JwtAuthenticationTokenFilter");
        try {

            String jwt = resolveToken(req);
            if (StringUtils.hasText(jwt) && this.tokenProvider.validateToken(jwt)) {            //验证JWT是否正确
                Authentication authentication = this.tokenProvider.getAuthentication(jwt);      //获取用户认证信息
                SecurityContextHolder.getContext().setAuthentication(authentication);           //将用户保存到SecurityContext

            }
            chain.doFilter(req, res);
        }catch (ExpiredJwtException e){                                     //JWT失效
            res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }




//
//        System.out.println("third");
//        String header = req.getHeader("Authorization");
//        System.out.println(header);
//        System.out.println(header == null);
//        if (header == null || !header.startsWith("Bearer")) {
//            res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            chain.doFilter(req, res);
//            return;
//        }
//        UsernamePasswordAuthenticationToken authentication = getAuthentication(req);
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        chain.doFilter(req, res);
    }



    private String resolveToken(HttpServletRequest request){
        String bearerToken = request.getHeader("Authorization");         //从HTTP头部获取TOKEN
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")){
            return bearerToken.substring(7, bearerToken.length());                              //返回Token字符串，去除Bearer
        }
        String jwt = request.getParameter("access_token");               //从请求参数中获取TOKEN
        if (StringUtils.hasText(jwt)) {
            return jwt;
        }
        return null;
    }



    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token != null) {
            // parse the token.
            String user = Jwts.parser()
                    .setSigningKey(TextCodec.BASE64.decode("Yn2kjibddFAWtnPJ2AFlL8WXmohJMCvigQggaEypa5E="))
                    .parseClaimsJws(token.replace("Bearer", ""))
                    .getBody()
                    .getSubject();
            if (user != null) {
                return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
            }
            return null;
        }
        return null;
    }
}