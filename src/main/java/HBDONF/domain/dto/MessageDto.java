package HBDONF.domain.dto;

import HBDONF.domain.common.BaseTimeDto;
import HBDONF.domain.entity.Message;
import HBDONF.domain.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageDto extends BaseTimeDto<MessageDto> {
    private Long messageId;
    private String title;
    private String content;
    private boolean expose;
    private String testRst;
    private int dear;
    private UserDto user;

    public MessageDto() {
    }

    public MessageDto(Message message, User user) {
        UserDto userDto = new UserDto();

        this.setMessageId(message.getMessageId());
        this.setTitle(message.getTitle());
        this.setContent(message.getContent());
        this.setExpose(message.isExpose());
        this.setTestRst(message.getTestRst());
        this.setDear(message.getDear());
        this.setCreated(message.getCreated());
        this.setUpdated(message.getUpdated());

        if (user != null) {
            userDto.setUid(user.getUid());
            userDto.setTid(user.getTid());
            userDto.setRegion(user.getRegion());
            userDto.setTnickName(user.getTnickName());
        }

        this.setUser(userDto);
    }

    public MessageDto(Message message) {
        this.setTitle(message.getTitle());
        this.setContent(message.getContent());
        this.setExpose(message.isExpose());
        this.setTestRst(message.getTestRst());
        this.setDear(message.getDear());
        this.setCreated(message.getCreated());
        this.setUpdated(message.getUpdated());
    }


}
