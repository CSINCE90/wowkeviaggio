package com.csince90.wowkeviaggio.repository;

import com.csince90.wowkeviaggio.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {
}