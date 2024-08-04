package com.csince90.wowkeviaggio.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/authenticate")
public class JwtController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

   @PostMapping
   public String getTokenForAuthenticatedUser(@RequestBody JwtAuthenticationRequest authRequest) throws Exception {
      Authentication authentication = authenticationManager
            .authenticate(
                  new UsernamePasswordAuthenticationToken(authRequest.getNome(), authRequest.getPassword()));
      if (authentication.isAuthenticated()) {
         return jwtService.generateToken(authRequest.getNome());
      } else {
         throw new Exception("Invalid user credentials");
      }
    }

}
