package xin.zachary.nffn.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import xin.zachary.nffn.serviceimpl.UserPreferenceServiceImpl;

import java.util.List;
import java.util.Map;

@Controller
public class UserPreferenceAction extends ActionSupport {

    @Autowired
    private UserPreferenceServiceImpl userPreferenceService;

    @Action(results = {@Result(location = "/jsp/showSimilarity.jsp")})
    public String showSimilarity(){
        Map<String,Object> session = ActionContext.getContext().getSession();
        List list = userPreferenceService.queryTypeByUsername((String) session.get("username"));
        Map<String,Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
        request.put("similar_list",list);
        return "success";
    }
}
