package HBDONF.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserReqDto {
    private String uid;
    private String tid;
    private String region;
    private String tnickName;

    public UserReqDto(String tid) {
        this.tid = tid;
    }

    public UserReqDto() {

    }

}
