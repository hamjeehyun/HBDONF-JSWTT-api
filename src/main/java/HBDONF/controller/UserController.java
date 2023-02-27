package HBDONF.controller;

import HBDONF.domain.dto.UserDto;
import HBDONF.domain.dto.UserReqDto;
import HBDONF.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
    private final static Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * 사용자 회원가입/로그인
     *
     * @param userDto 사용자 정보
     * @return String 사용자 uid
     */
    @PostMapping
    public UserDto registerUser(@RequestBody UserReqDto userDto) {
        return userService.registerUser(userDto);
    }
}
