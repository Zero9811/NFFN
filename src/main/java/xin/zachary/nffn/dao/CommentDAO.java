package xin.zachary.nffn.dao;

import xin.zachary.nffn.entity.Comment;

import java.util.List;

public interface CommentDAO extends BaseDAO<Comment>{
    List queryByNewsId(int newsId);
}
