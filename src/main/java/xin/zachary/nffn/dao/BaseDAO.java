package xin.zachary.nffn.dao;

import java.util.List;

public interface BaseDAO<T> {
    boolean save(T entity);
    boolean saveOrUpdate(T entity);
    boolean update(T entity);
    boolean delete(T entity);
    List<T> queryAll();
    List<T> queryByHql(String hql);
    List<T> queryByUsername(String username);
}
