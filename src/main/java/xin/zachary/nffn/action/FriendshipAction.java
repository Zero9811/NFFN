package xin.zachary.nffn.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import xin.zachary.nffn.entity.Friendship;
import xin.zachary.nffn.serviceimpl.FriendshipServiceImpl;

import java.util.Map;

@Controller
public class FriendshipAction extends ActionSupport {

    private String username;

    @Autowired
    private FriendshipServiceImpl friendshipService;

    //传入一个用户名，得到该用户的所有朋友
    public String showFriends(){
        return null;
    }

    //传入一个想添加的用户的用户名，生成两个用户的好友关系
    public String addFriend(){
        Map<String,Object> session = ActionContext.getContext().getSession();
        //先查询两者是否为好友
        if(!friendshipService.isFriend((String) session.get("username"),username)){
            Friendship friendship = new Friendship();
            friendship.setFriend1((String) session.get("username"));
            friendship.setFriend2(username);
            friendshipService.save(friendship);
            return "success";
        }
        else
            //添加错误，两个人已经为好友。
            return "error";
    }

    //传入一个想删除的用户名，在数据库中解除两个用户的好友关系
    public String deleteFriend(){
        return null;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
