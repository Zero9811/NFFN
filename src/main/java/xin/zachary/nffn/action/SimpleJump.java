package xin.zachary.nffn.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("simpleJump")
@ParentPackage("struts-default")
@Namespace("/")
@Scope("prototype")
public class SimpleJump extends ActionSupport {
    @Action(value = "jump",results ={@Result(name = "success",location = "/jsp/success.jsp")} )
    public String execute(){
        return SUCCESS;
    }
    @Action(value = "loginJump",results = {@Result(name = "success",location = "/jsp/login.jsp")})
    public String loginJump(){
        return SUCCESS;
    }
    @Action(value = "registerJump",results = {@Result(name = "success",location = "/jsp/register.jsp")})
    public String registerJump(){
        return SUCCESS;
    }
}
