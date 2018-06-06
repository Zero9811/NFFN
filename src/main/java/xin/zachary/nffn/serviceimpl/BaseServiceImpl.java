package xin.zachary.nffn.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.zachary.nffn.daoimpl.BaseDAOImpl;
import xin.zachary.nffn.service.BaseService;

import java.util.List;

@Service("baseService")
public class BaseServiceImpl<T> implements BaseService<T> {

    @Autowired
    private BaseDAOImpl<T> baseDAO;

    @Override
    public boolean save(T entity) {
        return baseDAO.save(entity);
    }

    @Override
    public boolean saveOrUpdate(T entity) {
        return baseDAO.save(entity);
    }

    @Override
    public boolean update(T entity) {
        return baseDAO.update(entity);
    }

    @Override
    public boolean delete(T entity) {
        return baseDAO.delete(entity);
    }

    @Override
    public List<T> queryAll() {
        return baseDAO.queryAll();
    }

    @Override
    public List<T> queryByHql(String hql) {
        return baseDAO.queryByHql(hql);
    }

    @Override
    public List<T> queryByUsername(String username) {
        return baseDAO.queryByUsername(username);
    }
}
