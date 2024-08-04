package com.csince90.wowkeviaggio.repository;

import com.csince90.wowkeviaggio.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByNome(String nome);
}