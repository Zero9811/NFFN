package xin.zachary.nffn.serviceimpl;

import com.google.gson.Gson;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.zachary.nffn.daoimpl.NewsDAOImpl;
import xin.zachary.nffn.entity.News;
import xin.zachary.nffn.json.ArticlesBean;
import xin.zachary.nffn.json.NewsBean;
import xin.zachary.nffn.service.NewsService;

import java.io.*;
import java.util.List;

@Service("newsService")
public class NewsServiceImpl extends BaseServiceImpl<News> implements NewsService {

    @Autowired
    NewsDAOImpl newsDAO;

    //解析json文件，把新闻保存到数据库中
    //批量操作
    //使用dao层重写的save方法
    @Override
    public boolean addNews(String path,String type) {
        StringBuilder strByJson = new StringBuilder();
        try {
            InputStream in = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(in,"UTF-8");
            BufferedReader bufr = new BufferedReader(isr);
            String line = null;
            while ((line = bufr.readLine()) != null) {
                strByJson.append(System.lineSeparator()+line);
            }
            isr.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String result = strByJson.toString();
        System.out.println(result);

        NewsBean newsBean = new Gson().fromJson(result,NewsBean.class);
        List<ArticlesBean> articles = newsBean.getArticles();
        System.out.println(articles.size());
        ArticlesBean articlesBean = new ArticlesBean();
        articlesBean = articles.get(0);
        System.out.println(articlesBean.getSource().getName());
        System.out.println(articlesBean.getSource().getId());

        //保存到数据库
        News news = new News();
        List<News> newsList = null;
        for (int i = 0; i < articles.size(); i++) {


            news.setAuthor(articles.get(i).getAuthor());
            news.setDescription(articles.get(i).getDescription());
            news.setPlatform(articles.get(i).getSource().getName());
            news.setTitle(articles.get(i).getTitle());
            news.setUrl(articles.get(i).getUrl());
            news.setType(type);
            news.setDate(articles.get(i).getPublishedAt());
            //使用dao层重写的save方法
            newsDAO.save(news);
        }

        return false;
    }

    //按照新闻的类型查找新闻
    @Override
    public List queryByType(String newsType) {
        return newsDAO.queryByType(newsType);
    }

    //重写
    public boolean save(News news){
        return newsDAO.save(news);
    }
}
