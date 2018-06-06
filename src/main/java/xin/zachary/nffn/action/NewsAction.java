package xin.zachary.nffn.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import xin.zachary.nffn.serviceimpl.NewsServiceImpl;

import java.util.List;
import java.util.Map;

@Controller
public class NewsAction extends ActionSupport {

    @Autowired
    private NewsServiceImpl newsService;

    private String newsType;

    //传入一个特定的新闻类别，返回那一类的所有新闻
    @Action(value = "jumpNews",results = {@Result(location = "/jsp/main.jsp")})
    public String jumpSpecial(){
        System.out.println(newsType);
        List list = newsService.queryByType(newsType);
        System.out.println(list.size());
        Map<String,Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
        request.put("news_list",list);
        return "success";
    }

    public String getNewsType() {
        return newsType;
    }

    public void setNewsType(String newsType) {
        this.newsType = newsType;
    }
}
