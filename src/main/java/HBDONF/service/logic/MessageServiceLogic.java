package HBDONF.service.logic;

import HBDONF.domain.dto.MessageDto;
import HBDONF.domain.dto.MessageListDto;
import HBDONF.domain.dto.MessageReqDto;
import HBDONF.domain.entity.Message;
import HBDONF.domain.entity.User;
import HBDONF.service.MessageService;
import HBDONF.store.repository.MessageRepository;
import HBDONF.store.repository.UserRepository;
import HBDONF.util.ExceptionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageServiceLogic implements MessageService {
    private final static Logger LOGGER = LoggerFactory.getLogger(MessageServiceLogic.class);
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private UserRepository userRepository;


    /**
     * 메세지 작성
     *
     * @param messageReqDto 메세지
     * @return 메세지 id
     */
    @Override
    public MessageDto registerMessageByUserUid(MessageReqDto messageReqDto) {
        // 글자 수 제한- 140자
        if (messageReqDto.getContent().length() > 140) {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("140자 이상의 메세지는 작성 할 수 없습니다.");
            }
            throw ExceptionUtil.createOnfBizException("140자 이상의 메세지는 작성 할 수 없습니다.");
        }

        // 메세지 등록
        Message message = messageRepository.save(
                Message.builder()
                        .expose(true)
                        .content(messageReqDto.getContent())
                        .title(messageReqDto.getTitle())
                        .uid(messageReqDto.getUid())
                        .testRst(messageReqDto.getTestRst())
                        .dear(messageReqDto.getDear())
                        .created(LocalDateTime.now())
                        .updated(LocalDateTime.now())
                        .build());

        return new MessageDto(message);
    }

    /**
     * 공개된 메세지 목록 조회 - 원하는 갯수만큼 - 등록 내림차순
     *
     * @param size 갯수
     * @return List<MessageDto>
     */
    @Override
    public MessageListDto findAllOpenMessagesByPage(int size) {
        PageRequest pageRequest = PageRequest.of(0, size, Sort.by("created").descending());
        Page<Message> messageList = messageRepository.findAllByExpose(true, pageRequest);

        List<MessageDto> messageDtoList = messageList.getContent().stream().map(message -> {
                    // 사용자 조회
                    User user = userRepository.findByUid(message.getUid());

                    return new MessageDto(message, user);
                }
        ).collect(Collectors.toList());

        MessageListDto messageListDto = new MessageListDto();

        messageListDto.setMessages(messageDtoList);
        messageListDto.setCount(messageList.getTotalElements());

        return messageListDto;
    }

    /**
     * 메세지 목록 조회 - 사용자가 작성한 메세지 중 공개 상태인 메세지 조회 by 사용자의 uid
     *
     * @return List<MessageDto>
     */
    @Override
    public MessageListDto findAllOpenMessageByUserUid(String userUid) {
        // 메세지 목록 조회
        List<Message> messageList = messageRepository.findAllByUidAndAndExpose(userUid, true);

        // 사용자 조회
        User user = userRepository.findByUid(userUid);
        if (user == null)
            throw ExceptionUtil.createOnfBizException("[" + userUid + "] 은 등록되지 않는 사용자입니다.");

        List<MessageDto> messageDtoList = messageList.stream().map(message -> new MessageDto(message, user)).collect(Collectors.toList());

        MessageListDto messageListDto = new MessageListDto();

        messageListDto.setMessages(messageDtoList);
        messageListDto.setCount(messageList.size());

        return messageListDto;
    }

    @Override
    public MessageDto findOpenMessageByMessageId(Long messageId) {
        Message message = messageRepository.findByMessageId(messageId);
        if (message == null)
            throw ExceptionUtil.createOnfBizException("[" + messageId + "] 은 등록되지 않는 메세지입니다.");
        User user = userRepository.findByUid(message.getUid());
        return new MessageDto(message, user);
    }

    /**
     * 메세지 비공개 설정
     *
     * @param messageId 메세지 Id
     * @return String 메세지 Id
     */
    @Override
    public MessageDto closeMessageByUid(Long messageId) {
        Message message = messageRepository.findByMessageId(messageId);

        LocalDateTime now = LocalDateTime.now();
        message.setUpdated(now);
        message.setExpose(false);

        Message afterMessage = messageRepository.save(message);

        return new MessageDto(afterMessage);
    }
}
