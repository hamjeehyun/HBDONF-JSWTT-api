package HBDONF.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MessageListDto {
    private List<MessageDto> messages;
    private long count;

    public MessageListDto() {
    }
}
