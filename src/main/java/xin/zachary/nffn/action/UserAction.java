package xin.zachary.nffn.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import xin.zachary.nffn.entity.User;
import xin.zachary.nffn.service.UserService;
import xin.zachary.nffn.serviceimpl.UserServiceImpl;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@ParentPackage("struts-default")
@Namespace("/")
@Scope("prototype")
public class UserAction  extends ActionSupport implements ModelDriven<User> {

    private String password2;

    User user = new User();

    @Autowired
    private UserServiceImpl userService;

    @Override
    public User getModel() {
        return user;
    }

    //登录用的action
    @Action(value = "login",results = {@Result(name = "main",location = "/jsp/main.jsp"),@Result(name = "login",location = "/jsp/login.jsp")})
    public String login(){
        //存储登录时间
        boolean result = userService.updateLoginTime(user);
        //保存登录状态
        Map<String,Object> session = ActionContext.getContext().getSession();
        session.put("username",user.getUsername());
        session.put("nickname",user.getNickname());
        return result==true?"main":"login";
    }

    //注册用的action
    @Action(value = "register",results = {@Result(name = "login",location = "/jsp/login.jsp"),@Result(name = "input",location = "/jsp/register.jsp")})
    public String register(){
        user.setRegistrationDate(new Date());
        user.setNickname(user.getUsername());
        boolean result = userService.save(user);
        return result?"login":"input";
    }

    //注销用的action,删除session里面存储的内容
    @Action(value = "logout",results = {@Result(name = "index",location = "/index.jsp")})
    public String logout(){
        Map<String,Object> session = ActionContext.getContext().getSession();
        session.remove("username");
        session.remove("nickname");
        return "index";
    }

    //修改个人信息的action
    public String modifyInfoAction(){
        Map<String,Object> session = ActionContext.getContext().getSession();
        String username = (String) session.get("username");
        List list = userService.queryByUsername(username);

        User user1 = (User) list.get(0);
        user1.setAge(user.getAge());
        user1.setGender(user.getGender());
        user1.setMajor(user.getMajor());
        user1.setNickname(user.getNickname());
        if(userService.save(user1))
            return "success";
        else
        return "error";
    }

    //展示个人信息的action,页面需要传入一个用户的用户名
    //查询的信息存储到request中供前端调用
    public String showInfoAction(){
        List list = userService.queryByUsername(user.getUsername());
        ActionContext.getContext().put("userInfo",list);
        return SUCCESS;
    }

    public void validateRegister(){
        System.out.println(userService);
        System.out.println("测试信息");
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        if(!this.password2.equals(user.getPassword()))
            addFieldError("password1", "两次密码不一致");
        else{
            List list = userService.queryByUsername(user.getUsername());
            if(list.size()!=0) {
                System.out.println("exist");
                addFieldError("password1", "该用户已存在");
            }
        }

    }

    public void validateLogin(){
        List list = userService.queryByUsername(user.getUsername());
        if(list.size()==0)
            addFieldError("password1", "用户名不存在");
        if(!((User)list.get(0)).getPassword().equals(user.getPassword()))
            addFieldError("password1", "密码错误");
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }
}
