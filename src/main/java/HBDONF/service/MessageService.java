package HBDONF.service;

import HBDONF.domain.dto.MessageDto;
import HBDONF.domain.dto.MessageListDto;
import HBDONF.domain.dto.MessageReqDto;

public interface MessageService {

    MessageDto registerMessageByUserUid(MessageReqDto messageReqDto);

    MessageListDto findAllOpenMessagesByPage(int size);

    MessageListDto findAllOpenMessageByUserUid(String userUid);

    MessageDto findOpenMessageByMessageId(Long messageId);

    MessageDto closeMessageByUid(Long messageId);
}
