package fr.insa.StudentHelp.RequestManager.mapper;

import org.mapstruct.Mapper;

import fr.insa.StudentHelp.RequestManager.model.RequestEntity;
import fr.insa.StudentHelp.RequestManager.model.Request;

@Mapper(componentModel = "spring")
public interface RequestMapper {

    Request toDTO(RequestEntity entity);

    Request toEntity(Request dto);
}