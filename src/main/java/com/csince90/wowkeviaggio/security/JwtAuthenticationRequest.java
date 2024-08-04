package com.csince90.wowkeviaggio.security;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class JwtAuthenticationRequest {
   private String nome;
   private String password;
}    

