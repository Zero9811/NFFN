package xin.zachary.nffn.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_info",catalog = "nffn")
public class User{
    @Id
    private String username;
    @Column
    private String password;
    @Column
    private String nickname;
    @Column
    private String email;
    @Column(name = "registration_date")
    private Date registrationDate;
    @Column
    private int age;
    @Column
    private String gender;
    @Column
    private String major;
    @Column(name = "last_login_time")
    private Date lastLoginTime;

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
}
