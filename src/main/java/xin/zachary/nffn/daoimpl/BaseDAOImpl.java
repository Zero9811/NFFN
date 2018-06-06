package xin.zachary.nffn.daoimpl;
/*
    基础的dao层实现类
    实现了数据库的基本的增删改查功能
    查询包括按照hql语句查询和查询所有的查询
 */
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import xin.zachary.nffn.dao.BaseDAO;

import java.util.List;

@Repository("baseDAO")
public class BaseDAOImpl<T>  implements BaseDAO<T> {
    @Autowired
    private SessionFactory sessionFactory;


    //保存实体到数据库
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public boolean save(T entity) {
        boolean result = false;
        try {
            this.sessionFactory.getCurrentSession().save(entity);
            System.out.println("保存到数据库了吗");
            result = true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }


    //保存或者更新实体到数据库
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public boolean saveOrUpdate(T entity) {
        boolean result = false;
        try{
            this.sessionFactory.getCurrentSession().saveOrUpdate(entity);
            result = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public boolean update(T entity) {
        boolean result = false;
        try{
            this.sessionFactory.getCurrentSession().update(entity);
            result = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public boolean delete(T entity) {
        boolean result = false;
        try {
            this.sessionFactory.getCurrentSession().delete(entity);
            result = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public List<T> queryAll() {
        return null;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public List<T> queryByHql(String hql) {
        return null;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public List<T> queryByUsername(String username) {
        return null;
    }
}
