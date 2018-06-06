package xin.zachary.nffn.dao;

import xin.zachary.nffn.entity.News;

import java.util.List;

public interface NewsDAO extends BaseDAO<News>{
    List queryByType(String newsType);
}
