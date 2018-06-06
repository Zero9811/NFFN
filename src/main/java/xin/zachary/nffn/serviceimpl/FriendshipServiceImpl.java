package xin.zachary.nffn.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.zachary.nffn.daoimpl.FriendshipDAOImp;
import xin.zachary.nffn.entity.Friendship;
import xin.zachary.nffn.service.FriendshipService;

import java.util.List;

@Service("friendshipService")
public class FriendshipServiceImpl extends BaseServiceImpl<Friendship> implements FriendshipService {

    @Autowired
    FriendshipDAOImp friendshipDAO;

    //输入的用户名是自己的用户名，用来展示好友列表
    public List queryFriends(String username){
        return friendshipDAO.queryFriends(username);
    }

    @Override
    public boolean isFriend(String username1, String username2) {
        return friendshipDAO.isFriend(username1,username2);
    }

}
