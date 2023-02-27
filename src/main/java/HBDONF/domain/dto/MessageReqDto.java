package HBDONF.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageReqDto {
    private String uid;
    private String content;
    private String title;
    private String testRst;
    private int dear;

    public MessageReqDto(String uid) {
        this.uid = uid;
    }

    public MessageReqDto() {
    }
}
