package xin.zachary.nffn.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.zachary.nffn.daoimpl.UserDAOImpl;
import xin.zachary.nffn.entity.User;
import xin.zachary.nffn.service.UserService;

import java.util.Date;
import java.util.List;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
    @Autowired
    private UserDAOImpl userDAO;
    //记录登录的时间
    @Override
    public boolean updateLoginTime(User user) {
        List list = this.queryByUsername(user.getUsername());
        user = (User) list.get(0);
        user.setLastLoginTime(new Date());

        return this.update(user);
    }

    public List queryByUsername(String username){
       return userDAO.queryByUsername(username);
    }
}
