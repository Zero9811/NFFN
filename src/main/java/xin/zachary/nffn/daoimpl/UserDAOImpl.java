package xin.zachary.nffn.daoimpl;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import xin.zachary.nffn.dao.UserDAO;
import xin.zachary.nffn.entity.User;

import java.util.List;

@Repository("userDAO")
public class UserDAOImpl extends BaseDAOImpl<User> implements UserDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public List queryByUsername(String username){
        String hql = "select u from User as u where u.username =?0";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter(0,username);
        return query.list();
    }
}
