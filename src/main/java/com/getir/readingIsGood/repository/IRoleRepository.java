package com.getir.readingIsGood.repository;

import com.getir.readingIsGood.domain.Role;
import com.getir.readingIsGood.model.enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}