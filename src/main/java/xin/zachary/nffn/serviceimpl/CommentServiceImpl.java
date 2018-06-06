package xin.zachary.nffn.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.zachary.nffn.daoimpl.CommentDAOImpl;
import xin.zachary.nffn.entity.Comment;
import xin.zachary.nffn.service.CommentService;

import java.util.Date;
import java.util.List;

@Service("commentService")
public class CommentServiceImpl extends BaseServiceImpl<Comment> implements CommentService {
    @Autowired
    CommentDAOImpl commentDAO;

    //保存用户的一条评论，传入该用户的username、评论的新闻的id、用户评论的内容
    @Override
    public boolean saveComment(int newsId, String username, String comment) {
        Comment comment1 = new Comment();
        comment1.setNewsId(newsId);
        comment1.setUsername(username);
        comment1.setContent(comment);
        comment1.setDate(new Date());
        return this.save(comment1);
    }

    //传入一条新闻的id，查询该新闻的所有评论
    @Override
    public List queryByNewsId(int newsId) {
        return commentDAO.queryByNewsId(newsId);
    }


}
