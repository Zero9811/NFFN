package xin.zachary.nffn.service;

import xin.zachary.nffn.entity.User;

import java.util.List;

public interface UserService extends BaseService<User> {
    boolean updateLoginTime(User user);
    List queryByUsername(String username);

}
