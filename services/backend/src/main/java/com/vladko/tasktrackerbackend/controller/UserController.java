package com.vladko.tasktrackerbackend.controller;

import com.vladko.tasktrackerbackend.dto.SaveUserRequestDTO;
import com.vladko.tasktrackerbackend.dto.SaveUserResponseDTO;
import com.vladko.tasktrackerbackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(value = "/user")
    public SaveUserResponseDTO saveUser(@RequestBody @Validated SaveUserRequestDTO saveUserRequestDTO){
        return userService.saveUser(saveUserRequestDTO);
    }
}
