package com.csince90.wowkeviaggio.security;

import com.csince90.wowkeviaggio.model.User;  // Assicurati che il pacchetto sia corretto

import lombok.Data;
import java.util.List;

import java.util.Arrays;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

@Data
public class MyUserDetails implements UserDetails {
    private  String nome;
    private  String password;
    private  List <GrantedAuthority> authorities;


    // Costruttore che accetta un oggetto User
    public MyUserDetails(User user) {
        this.nome = user.getNome();
        this.password = user.getPassword();
       this.authorities = Arrays.stream(user.getRole()
      .split(","))
      .map(SimpleGrantedAuthority::new)
      .collect(Collectors.toList()) ;
    }

    @Override
    public String getUsername() {
        return nome;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Implementa la logica se necessario
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Implementa la logica se necessario
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Implementa la logica se necessario
    }

    @Override
    public boolean isEnabled() {
        return true; // Implementa la logica se necessario
    }
}