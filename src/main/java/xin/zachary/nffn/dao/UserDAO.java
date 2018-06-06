package xin.zachary.nffn.dao;

import xin.zachary.nffn.entity.User;

import java.util.List;

public interface UserDAO extends BaseDAO<User>{
    List queryByUsername(String username);
}
