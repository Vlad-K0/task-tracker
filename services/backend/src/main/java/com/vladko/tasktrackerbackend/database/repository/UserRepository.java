package com.vladko.tasktrackerbackend.database.repository;

import com.vladko.tasktrackerbackend.database.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
}
