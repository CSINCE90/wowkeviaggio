package com.csince90.wowkeviaggio.service;

import com.csince90.wowkeviaggio.model.User;
import com.csince90.wowkeviaggio.repository.UserRepository;

import lombok.RequiredArgsConstructor;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    /*public User createUser(User user) {
        return userRepository.save(user);
    }*/
    public User createUser(User user) throws Exception {
        Optional<User> existingUsers = userRepository.findById(user.getId());
       if (existingUsers.isPresent()) {
           throw new Exception(
                   "User with email " + user.getEmail() + " already exists");
       }
       var newUser =  new User();
       newUser.setNome(user.getNome());
       newUser.setEmail(user.getEmail());
       newUser.setIndirizzo(user.getIndirizzo());
       newUser.setNazionalita(user.getNazionalita());
       newUser.setPassword(passwordEncoder.encode(user.getPassword()));
       newUser.setRole(user.getRole());
       return userRepository.save(newUser);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setNome(userDetails.getNome());
        user.setEmail(userDetails.getEmail());
        user.setIndirizzo(userDetails.getIndirizzo());
        user.setNazionalita(userDetails.getNazionalita());
        return userRepository.save(user);
    }
}