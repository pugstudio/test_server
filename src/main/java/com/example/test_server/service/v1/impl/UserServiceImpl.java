package com.example.test_server.service.v1.impl;

import com.example.test_server.mapper.v1.UserMapper;
import com.example.test_server.model.dto.UserDto;
import com.example.test_server.service.v1.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDto> findAll() {
        return userMapper.findAll();
    }
}
