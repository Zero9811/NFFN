package xin.zachary.nffn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_preference",catalog = "nffn")
public class UserPreference {
    @Id
    private String username;
    //每个人的性格指数
    @Column
    private int charactor;
    //以下几个属性为新闻的类别
    @Column
    private int business;
    @Column
    private int entertainment;
    @Column
    private int health;
    @Column
    private int science;
    @Column
    private int sports;
    @Column
    private int technology;
    //type记录用户所属的聚类的类型
    @Column
    private int type;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getCharactor() {
        return charactor;
    }

    public void setCharactor(int charactor) {
        this.charactor = charactor;
    }

    public int getBusiness() {
        return business;
    }

    public void setBusiness(int business) {
        this.business = business;
    }

    public int getEntertainment() {
        return entertainment;
    }

    public void setEntertainment(int entertainment) {
        this.entertainment = entertainment;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getScience() {
        return science;
    }

    public void setScience(int science) {
        this.science = science;
    }

    public int getSports() {
        return sports;
    }

    public void setSports(int sports) {
        this.sports = sports;
    }

    public int getTechnology() {
        return technology;
    }

    public void setTechnology(int technology) {
        this.technology = technology;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
