package ru.binarysimple.users.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import ru.binarysimple.users.dto.UpdateUserDto;
import ru.binarysimple.users.model.User;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UpdateUserMapper {
    User toEntity(UpdateUserDto updateUserDto);

    UpdateUserDto toUpdateUserDto(User user);
}