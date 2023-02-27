package HBDONF.store.repository;


import HBDONF.domain.entity.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long>, JpaSpecificationExecutor<Message> {
    Page<Message> findAllByExpose(Boolean expose, Pageable pageable);

    List<Message> findAllByUidAndAndExpose(String uid, Boolean expose);

    List<Message> findAllByMessageIdAndAndExpose(Long messageId, Boolean expose);

    Message findByMessageId(Long messageId);
}
