package xin.zachary.nffn.service;

import xin.zachary.nffn.entity.Comment;

import java.util.List;

public interface CommentService extends BaseService<Comment> {
    boolean saveComment(int newsId,String username,String comment);
    List queryByNewsId(int newsId);
}
