package HBDONF.controller;

import HBDONF.domain.dto.MessageDto;
import HBDONF.domain.dto.MessageListDto;
import HBDONF.domain.dto.MessageReqDto;
import HBDONF.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("message")
public class MessageController {
    @Autowired
    private MessageService messageService;

    private final static Logger LOGGER = LoggerFactory.getLogger(MessageController.class);

    /**
     * 메세지 작성
     *
     * @param messageReqDto 메세지
     * @return 메세지 id
     */
    @PostMapping
    public MessageDto registerMessageByUserUid(@RequestBody MessageReqDto messageReqDto) {
        return messageService.registerMessageByUserUid(messageReqDto);
    }

    /**
     * 공개된 메세지 목록 조회 - 원하는 갯수만큼 - 등록 내림차순
     *
     * @param size 갯수
     * @return MessageListDto
     */
    @GetMapping
    public MessageListDto findAllOpenMessagesByPage(@RequestParam(required = false, defaultValue = "0") int size) {
        return messageService.findAllOpenMessagesByPage(size);
    }

    /**
     * 메세지 목록 조회 - 사용자가 작성한 메세지 중 공개 상태인 메세지 조회 by 사용자의 uid
     *
     * @return List<MessageDto>
     */
    @GetMapping("user/{uid}")
    public MessageListDto findAllOpenMessageByUserUid(@PathVariable(name = "uid") String userUid) {
        return messageService.findAllOpenMessageByUserUid(userUid);
    }

    /**
     * 메세지 목록 조회 - 사용자가 작성한 메세지 중 공개 상태인 메세지 조회 by 사용자의 uid
     *
     * @return List<MessageDto>
     */
    @GetMapping("{messageId}")
    public MessageDto findOpenMessageByMessageId(@PathVariable(name = "messageId") Long messageId) {
        return messageService.findOpenMessageByMessageId(messageId);
    }

    /**
     * 메세지 비공개 설정
     *
     * @param messageId 메세지 Id
     * @return String 메세지 Id
     */
    @PutMapping("{messageId}")
    public MessageDto closeMessageByUid(@PathVariable(name = "messageId") Long messageId) {
        return messageService.closeMessageByUid(messageId);

    }
}
