package xin.zachary.nffn.service;

import xin.zachary.nffn.entity.Friendship;

import java.util.List;

public interface FriendshipService extends BaseService<Friendship> {
    List queryFriends(String username);
    boolean isFriend(String username1,String username2);
}
