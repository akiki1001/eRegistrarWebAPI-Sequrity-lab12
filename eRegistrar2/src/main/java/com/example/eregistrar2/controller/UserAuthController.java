package com.example.eregistrar2.controller;

import com.example.eregistrar2.dto.UserAuthRequest;
import com.example.eregistrar2.jwtUtil.JWTMgmtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = {"/eregistrar/api/service"})
public class UserAuthController {
    @Autowired
    private JWTMgmtUtil jwtMgmtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping(value = {"/public/authenticate"})
    public String authenticateUser(@Valid @RequestBody UserAuthRequest userAuthRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userAuthRequest.getUsername(),
                            userAuthRequest.getPassword())
            );
        } catch (Exception ex) {
            System.out.println("UserAuthException is: " + ex);
            System.out.println("Invalid Username and/or Password!");
            throw ex;
        }
        // todo fetch all the user's info - firstName, lastName etc.
        return jwtMgmtUtil.generateToken(userAuthRequest.getUsername());
    }
}
