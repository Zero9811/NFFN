package xin.zachary.nffn.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import xin.zachary.nffn.dao.NewsDAO;
import xin.zachary.nffn.entity.News;

import java.util.List;

@Repository("newsDAO")
public class NewsDAOImpl extends BaseDAOImpl<News> implements NewsDAO {
    @Autowired
    SessionFactory sessionFactory;
    //实现批量保存，每次保存都刷新缓存，后期优化
    @Transactional(rollbackFor = RuntimeException.class)
    public  boolean save(News news){
        Session session = sessionFactory.getCurrentSession();
        session.save(news);
        session.flush();
        session.clear();
        return true;
    }

    //按照新闻的类型查找新闻
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public List queryByType(String newsType) {
        String hql = "select n from News as n where n.type=?0 order by n.id desc";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter(0,newsType);
        return query.list();
    }
}
