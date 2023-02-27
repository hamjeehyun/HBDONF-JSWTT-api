package HBDONF.service;


import HBDONF.domain.dto.UserDto;
import HBDONF.domain.dto.UserReqDto;

public interface UserService {
    UserDto registerUser(UserReqDto userDto);
}
