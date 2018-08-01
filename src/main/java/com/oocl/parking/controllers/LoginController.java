package com.oocl.parking.controllers;

import com.oocl.parking.entities.User;
import com.oocl.parking.repositories.UserRepository;
import com.oocl.parking.util.JWTTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Objects;


@CrossOrigin
@RestController
@RequestMapping("")
public class LoginController {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    private JWTTokenUtils jwtTokenUtils;


    @PostMapping("/api/v1/login")
    public String login(@RequestBody User user, HttpServletResponse httpResponse) throws Exception{
        //通过用户名和密码创建一个 Authentication 认证对象，实现类为 UsernamePasswordAuthenticationToken
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword());
        //如果认证对象不为空
        if (Objects.nonNull(authenticationToken)){
            userRepository.findByUsername(authenticationToken.getPrincipal().toString())
                    .orElseThrow(()->new BadCredentialsException("用户不存在"));
        }
        try {
            //通过 AuthenticationManager（默认实现为ProviderManager）的authenticate方法验证 Authentication 对象
            Authentication authentication = authenticationManager.authenticate(authenticationToken);
            //将 Authentication 绑定到 SecurityContext
            SecurityContextHolder.getContext().setAuthentication(authentication);

            //生成Token
            String token = jwtTokenUtils.createToken(authentication,false);

            //将Token写入到Http头部
            httpResponse.addHeader("Authorization","Bearer "+token);
            return "Bearer "+token;
        }catch (BadCredentialsException authentication){
            throw new Exception("密码错误");
        }
    }
}
