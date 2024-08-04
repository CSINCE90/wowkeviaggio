package com.csince90.wowkeviaggio.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.csince90.wowkeviaggio.repository.UserRepository;


@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository; // Il tuo repository utente

    @Override
    public UserDetails loadUserByUsername(String nome) throws UsernameNotFoundException {
        return userRepository.findByNome(nome)
      .map(MyUserDetails::new)
      .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
       
}
