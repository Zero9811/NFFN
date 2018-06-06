package xin.zachary.nffn.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import xin.zachary.nffn.dao.FriendshipDAO;
import xin.zachary.nffn.entity.Friendship;

import java.util.List;

@Repository("friendshipDAO")
public class FriendshipDAOImp extends BaseDAOImpl<Friendship> implements FriendshipDAO {
    @Autowired
    SessionFactory sessionFactory;

    //查询一个用户的所有朋友
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public List queryFriends(String username) {
        List friends = null;

        Session session = sessionFactory.getCurrentSession();
        String hql = "select f from Friendship as f where f.friend1=?0 ";
        org.hibernate.query.Query query = session.createQuery(hql);
        query.setParameter(0,username);
        List list=query.list();
        for (int i = 0; i < list.size(); i++) {
            friends.add(i,list.get(i));
        }
        hql = "select f from Friendship as f where f.friend2=?1";
        query = session.createQuery(hql);
        query.setParameter(1,username);
        list = query.list();
        for (int i = 0; i < list.size(); i++) {
            friends.add(i,list.get(i));
        }

        return friends;
    }

    @Override
    public boolean isFriend(String username1, String username2) {
        String hql = "select f from Friendship as f where f.friend1 = ?0 and f.friend2 = ?1";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter(0,username1);
        query.setParameter(1,username2);
        List list = query.list();
        if(list.size()==0){
            query.setParameter(0,username2);
            query.setParameter(1,username1);
            list = query.list();
            if (list.size()==0)
                return false;
        }
        return true;
    }
}
