package xin.zachary.nffn.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import xin.zachary.nffn.entity.User;
import xin.zachary.nffn.serviceimpl.UserServiceImpl;

import java.util.Date;
import java.util.List;

@Controller
@ParentPackage("struts-default")
@Namespace("/")
@Scope("prototype")
public class RegisterAction extends ActionSupport {
    private String username;
    private String password;
    private String password2;

    @Autowired
    private UserServiceImpl userService;

    @Action(value = "register22",results = {@Result(name = "login",location = "/jsp/login.jsp"),@Result(name = "register",location = "/jsp/register.jsp")})
    public String register(){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRegistrationDate(new Date());
        boolean result = userService.save(user);
        return result?"login":"register";
    }

    public void validate(){
        if(!this.password2.equals(password))
            addFieldError("password1", "两次密码不一致");
        else{
            List list = userService.queryByUsername(username);
            if(list.size()==0)
                addFieldError("password1", "该用户已存在");
        }
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

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }
}
