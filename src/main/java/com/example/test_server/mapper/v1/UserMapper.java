package com.example.test_server.mapper.v1;

import com.example.test_server.model.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface UserMapper {
    List<UserDto> findAll();

    UserDto findById(Long id);

    int insert(UserDto user);
}
