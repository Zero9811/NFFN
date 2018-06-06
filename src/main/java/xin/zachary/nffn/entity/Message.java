package xin.zachary.nffn.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "message",catalog = "nffn")
public class Message {
    @Id
    @GeneratedValue(generator = "native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;
    @Column
    private String sender;
    @Column
    private String receiver;
    @Column
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
