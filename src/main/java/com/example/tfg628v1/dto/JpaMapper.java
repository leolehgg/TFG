package com.example.tfg628v1.dto;

import com.example.tfg628v1.dto.dp.LibroDto;
import com.example.tfg628v1.dto.jwt.SignupRequest;
import com.example.tfg628v1.dto.jwt.SignupResponse;
import com.example.tfg628v1.entidades.DesarrolloPersonal.Libro;
import com.example.tfg628v1.entidades.Usuario.Usuario;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(
        componentModel = "spring",
        collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED
)
public interface JpaMapper {
    //@Mapping(target = "empleados", ignore=true)
    LibroDto toDto(Libro entity);

    Libro toEntity(LibroDto dto);

    List<LibroDto> toDtoList(List<Libro> list);
    List<Libro> toEntityList(List<LibroDto> list);


    Usuario toEntity(SignupRequest dto);
    SignupResponse toDto(Usuario entity);

}
