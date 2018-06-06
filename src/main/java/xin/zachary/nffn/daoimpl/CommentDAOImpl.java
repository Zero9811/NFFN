package xin.zachary.nffn.daoimpl;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import xin.zachary.nffn.dao.CommentDAO;
import xin.zachary.nffn.entity.Comment;

import java.util.List;

@Repository("commentDAO")
public class CommentDAOImpl extends BaseDAOImpl<Comment> implements CommentDAO {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public List queryByNewsId(int newsId) {
        String hql = "select c from Comment as c where c.newsId = ?0";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter(0,newsId);
        return query.list();
    }
}
