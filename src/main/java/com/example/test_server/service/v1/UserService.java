package com.example.test_server.service.v1;

import com.example.test_server.model.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();

}
