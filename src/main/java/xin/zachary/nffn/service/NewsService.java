package xin.zachary.nffn.service;

import xin.zachary.nffn.entity.News;

import java.util.List;

public interface NewsService extends BaseService<News> {
    boolean addNews(String path,String type);
    List queryByType(String newsType);
}
