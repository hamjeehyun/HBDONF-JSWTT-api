package HBDONF.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "id", length = 100)
    private String uid;
    private String tid;
    private String region;
    private String tnickName;
    private LocalDateTime created;
    private LocalDateTime updated;

    public User() {
        super();
    }

    @Builder
    public User(String uid, String tid, String region, String tnickName, LocalDateTime created, LocalDateTime updated) {
        this.uid = uid;
        this.tid = tid;
        this.region = region;
        this.tnickName = tnickName;
        this.created = created;
        this.updated = updated;
    }
}
