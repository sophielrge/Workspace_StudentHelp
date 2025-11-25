package fr.insa.StudentHelp.StudentManager.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import fr.insa.StudentHelp.StudentManager.model.StudentEntity;
import fr.insa.StudentHelp.StudentManager.model.Student;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    Student toDTO(StudentEntity student);

    StudentEntity toEntity(Student dto);
}