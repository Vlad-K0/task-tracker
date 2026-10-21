package com.vladko.tasktrackerbackend.service;

import com.vladko.tasktrackerbackend.database.entity.UserEntity;
import com.vladko.tasktrackerbackend.database.repository.UserRepository;
import com.vladko.tasktrackerbackend.dto.SaveUserRequestDTO;
import com.vladko.tasktrackerbackend.dto.SaveUserResponseDTO;
import com.vladko.tasktrackerbackend.service.domain.User;
import com.vladko.tasktrackerbackend.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder encoder;

    public SaveUserResponseDTO saveUser(SaveUserRequestDTO userRequestDTO){
        String encodePassword = encoder.encode(userRequestDTO.password());
        User user = userMapper.toDomain(userRequestDTO,encodePassword);
        UserEntity userEntity = userMapper.toEntity(user);
        UserEntity savedUser = userRepository.save(userEntity);
        return userMapper.toResponseDTO(savedUser);
    }

}
