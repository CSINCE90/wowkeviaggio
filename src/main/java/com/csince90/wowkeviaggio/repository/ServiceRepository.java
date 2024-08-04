package com.csince90.wowkeviaggio.repository;

import com.csince90.wowkeviaggio.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {
}