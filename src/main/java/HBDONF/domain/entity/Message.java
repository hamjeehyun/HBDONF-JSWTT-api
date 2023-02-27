package HBDONF.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "message")
public class Message {
    @Id
    @Column(name = "id", length = 100)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long messageId;
    private String uid;
    private String title;
    private String content;
    private boolean expose;
    private String testRst;
    private int dear;

    private LocalDateTime created;
    private LocalDateTime updated;

    public Message() {

    }

    @Builder
    public Message(Long messageId, String uid, String title, String content, boolean expose, String testRst, LocalDateTime created, LocalDateTime updated, int dear) {
        this.messageId = messageId;
        this.uid = uid;
        this.title = title;
        this.content = content;
        this.expose = expose;
        this.testRst = testRst;
        this.dear = dear;
        this.created = created;
        this.updated = updated;
    }
}
