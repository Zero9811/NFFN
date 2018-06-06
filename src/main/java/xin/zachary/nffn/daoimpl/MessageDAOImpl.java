package xin.zachary.nffn.daoimpl;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import xin.zachary.nffn.dao.MessageDAO;
import xin.zachary.nffn.entity.Message;

import java.util.List;

@Repository("messageDAO")
public class MessageDAOImpl extends BaseDAOImpl<Message> implements MessageDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public List queryChatLog(String sender, String receiver) {
        String hql = "select m from Message as m where m.sender=?0 and receiver =?1";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter(0,sender);
        query.setParameter(1,receiver);
        return query.list();
    }
}
