package fr.insa.StudentHelp.StudentManager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.insa.StudentHelp.StudentManager.model.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    List<StudentEntity> findBySkillsContaining(String keyword);
}