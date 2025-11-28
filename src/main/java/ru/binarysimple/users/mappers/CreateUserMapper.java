package ru.binarysimple.users.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.binarysimple.users.dto.CreateUserDto;
import ru.binarysimple.users.model.User;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CreateUserMapper {
    User toEntity(CreateUserDto createUserDto);

    CreateUserDto toUserDto(User user);
}