package HBDONF.domain.dto;

import HBDONF.domain.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private String uid;
    private String tid;
    private String region;
    private String tnickName;

    public UserDto(String tid) {
        this.tid = tid;
    }

    public UserDto() {

    }

    public UserDto from(User user) {
        UserDto userDto = new UserDto();

        userDto.setUid(user.getUid());
        userDto.setTid(user.getTid());
        userDto.setRegion(user.getRegion());
        userDto.setTnickName(user.getTnickName());

        return userDto;

    }

}
