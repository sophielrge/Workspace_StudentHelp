package fr.insa.StudentHelp.StudentManager.mapper;


import org.springframework.stereotype.Component;

import fr.insa.StudentHelp.StudentManager.model.StudentEntity;

import fr.insa.StudentHelp.StudentManager.model.Student;


@Component  

public class StudentMapper {

    

    public Student toDTO(StudentEntity entity) {

        if (entity == null) {

            return null;

        }

        

        Student dto = new Student();

        dto.setId(entity.getId());

        dto.setLastname(entity.getLastname());

        dto.setFirstname(entity.getFirstname());

        dto.setEmail(entity.getEmail());

        dto.setSpeciality(entity.getSpeciality());

        dto.setSkills(entity.getSkills());
        dto.setAvailability(entity.getAvailability());

        dto.setRating(entity.getRating());

        

        return dto;

    }


    public StudentEntity toEntity(Student dto) {

        if (dto == null) {

            return null;

        }

        

        StudentEntity entity = new StudentEntity();

        entity.setId(dto.getId());

        entity.setLastname(dto.getLastname());

        entity.setFirstname(dto.getFirstname());

        entity.setEmail(dto.getEmail());

        entity.setSpeciality(dto.getSpeciality());

        entity.setSkills(dto.getSkills());

        entity.setAvailability(dto.getAvailability());

        entity.setRating(dto.getRating());

        

        return entity;

    }

}