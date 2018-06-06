package xin.zachary.nffn.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import xin.zachary.nffn.dao.UserPreferenceDAO;
import xin.zachary.nffn.entity.UserPreference;

import java.util.List;

@Repository("userPreferenceDAO")
public class UserPreferenceDAOImpl extends BaseDAOImpl<UserPreference> implements UserPreferenceDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional(rollbackFor = RuntimeException.class)
    public List queryAll(){
        Session session = sessionFactory.getCurrentSession();
        String hql = "select u from UserPreference as u";
        Query query = session.createQuery(hql);
        List list =query.list();
        return list;
    }

    @Override
    public List queryTypeByUsername(String username) {
        String hql = "select u from UserPreference as u where u.type in (select u.type from UserPreference as u where u.username =?0)";
        return sessionFactory.getCurrentSession().createQuery(hql).setParameter(0,username).list();
    }
}
