package fr.insa.StudentHelp.AuthManager.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.insa.StudentHelp.AuthManager.model.UserEntity;

public interface AuthRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
}