package com.vladko.tasktrackerbackend.service.mapper;

import com.vladko.tasktrackerbackend.database.entity.UserEntity;
import com.vladko.tasktrackerbackend.dto.SaveUserRequestDTO;
import com.vladko.tasktrackerbackend.dto.SaveUserResponseDTO;
import com.vladko.tasktrackerbackend.service.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toDomain(SaveUserRequestDTO object, String encodedPassword) {
        return User.builder()
                .email(object.email())
                .password(encodedPassword)
                .build();
    }

    public SaveUserResponseDTO toResponseDTO(UserEntity user) {
        return SaveUserResponseDTO.builder()
                .id(user.getId())
                .email(user.getEmail())
                .build();
    }

    public UserEntity toEntity(User user) {
        return UserEntity.builder()
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }
}
