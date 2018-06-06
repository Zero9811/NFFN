package xin.zachary.nffn.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "user_mapping",catalog = "nffn")
public class UserMapping {
    @Id
    @GeneratedValue(generator = "native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;
    @Column
    private Date mappingDate;
    @Column
    private String user1;
    @Column
    private String user2;
    @Column
    private boolean isFriend;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getMappingDate() {
        return mappingDate;
    }

    public void setMappingDate(Date mappingDate) {
        this.mappingDate = mappingDate;
    }

    public String getUser1() {
        return user1;
    }

    public void setUser1(String user1) {
        this.user1 = user1;
    }

    public String getUser2() {
        return user2;
    }

    public void setUser2(String user2) {
        this.user2 = user2;
    }

    public boolean isFriend() {
        return isFriend;
    }

    public void setFriend(boolean friend) {
        isFriend = friend;
    }
}
