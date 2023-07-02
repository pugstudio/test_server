package com.example.test_server.controller.v1;

import com.example.test_server.web_socket.WebSocketMapping;
import com.example.test_server.model.dto.UserDto;
import com.example.test_server.service.v1.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Slf4j
@Controller
@WebSocketMapping("/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @WebSocketMapping("/all")
    @ResponseBody
    public List<UserDto> getAllUsers() {
        List<UserDto> result = userService.findAll();
        log.info("MATTTTT {}", result.get(0).getId());
        return result;
    }

    // 이하 findById, insert, update, delete 메소드를 작성하시면 됩니다.
}

