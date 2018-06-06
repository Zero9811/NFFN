package xin.zachary.nffn.dao;

import xin.zachary.nffn.entity.Friendship;

import java.util.List;

public interface FriendshipDAO extends BaseDAO<Friendship>{
    //朋友列表的查找方式要用queryFriends,不能用基本的queryByUsername
    List queryFriends(String username);

    boolean isFriend(String username1,String username2);

}
