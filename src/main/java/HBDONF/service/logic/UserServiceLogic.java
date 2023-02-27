package HBDONF.service.logic;

import HBDONF.domain.dto.UserDto;
import HBDONF.domain.dto.UserReqDto;
import HBDONF.domain.entity.User;
import HBDONF.service.UserService;
import HBDONF.store.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceLogic implements UserService {
    private final static Logger LOGGER = LoggerFactory.getLogger(UserServiceLogic.class);

    @Autowired
    private UserRepository userRepository;

    /**
     * 사용자 회원가입/로그인
     *
     * @param userReqDto 사용자 정보
     * @return String 사용자 uid
     */
    @Override
    public UserDto registerUser(UserReqDto userReqDto) {
        User user = userRepository.save(
                User.builder()
                        .region(userReqDto.getRegion())
                        .tnickName(userReqDto.getTnickName())
                        .uid(userReqDto.getUid())
                        .tid(userReqDto.getTid())
                        .created(LocalDateTime.now())
                        .updated(LocalDateTime.now())
                        .build()
        );
        UserDto userDto = new UserDto();

        return userDto.from(user);
    }
}
